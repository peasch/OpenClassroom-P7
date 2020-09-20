package com.peasch.model.dto.mapper;

import com.peasch.model.dto.BookDto;
import com.peasch.model.entities.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    Book fromDtoToBook (BookDto bookDto);
    BookDto fromBookToDto (Book book);
}
