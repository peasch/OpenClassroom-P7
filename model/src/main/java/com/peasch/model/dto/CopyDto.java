package com.peasch.model.dto;

import com.peasch.model.entities.Book;
import com.peasch.model.entities.Library;
import lombok.*;

import java.io.Serializable;

public class CopyDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private boolean available;
    private Book book;
    private Library library;

    public CopyDto() {
    }

    public CopyDto(int id, boolean available, Book book, Library library) {
        this.id = id;
        this.available = available;
        this.book = book;
        this.library = library;
    }

    @Override
    public String toString() {
        return "CopyDto{" +
                "id=" + id +
                ", available=" + available +
                ", book=" + book +
                ", library=" + library +
                '}';
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
