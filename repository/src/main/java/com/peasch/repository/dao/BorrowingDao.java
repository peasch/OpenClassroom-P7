package com.peasch.repository.dao;

import com.peasch.model.entities.Borrowing;
import com.peasch.model.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingDao extends JpaRepository<Borrowing, Integer> {
}
