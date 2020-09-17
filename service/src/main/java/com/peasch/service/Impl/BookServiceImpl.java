package com.peasch.service.Impl;

import com.peasch.model.entities.Book;
import com.peasch.model.entities.Copy;
import com.peasch.repository.dao.BookDao;
import com.peasch.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    public List<Book> getBooks(){
        return bookDao.findAll();
    }

    public Book findById(Integer id){
        return bookDao.findById(id).get();

    }

    public Book save(Book book){
        return bookDao.save(book);
    }
}
