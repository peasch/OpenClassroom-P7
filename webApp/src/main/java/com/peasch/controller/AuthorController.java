package com.peasch.controller;

import com.peasch.model.entities.Author;
import com.peasch.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService service;


    @GetMapping
    public List<Author> getAuthors(){
        return service.getAuthors();
    }

    @GetMapping("{id}")
    public Author getUserById(@PathVariable(value = "id")Integer id){
        return service.findById(id);
    }

    @PostMapping("add")
    public void addAuthor (@RequestBody Author author){
        service.save(author);
    }
 }
