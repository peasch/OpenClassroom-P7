package com.peasch.model.dto;

import com.peasch.model.entities.Book;
import com.peasch.model.entities.Library;
import lombok.*;

import java.io.Serializable;

public class CopyDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private boolean available;
    private BookDto book;
    private LibraryDto library;

    public CopyDto() {
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public BookDto getBook() {
        return book;
    }

    public void setBook(BookDto book) {
        this.book = book;
    }

    public LibraryDto getLibrary() {
        return library;
    }

    public void setLibrary(LibraryDto library) {
        this.library = library;
    }
}
