package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class MealTestData {

    public static final Meal mealCheck = new Meal(100002, LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Breakfast", 500);
    public static final Meal meal1 = new Meal(100003, LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Lunch", 1000);
    public static final Meal meal2 = new Meal(100004, LocalDateTime.of(2020, Month.JANUARY, 30, 19, 0), "Dinner", 850);
    public static final Meal meal3 = new Meal(100005, LocalDateTime.of(2020, Month.JANUARY, 31, 10, 30), "Breakfast", 700);
    public static final Meal meal4 = new Meal(100006, LocalDateTime.of(2020, Month.JANUARY, 31, 13, 30), "Lunch", 1100);
    public static final Meal meal5 = new Meal(100007, LocalDateTime.of(2020, Month.JANUARY, 31, 19, 0), "Dinner", 650);

    public static final Meal mealUpdate = new Meal(100002, LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "UpdateBreak", 3000);

    public static final Meal mealNew = new Meal(null, LocalDateTime.of(2020, Month.JANUARY, 31, 14, 0), "NewLunch", 2000);

    public static final List<Meal> listMeals = new ArrayList<>();
    public static final List<Meal> listMealsBetween = new ArrayList<>();
    public static final List<Meal> listMealsAll = new ArrayList<>();


    static {
        listMeals.add(mealCheck);
        listMeals.add(meal1);
        listMeals.add(meal2);
        listMeals.add(meal3);
        listMeals.add(meal4);
        listMeals.add(meal5);

        listMealsAll.add(mealCheck);
        listMealsAll.add(meal1);
        listMealsAll.add(meal2);
        listMealsAll.add(meal3);
        listMealsAll.sort((m1, m2) -> m2.getDateTime().compareTo(m1.getDateTime()));


        listMealsBetween.add(mealCheck);
        listMealsBetween.add(meal1);
        listMealsBetween.add(meal2);
        listMealsBetween.sort((m1, m2) -> m2.getDateTime().compareTo(m1.getDateTime()));
    }
}