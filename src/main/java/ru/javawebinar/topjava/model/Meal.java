package ru.javawebinar.topjava.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Meal extends AbstractBaseEntity {

    private Integer Userid;

    private final LocalDateTime dateTime;

    private final String description;

    private final int calories;

    public Meal(LocalDateTime dateTime, String description, int calories, Integer userid) {
        this(null, dateTime, description, calories, userid);
    }

    public Meal(Integer id, LocalDateTime dateTime, String description, int calories, Integer userid) {
        super(id);
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.Userid = userid;
    }

    public Integer getUserid() {
        return Userid;
    }

    public void setUserid(Integer userid) {
        Userid = userid;
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

    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }

    public LocalTime getTime() {
        return dateTime.toLocalTime();
    }


    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                '}';
    }
}
