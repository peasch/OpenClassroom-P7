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
    public UserDto getUserById(@PathVariable(value = "id") Integer id) {
        UserDto userDto = service.findById(id);

        return userDto;
    }

    @PostMapping("/add")
    public void addUser(@RequestBody UserDto userDto) {
        service.save(userDto);
    }
}
