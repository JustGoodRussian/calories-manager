package com.dil.calories.service;

import com.dil.calories.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    void delete(int id);

    User get(int id);

    List<User> getAll();

}
