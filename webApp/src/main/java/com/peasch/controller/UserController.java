package com.peasch.controller;

import com.peasch.model.entities.User;
import com.peasch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/users")
    public List<User> getUsers(){
        return service.getUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable(value = "id")Integer id){
        return service.findById(id);
    }

    @PostMapping("/user/add")
    public void addUser (@RequestBody User user){
        service.saveUser(user);
    }
}
