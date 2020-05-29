package com.dil.calories.util;

import com.dil.calories.model.Meal;
import com.dil.calories.to.MealTo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MealsUtil {

    public static final int DEFAULT_CALORIES_PER_DAY = 2000;

    public static void main(String[] args) {
        List<Meal> meals = Arrays.asList(
                new Meal(LocalDateTime.of(2020, Month.MAY, 29, 10, 0), "Завтрак", 500),
                new Meal(LocalDateTime.of(2020, Month.MAY, 29, 13, 0), "Обед", 1000),
                new Meal(LocalDateTime.of(2020, Month.MAY, 29, 20, 0), "Ужин", 500),
                new Meal(LocalDateTime.of(2020, Month.MAY, 30, 10, 0), "Завтрак", 500),
                new Meal(LocalDateTime.of(2020, Month.MAY, 30, 13, 0), "Обед", 1000),
                new Meal(LocalDateTime.of(2020, Month.MAY, 30, 20, 0), "Ужин", 500),
                new Meal(LocalDateTime.of(2020, Month.MAY, 31, 10, 0), "Завтрак", 1000),
                new Meal(LocalDateTime.of(2020, Month.MAY, 31, 13, 0), "Обед", 500),
                new Meal(LocalDateTime.of(2020, Month.MAY, 31, 20, 0), "Ужин", 510)
        );

        List<MealTo> mealsWithExcess =
                getWithExcess(meals, DEFAULT_CALORIES_PER_DAY, LocalTime.of(7, 0), LocalTime.of(12, 0));
        mealsWithExcess.forEach(System.out::println);
    }

    public static List<MealTo> getWithExcess(List<Meal> meals, int caloriesPerDay, LocalTime startTime, LocalTime endTime) {
        Map<LocalDate, Integer> caloriesSumByDate = meals.stream()
                .collect(Collectors.groupingBy(meal -> meal.getDateTime().toLocalDate(), Collectors.summingInt(Meal::getCalories)));

        return meals.stream()
                .filter(meal -> TimeUtil.isBetween(meal.getDateTime().toLocalTime(), startTime, endTime))
                .map(meal -> new MealTo(meal.getDateTime(), meal.getDescription(), meal.getCalories(),
                        caloriesSumByDate.get(meal.getDateTime().toLocalDate()) > caloriesPerDay))
                .collect(Collectors.toList());
    }

}
