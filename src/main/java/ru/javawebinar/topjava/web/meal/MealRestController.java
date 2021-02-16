package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;

import java.util.Collection;

@Controller
public class MealRestController {

    @Autowired
    private MealService service;

    public Meal create(Meal meal) {
        return service.create(meal);
    }

    public Meal get(int userId, int id) {
        return service.get(userId, id);
    }

    public void delete(int userId, int id) {
        service.delete(userId, id);
    }

    public void update(Meal meal) {
        service.update(meal);
    }

    public Collection<Meal> getAll() {
        return service.getAll();
    }
}