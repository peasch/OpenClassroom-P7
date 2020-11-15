package com.peasch.service;

import com.peasch.model.dto.BorrowingDto;
import com.peasch.model.entities.Borrowing;

import java.util.List;
import java.util.Set;

public interface BorrowingService {

    List<BorrowingDto> getBorrowings();


    BorrowingDto findById(Integer id);

    Borrowing save(Borrowing borrowing);

    Set<BorrowingDto> findBorrowingsByUserId(Integer id);
}
