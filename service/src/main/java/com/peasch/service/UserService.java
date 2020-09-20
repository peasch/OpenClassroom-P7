package com.peasch.service;

import com.peasch.model.dto.UserDto;
import com.peasch.model.entities.User;

import java.util.List;

public interface UserService {

    List<UserDto> getUsers();
    UserDto findById(Integer id);
    UserDto save(UserDto userDto);

}
