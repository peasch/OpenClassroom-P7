package com.peasch.model.dto.mapper;

import com.peasch.model.dto.AuthorDto;
import com.peasch.model.entities.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    Author fromDtoToAuthor(AuthorDto authorDto);
    AuthorDto fromAuthorToDto( Author author);
}
