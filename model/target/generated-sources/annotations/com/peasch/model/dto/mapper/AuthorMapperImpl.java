package com.peasch.model.dto.mapper;

import com.peasch.model.dto.AuthorDto;
import com.peasch.model.entities.Author;
import com.peasch.model.entities.Book;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-04T14:26:47+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 12.0.2 (Oracle Corporation)"
)
@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public Author fromDtoToAuthor(AuthorDto authorDto) {
        if ( authorDto == null ) {
            return null;
        }

        Author author = new Author();

        author.setId( authorDto.getId() );
        author.setName( authorDto.getName() );
        author.setFirstName( authorDto.getFirstName() );
        author.setBirthDate( authorDto.getBirthDate() );
        author.setDeathDate( authorDto.getDeathDate() );
        Set<Book> set = authorDto.getBooks();
        if ( set != null ) {
            author.setBooks( new HashSet<Book>( set ) );
        }

        return author;
    }

    @Override
    public AuthorDto fromAuthorToDto(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorDto authorDto = new AuthorDto();

        authorDto.setId( author.getId() );
        authorDto.setName( author.getName() );
        authorDto.setFirstName( author.getFirstName() );
        authorDto.setBirthDate( author.getBirthDate() );
        authorDto.setDeathDate( author.getDeathDate() );
        Set<Book> set = author.getBooks();
        if ( set != null ) {
            authorDto.setBooks( new HashSet<Book>( set ) );
        }

        return authorDto;
    }
}
