package com.dil.calories.repository;

import com.dil.calories.model.User;

import java.util.List;

public interface UserRepository {

    void save(User user);

    void delete(int id);

    User get(int id);

    List<User> getAll();

}
