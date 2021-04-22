package ru.javawebinar.topjava.web.meal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.util.MealsUtil;
import ru.javawebinar.topjava.web.SecurityUtil;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static ru.javawebinar.topjava.util.DateTimeUtil.parseLocalDate;
import static ru.javawebinar.topjava.util.DateTimeUtil.parseLocalTime;

@Controller
@RequestMapping("meals")
public class MealJspController {

    private final MealService mealService;

    public MealJspController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("meals", mealService.getAll(SecurityUtil.authUserId()));
        return "meals";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("meal",
                new Meal(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS), "", 1000));
        return "mealForm";
    }

    @GetMapping("update")
    public String update(HttpServletRequest request, Model model) {
        int mealId = Integer.parseInt(request.getParameter("id"));
        model.addAttribute("meal", mealService.get(mealId, SecurityUtil.authUserId()));
        return "mealForm";
    }

    @PostMapping
    public String updateOrCreate(HttpServletRequest request) {
        Meal meal = new Meal(LocalDateTime.parse(request.getParameter("dateTime")),
                request.getParameter("description"),
                Integer.parseInt(request.getParameter("calories")));

        if (request.getParameter("id").isEmpty()) {
            mealService.create(meal, SecurityUtil.authUserId());
        } else {
            mealService.update(meal, SecurityUtil.authUserId());
        }
        return "redirect:meals";
    }

    @GetMapping("/filter")
    public String getBetween(HttpServletRequest request, Model model) {
        LocalDate startDate = parseLocalDate(request.getParameter("startDate"));
        LocalDate endDate = parseLocalDate(request.getParameter("endDate"));
        LocalTime startTime = parseLocalTime(request.getParameter("startTime"));
        LocalTime endTime = parseLocalTime(request.getParameter("endTime"));

        int userId = SecurityUtil.authUserId();
        List<Meal> mealsDate = mealService.getBetweenInclusive(startDate, endDate, userId);


        model.addAttribute("meals",
                MealsUtil.getFilteredTos(mealsDate, SecurityUtil.authUserCaloriesPerDay(), startTime, endTime));
        return "meals";
    }

    @GetMapping("delete")
    public String delete(HttpServletRequest request) {
        int mealId = Integer.parseInt(request.getParameter("id"));
        mealService.delete(mealId, SecurityUtil.authUserId());
        return "redirect:meals";
    }
}
