package com.peasch.model.dto;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class CategoryDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String description;
    private Set<BookDto> booksOfCategory = new HashSet<>();

    public CategoryDto() {
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

    public Set<BookDto> getBooksOfCategory() {
        return booksOfCategory;
    }

    public void setBooksOfCategory(Set<BookDto> booksOfCategory) {
        this.booksOfCategory = booksOfCategory;
    }
}
