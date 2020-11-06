package com.peasch.repository.dao;

import com.peasch.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer>{
    User findByUserName(String username);
}
