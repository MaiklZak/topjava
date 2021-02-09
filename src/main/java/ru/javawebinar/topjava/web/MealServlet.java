package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.service.StorageMeals;
import ru.javawebinar.topjava.service.StorageMealsImplMap;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);
    private StorageMeals storageMeals = new StorageMealsImplMap();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("forward to meals");
        List<MealTo> mealTos = MealsUtil.filteredByStreams(new ArrayList<>(storageMeals.allMeals().values()), LocalTime.MIN, LocalTime.MAX,
                MealsUtil.MAX_CALORIES_IN_DAY);
        req.setAttribute("listMealTo", mealTos);
        req.getRequestDispatcher("meals.jsp").forward(req, resp);
    }
}
