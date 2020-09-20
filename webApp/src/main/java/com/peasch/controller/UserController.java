package com.peasch.controller;

import com.peasch.model.dto.UserDto;
import com.peasch.model.dto.mapper.UserMapper;
import com.peasch.model.entities.User;
import com.peasch.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImpl service;

    @GetMapping
    public List<UserDto> getUsers() {
        return service.getUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value = "id") Integer id) {
        User user = service.findById(id);

        return user;
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user) {
        service.save(user);
    }
}
