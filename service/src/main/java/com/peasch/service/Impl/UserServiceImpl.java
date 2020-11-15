package com.peasch.service.Impl;

import com.mysql.cj.xdevapi.Client;
import com.peasch.model.dto.UserDto;
import com.peasch.model.dto.mapper.BorrowingMapper;
import com.peasch.model.dto.mapper.RoleMapper;
import com.peasch.model.dto.mapper.UserMapper;
import com.peasch.model.entities.Role;
import com.peasch.model.entities.User;
import com.peasch.repository.dao.BorrowingDao;
import com.peasch.repository.dao.UserDao;
import com.peasch.service.BorrowingService;
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
    private BorrowingDao borrowingDao;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private BorrowingService borrowingService;

    public List<UserDto> getUsers() {
        List<UserDto> userDtos = new ArrayList<>();
        List<User> users = userDao.findAll();

        for(User user :users){
            userDtos.add(userMapper.fromUserToDto(user));
        }
        return userDtos;
    }

    public UserDto findById(Integer id) {

        UserDto userDto=userMapper.fromUserToDto(userDao.findById(id).get());
        userDto.setRoles(userMapper.fromRolesToDto(userDao.findById(id).get().getRoles()));

        return userDto;

    }

    public UserDto save(UserDto userDto) {
        return userMapper.fromUserToDto(userDao.save(userMapper.fromDtoToUser(userDto)));

    }

    public UserDto findUserByUserName(String userName){
        User user =userDao.findByUserName(userName);
        UserDto userDto=userMapper.fromUserToDto(user);
        userDto.setRoles(userMapper.fromRolesToDto(user.getRoles()));
        userDto.setBorrowings(borrowingService.findBorrowingsByUserId(user.getId()));

    return userDto;
    }


}
