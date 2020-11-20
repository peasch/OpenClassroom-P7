package com.peasch.controller;

import com.peasch.model.dto.Borrowings.BorrowingDto;
import com.peasch.model.dto.Borrowings.BorrowingWithAllDTO;
import com.peasch.model.entities.Borrowing;
import com.peasch.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrowings")
public class BorrowingController {

   @Autowired
    private BorrowingService service;


    @GetMapping
    public List<BorrowingDto> getBorrowings(){
        return service.getBorrowings();
    }

    @GetMapping("{id}")
    public BorrowingDto getUserById(@PathVariable(value = "id")Integer id){
        return service.findById(id);
    }

    @PostMapping("add")
    public void addBorrowing (@RequestBody Borrowing borrowing){
        service.save(borrowing);
    }

    @PostMapping("extend/{id}")
    public BorrowingWithAllDTO extendBorrowing(@PathVariable(value="id")Integer id){
     return service.extendByIdWithAll(id);
    }
}
