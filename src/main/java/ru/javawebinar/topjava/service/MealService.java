package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;

import java.util.Collection;

public class MealService {

    private MealRepository repository;

    public MealService(MealRepository repository) {
        this.repository = repository;
    }

    public Meal create(Meal meal) {
        return repository.save(meal);
    }

    public Meal get(int userId, int id) {
        return repository.get(userId, id);
    }

    public void delete(int userId, int id) {
        repository.delete(userId, id);
    }

    public void update(Meal meal) {
        repository.save(meal);
    }

    public Collection<Meal> getAll() {
        return repository.getAll();
    }
}