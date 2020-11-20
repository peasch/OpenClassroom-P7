package com.peasch.controller;

import com.peasch.model.dto.Book.BookDto;
import com.peasch.model.dto.Book.BookWithoutCopiesDTO;
import com.peasch.model.entities.Book;
import com.peasch.model.entities.Research;
import com.peasch.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;


    @GetMapping
    public List<BookDto> getBooks(){
        return service.getBooks();
    }

    @GetMapping("{id}")
    public BookDto getBookById(@PathVariable(value = "id")Integer id){
        return service.findById(id);
    }

    @PostMapping("add")
    public void addBook (@RequestBody Book book){
        service.save(book);
    }

    @PostMapping("search")
    public List<BookWithoutCopiesDTO> findBooksByAuthor(@RequestBody Research research){ ;
        return service.findBooksByResearch(research);

    }

}
