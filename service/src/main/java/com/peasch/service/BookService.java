package com.peasch.service;

import com.peasch.model.entities.Book;

import java.util.List;

public interface BookService {

    List<Book> getBooks();

    Book findById(Integer id);

    Book save(Book book);
}
