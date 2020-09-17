package com.peasch.service.Impl;

import com.peasch.model.entities.User;
import com.peasch.repository.dao.UserDao;
import com.peasch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getUsers(){
        return userDao.findAll();
    }

    public User findById(Integer id){
        return userDao.findById(id).get();

    }

    public User save(User user){
        return userDao.save(user);
    }
}
