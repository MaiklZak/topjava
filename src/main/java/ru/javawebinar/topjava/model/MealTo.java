package ru.javawebinar.topjava.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

public class MealTo {
    private static final AtomicInteger idCountMealTo = new AtomicInteger();

    private final int id;

    private final LocalDateTime dateTime;

    private final String description;

    private final int calories;

    private final boolean excess;

    private final String dateForm;


    public MealTo(LocalDateTime dateTime, String description, int calories, boolean excess) {
        this.id = idCountMealTo.incrementAndGet();
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.excess = excess;
        dateForm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(this.dateTime);;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public boolean isExcess() {
        return excess;
    }

    @Override
    public String toString() {
        return "MealTo{" +
                "dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                ", excess=" + excess +
                '}';
    }

    public String getDateForm() {
        return dateForm;
    }
}
