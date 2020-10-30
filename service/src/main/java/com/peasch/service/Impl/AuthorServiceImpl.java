package com.peasch.service.Impl;

import com.peasch.model.dto.AuthorDto;
import com.peasch.model.dto.UserDto;
import com.peasch.model.dto.mapper.AuthorMapper;
import com.peasch.model.entities.Author;
import com.peasch.model.entities.Copy;
import com.peasch.model.entities.User;
import com.peasch.repository.dao.AuthorDao;
import com.peasch.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorDao authorDao;
    @Autowired
    AuthorMapper mapper;
    public List<AuthorDto> getAuthors(){
        List<AuthorDto> authorDtos = new ArrayList<>();
        List<Author> authors = authorDao.findAll();
        for(Author author:authors){
            authorDtos.add(mapper.fromAuthorToDto(author));
        }
        return authorDtos;
    }

    public AuthorDto findById(Integer id){
        return mapper.fromAuthorToDto(authorDao.findById(id).get());

    }

    public AuthorDto save(AuthorDto authorDto){
        return mapper.fromAuthorToDto(authorDao.save(mapper.fromDtoToAuthor(authorDto)));
    }

    public AuthorDto findAuthorByName (String name){
        AuthorDto author = mapper.fromAuthorToDto(authorDao.findAuthorByNameLike(name));
        return author;
    }
}



