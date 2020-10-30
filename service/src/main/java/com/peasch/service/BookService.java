package com.peasch.service;

import com.peasch.model.dto.BookDto;
import com.peasch.model.entities.Author;
import com.peasch.model.entities.Book;
import com.peasch.model.entities.Research;

import java.util.List;

public interface BookService {

    List<BookDto> getBooks();

    Book findById(Integer id);

    Book save(Book book);

    List<BookDto> findBooksByAuthor_Name(String author);
}
