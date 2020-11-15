package com.peasch.model.dto;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class BookDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String title;
    private String summary;
    private CategoryDto category;
    private AuthorDto author;
    private String cover;
    private Set<CopyDto> copiesOfBook = new HashSet<>();

    public BookDto() {
    }




    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
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

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }

    public Set<CopyDto> getCopiesOfBook() {
        return copiesOfBook;
    }

    public void setCopiesOfBook(Set<CopyDto> copiesOfBook) {
        this.copiesOfBook = copiesOfBook;
    }
}
