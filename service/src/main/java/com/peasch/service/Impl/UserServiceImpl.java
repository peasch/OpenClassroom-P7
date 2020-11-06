package com.peasch.service.Impl;

import com.mysql.cj.xdevapi.Client;
import com.peasch.model.dto.UserDto;
import com.peasch.model.dto.mapper.UserMapper;
import com.peasch.model.entities.Role;
import com.peasch.model.entities.User;
import com.peasch.repository.dao.UserDao;
import com.peasch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserMapper userMapper;


    public List<UserDto> getUsers() {
        List<UserDto> userDtos = new ArrayList<>();
        List<User> users = userDao.findAll();

        for(User user :users){
            userDtos.add(userMapper.fromUserToDto(user));
        }
        return userDtos;
    }

    public UserDto findById(Integer id) {
        return userMapper.fromUserToDto(userDao.findById(id).get());

    }

    public UserDto save(UserDto userDto) {
        return userMapper.fromUserToDto(userDao.save(userMapper.fromDtoToUser(userDto)));

    }

    public UserDto findUserByUsername(String username){
    return userMapper.fromUserToDto(userDao.findByUserName(username));
    }

}
