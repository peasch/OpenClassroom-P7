package com.peasch.repository.dao;

import com.peasch.model.dto.BookDto;
import com.peasch.model.entities.Author;
import com.peasch.model.entities.Book;
import com.peasch.model.entities.Library;
import com.peasch.model.entities.Research;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Integer>{
    List<Book> findBooksByAuthor_NameLike(String authorName);
}
