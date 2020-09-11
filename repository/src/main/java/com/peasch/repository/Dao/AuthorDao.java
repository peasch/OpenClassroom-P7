package com.peasch.repository.Dao;

import com.peasch.model.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDao extends JpaRepository<Author,Integer> {
}
