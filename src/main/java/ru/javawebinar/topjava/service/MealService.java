package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.ValidationUtil;

import java.util.Collection;

@Service
public class MealService {

    private final MealRepository repository;

    public MealService(MealRepository repository) {
        this.repository = repository;
    }

    public Meal create(Meal meal) {
        return repository.save(meal);
    }

    public Meal get(int userId, int id) {
        return ValidationUtil.checkNotFoundWithIdOrUnknownUser(repository.get(userId, id), id, userId);
    }

    public void delete(int userId, int id) {
        ValidationUtil.checkNotFoundWithIdOrUnknownUser(repository.delete(userId, id), id, userId);
    }

    public void update(Meal meal) {
        ValidationUtil.checkNotFoundWithId(repository.save(meal), meal.getId());
    }

    public Collection<Meal> getAll() {
        return repository.getAll();
    }
}