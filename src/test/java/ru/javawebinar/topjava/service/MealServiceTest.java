package ru.javawebinar.topjava.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static ru.javawebinar.topjava.MealTestData.*;

import ru.javawebinar.topjava.UserTestData;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceTest {

    static {
        SLF4JBridgeHandler.install();
    }

    @Autowired
    private MealService service;

    @Test
    public void get() {
        Meal mealGet = service.get(mealCheck.getId(), UserTestData.USER_ID);
        assertThat(mealGet).usingRecursiveComparison().ignoringFields("dateTime").isEqualTo(mealCheck);
    }

    @Test
    public void delete() {
        service.delete(mealCheck.getId(), UserTestData.USER_ID);
        assertThrows(NotFoundException.class, () -> service.get(mealCheck.getId(), UserTestData.USER_ID));
    }

    @Test
    public void getBetweenInclusive() {
        List<Meal> betweenInclusive = service.getBetweenInclusive(LocalDate.of(2020, Month.JANUARY, 30),
                LocalDate.of(2020, Month.JANUARY, 30), UserTestData.USER_ID);
        assertThat(betweenInclusive).usingRecursiveComparison().ignoringFields("dateTime").isEqualTo(listMealsBetween);
    }

    @Test
    public void getAll() {
        List<Meal> actualList = service.getAll(UserTestData.USER_ID);
        System.out.println(actualList);
        System.out.println(listMealsAll);
        assertThat(actualList).usingRecursiveComparison().ignoringFields("dateTime").isEqualTo(listMealsAll);
    }

    @Test
    public void update() {
        service.update(mealUpdate, UserTestData.USER_ID);
        assertThat(mealUpdate).usingRecursiveComparison().ignoringFields("dateTime")
                .isEqualTo(service.get(mealUpdate.getId(), UserTestData.USER_ID));

    }

    @Test
    public void create() {
        Meal mealCreated = service.create(mealNew, UserTestData.USER_ID);
        mealNew.setId(mealCreated.getId());
        assertThat(mealNew).usingRecursiveComparison().ignoringFields("dateTime")
                .isEqualTo(service.get(mealNew.getId(), UserTestData.USER_ID));
    }

    @Test
    public void deleteNotFound() {
        assertThrows(NotFoundException.class, () -> service.get(mealCheck.getId(), UserTestData.NOT_FOUND));
    }

    @Test
    public void getNotFound() {
        assertThrows(NotFoundException.class, () -> service.get(mealCheck.getId(), UserTestData.NOT_FOUND));
    }

    @Test
    public void duplicateDateTimeCreate() {
        assertThrows(DataAccessException.class, () -> service.update(mealUpdate, UserTestData.NOT_FOUND));
    }
}