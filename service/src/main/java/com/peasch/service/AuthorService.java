package com.peasch.service;

import com.peasch.model.entities.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAuthors();

    Author findById(Integer id);

    Author save(Author author);

}
