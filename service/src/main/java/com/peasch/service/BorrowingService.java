package com.peasch.service;

import com.peasch.model.dto.Borrowings.BorrowingDto;
import com.peasch.model.dto.Borrowings.BorrowingWithAllDTO;
import com.peasch.model.entities.Borrowing;

import java.util.List;
import java.util.Set;

public interface BorrowingService {
    List<BorrowingDto> getBorrowings();


    BorrowingDto findById(Integer id);

    Borrowing save(Borrowing borrowing);

    Set<BorrowingWithAllDTO> findBorrowingsByUserId(Integer id);
    BorrowingWithAllDTO extendByIdWithAll(Integer id);
}
