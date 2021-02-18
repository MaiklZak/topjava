package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;

import java.util.Collection;

@Controller
public class MealRestController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MealService service;

    public Meal create(int userId, Meal meal) {
        log.info("create {}", meal);
        return service.create(userId, meal);
    }

    public Meal get(int userId, int id) {
        log.info("get {} for user {}", id, userId);
        return service.get(userId, id);
    }

    public void delete(int userId, int id) {
        log.info("delete {} for user {}", id, userId);
        service.delete(userId, id);
    }

    public void update(int userId, Meal meal) {
        log.info("update {}", meal);
        service.update(userId, meal);
    }

    public Collection<Meal> getAll(int userId) {
        log.info("getAll");
        return service.getAll(userId);
    }
}