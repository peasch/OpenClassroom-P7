package com.peasch.model.dto;
import com.peasch.model.entities.Author;
import com.peasch.model.entities.Category;
import com.peasch.model.entities.Copy;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class BookDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String title;
    private String summary;
    private Category category;
    private Author author;
    private String cover;
    private Set<Copy> copiesOfBook = new HashSet<>();

    public BookDto() {
    }

    public BookDto(int id, String title, String summary, Category category, Author author, String cover, Set<Copy> copiesOfBook) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.category = category;
        this.author = author;
        this.cover = cover;
        this.copiesOfBook = copiesOfBook;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Set<Copy> getCopiesOfBook() {
        return copiesOfBook;
    }

    public void setCopiesOfBook(Set<Copy> copiesOfBook) {
        this.copiesOfBook = copiesOfBook;
    }
}
