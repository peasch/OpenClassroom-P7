package com.peasch.service.Impl;

import com.peasch.model.dto.BookDto;
import com.peasch.model.dto.mapper.BookMapper;
import com.peasch.model.entities.Author;
import com.peasch.model.entities.Book;
import com.peasch.model.entities.Research;
import com.peasch.repository.dao.AuthorDao;
import com.peasch.repository.dao.BookDao;
import com.peasch.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private BookMapper mapper;
    @Autowired
    private AuthorDao authorDao;



    public List<BookDto> getBooks() {
        List<BookDto> booksDto = new ArrayList<>();
        List<Book> books = bookDao.findAll();
        for (Book book:books){
            booksDto.add(mapper.fromBookToDto(book));
        }
        return booksDto;
    }

    public BookDto findById(Integer id) {
        return mapper.fromBookToDto(bookDao.findById(id).get());


    }

    public Book save(Book book) {
        return bookDao.save(book);
    }

    public List<BookDto> findBooksByAuthor_Name(String authorName){
        List<BookDto> bookDtoSearched = new ArrayList<>();
        List<Book> bookSearched = bookDao.findBooksByAuthor_NameLike("%"+authorName+"%");
        for (Book book : bookSearched){
            bookDtoSearched.add(mapper.fromBookToDto(book));
        }
        return bookDtoSearched;
    }

    public List<BookDto> findBooksByTitle(String title){
        List<BookDto> booksDtoSearched = new ArrayList<>();
        List<Book> bookSearched = bookDao.findBooksByTitleLike("%"+title+"%");
        for (Book book : bookSearched){
            booksDtoSearched.add(mapper.fromBookToDto(book));
        }
        return booksDtoSearched;
    }
    public  List<BookDto> findBooksByResearch(Research research){
        List<BookDto> booksDtoResearched = new ArrayList<>();
        List<Book> bookSearched = bookDao.findBooksByTitleLikeAndAuthor_NameLikeAndCategory_NameLike("%"+research.getResearchTitle()+"%","%"+research.getResearchAuthor()+"%","%"+research.getResearchCategory()+"%");
        for (Book book : bookSearched){
            booksDtoResearched.add(mapper.fromBookToDto(book));
        }
        return booksDtoResearched;
    }

}
