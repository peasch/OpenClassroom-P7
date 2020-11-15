package com.peasch.model.dto;
import com.peasch.model.entities.Book;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class AuthorDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String firstName;
    private String birthDate;
    private String deathDate;
    private Set<BookDto> books = new HashSet<>();

    public AuthorDto() {
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(String deathDate) {
        this.deathDate = deathDate;
    }

    public Set<BookDto> getBooks() {
        return books;
    }

    public void setBooks(Set<BookDto> books) {
        this.books = books;
    }
}
