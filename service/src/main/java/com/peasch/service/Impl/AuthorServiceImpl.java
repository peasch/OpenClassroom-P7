package com.peasch.service.Impl;

import com.peasch.model.entities.Author;
import com.peasch.model.entities.Copy;
import com.peasch.repository.dao.AuthorDao;
import com.peasch.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorDao authorDao;
    public List<Author> getAuthors(){
        return authorDao.findAll();
    }

    public Author findById(Integer id){
        return authorDao.findById(id).get();

    }

    public Author save(Author author){
        return authorDao.save(author);
    }
}
