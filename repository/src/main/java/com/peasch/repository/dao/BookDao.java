package com.peasch.repository.dao;

import com.peasch.model.entities.Book;
import com.peasch.model.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book, Integer> {
}
