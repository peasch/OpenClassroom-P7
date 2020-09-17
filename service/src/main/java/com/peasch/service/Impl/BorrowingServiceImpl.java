package com.peasch.service.Impl;

import com.peasch.model.entities.Borrowing;
import com.peasch.model.entities.Copy;
import com.peasch.repository.dao.BorrowingDao;
import com.peasch.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowingServiceImpl implements BorrowingService {
    @Autowired
    private BorrowingDao borrowingDao;

    public List<Borrowing> getBorrowings(){
        return borrowingDao.findAll();
    }

    public Borrowing findById(Integer id){
        return borrowingDao.findById(id).get();

    }

    public Borrowing save(Borrowing borrowing){
        return borrowingDao.save(borrowing);
    }
}
