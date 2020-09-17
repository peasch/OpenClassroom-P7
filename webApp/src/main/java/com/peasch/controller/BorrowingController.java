package com.peasch.controller;

import com.peasch.model.entities.Author;
import com.peasch.model.entities.Borrowing;
import com.peasch.service.AuthorService;
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
    public List<Borrowing> getBorrowings(){
        return service.getBorrowings();
    }

    @GetMapping("{id}")
    public Borrowing getUserById(@PathVariable(value = "id")Integer id){
        return service.findById(id);
    }

    @PostMapping("add")
    public void addBorrowing (@RequestBody Borrowing borrowing){
        service.save(borrowing);
    }
}
