package com.peasch.controller;

import com.peasch.model.entities.Borrowing;
import com.peasch.model.entities.Library;
import com.peasch.service.BorrowingService;
import com.peasch.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libraries")
public class LibraryController {
    @Autowired
    private LibraryService service;


    @GetMapping
    public List<Library> getLibraries(){
        return service.getLibraries();
    }

    @GetMapping("{id}")
    public Library getUserById(@PathVariable(value = "id")Integer id){
        return service.findById(id);
    }

    @PostMapping("add")
    public void addLibrary (@RequestBody Library library){
        service.save(library);
    }
}
