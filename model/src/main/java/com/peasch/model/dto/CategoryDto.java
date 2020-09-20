package com.peasch.model.dto;

import com.peasch.model.entities.Book;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class CategoryDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String description;
    private Set<Book> booksOfCategory = new HashSet<>();

    public CategoryDto() {
    }

    public CategoryDto(int id, String name, String description, Set<Book> booksOfCategory) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.booksOfCategory = booksOfCategory;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", booksOfCategory=" + booksOfCategory +
                '}';
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Book> getBooksOfCategory() {
        return booksOfCategory;
    }

    public void setBooksOfCategory(Set<Book> booksOfCategory) {
        this.booksOfCategory = booksOfCategory;
    }
}
