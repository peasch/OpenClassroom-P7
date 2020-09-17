package com.peasch.service;

import com.peasch.model.entities.Borrowing;

import java.util.List;

public interface BorrowingService {

    List<Borrowing> getBorrowings();


    Borrowing findById(Integer id);

    Borrowing save(Borrowing borrowing);
}
