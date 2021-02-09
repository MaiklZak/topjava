package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;

import java.util.Map;

public interface StorageMeals {
    void add(Meal meal);
    void update(int id, Meal meal);
    void delete(int id);
    Map<Integer, Meal> allMeals();

}
