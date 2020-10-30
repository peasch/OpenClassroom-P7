package com.peasch.service;

import com.peasch.model.dto.AuthorDto;
import com.peasch.model.entities.Author;

import java.util.List;

public interface AuthorService {

    List<AuthorDto> getAuthors();

    AuthorDto findById(Integer id);

    AuthorDto save(AuthorDto authorDto);
    AuthorDto findAuthorByName(String name);
}
