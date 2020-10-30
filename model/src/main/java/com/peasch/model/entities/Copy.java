package com.peasch.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="copy")

public class Copy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="available")
    private boolean available;

    @ManyToOne
    @JoinColumn(name = "fk_book")
    private Book book;


    @ManyToOne
    @JoinColumn(name = "fk_library")
    private Library library;

    public Copy() {
    }

    public Copy(int id, boolean available, Book book, Library library) {
        this.id = id;
        this.available = available;
        this.book = book;
        this.library = library;
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
