package com.peasch.repository.dao.Impl;

import com.peasch.model.entities.User;
import com.peasch.repository.dao.UserDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
@Repository
public class UserDaoImpl{

   /* @PersistenceContext
    EntityManager em;

    @Override
    public User saveUser(User user) {
        em.persist(user);
        return null;
    }

    @Override
    public User getUserById(Integer id) {
        return em.find(User.class,id);
    }*/
}
