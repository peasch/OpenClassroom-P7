package com.peasch.service.Impl;

import com.peasch.model.dto.BorrowingDto;
import com.peasch.model.dto.UserDto;
import com.peasch.model.dto.mapper.BorrowingMapper;
import com.peasch.model.dto.mapper.CopyMapper;
import com.peasch.model.dto.mapper.UserMapper;
import com.peasch.model.entities.Borrowing;
import com.peasch.model.entities.Copy;
import com.peasch.model.entities.User;
import com.peasch.repository.dao.BorrowingDao;
import com.peasch.service.BorrowingService;
import com.peasch.service.CopyService;
import com.peasch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BorrowingServiceImpl implements BorrowingService {
    @Autowired
    private BorrowingDao borrowingDao;
    @Autowired
    private BorrowingMapper mapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CopyService copyService;
    @Autowired
    private UserService userService;


    public List<BorrowingDto> getBorrowings(){
        List<BorrowingDto> borrows = new ArrayList<>();
        List<Borrowing>borrowings = borrowingDao.findAll();
        for(Borrowing borrowing :borrowings){
            borrows.add(mapper.fromBorrowingToDto(borrowing));

    }
        return borrows;
    }


    public BorrowingDto findById(Integer id){
        BorrowingDto borrowingDto = mapper.fromBorrowingToDto(borrowingDao.findById(id).get());
        borrowingDto.setCopy(copyService.findById(borrowingDao.findById(id).get().getCopy().getId()));
        borrowingDto.setUser(userService.findById(borrowingDao.findById(id).get().getUser().getId()));
        return borrowingDto;

    }

    public Borrowing save(Borrowing borrowing){
        return borrowingDao.save(borrowing);
    }

    public Set<BorrowingDto> findBorrowingsByUserId(Integer id) {
        Set<BorrowingDto> borrowDtos = new HashSet<>();
    Set<Borrowing> borrowings = borrowingDao.findBorrowingByUser_Id(id);
    for (Borrowing borrow : borrowings){
        borrowDtos.add(this.findById(borrow.getId()));
    }
    return borrowDtos;
    }




}
