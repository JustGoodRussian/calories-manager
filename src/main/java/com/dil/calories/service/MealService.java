package com.dil.calories.service;

import com.dil.calories.model.Meal;

import java.util.List;

public interface MealService {

    void save(Meal meal, int userId);

    void delete(int id, int userId);

    Meal get(int id, int userId);

    List<Meal> getAll(int userId);


}
