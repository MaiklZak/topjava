package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.Map;
import java.util.stream.Collectors;

public class StorageMealsImplMap implements StorageMeals {
    public static Map<Integer, Meal> mealMap;

    static {
        mealMap = MealsUtil.getListMeals().stream()
                .collect(Collectors.toMap(Meal::getId, meal -> meal));
    }

    @Override
    public void add(Meal meal) {
        mealMap.put(meal.getId(), meal);
    }

    @Override
    public void update(int id, Meal meal) {
        mealMap.put(id, meal);
    }

    @Override
    public void delete(int id) {
        mealMap.remove(id);
    }

    @Override
    public Map<Integer, Meal> allMeals() {
        return mealMap;
    }
}
