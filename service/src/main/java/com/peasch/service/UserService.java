package com.peasch.service;

import com.peasch.model.entities.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();
    User findById(Integer id);
    User save(User user);

}
