package com.peasch.controller;

import com.peasch.model.entities.Borrowing;
import com.peasch.model.entities.Copy;
import com.peasch.service.BorrowingService;
import com.peasch.service.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/copies")
public class CopyController {

    @Autowired
    private CopyService service;


    @GetMapping
    public List<Copy> getCopies(){
        return service.getCopies();
    }

    @GetMapping("{id}")
    public Copy getUserById(@PathVariable(value = "id")Integer id){
        return service.findById(id);
    }

    @PostMapping("add")
    public void addCopy (@RequestBody Copy copy){
        service.save(copy);
    }
}
