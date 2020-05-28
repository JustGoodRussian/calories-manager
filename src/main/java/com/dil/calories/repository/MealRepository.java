package com.dil.calories.repository;

import com.dil.calories.model.Meal;

import java.util.List;

public interface MealRepository {

    void save(Meal meal, int userId);

    void delete(int id, int userId);

    Meal get(int id, int userId);

    List<Meal> getAll(int userId);

}
