package com.peasch.model.dto.mapper;

import com.peasch.model.dto.AuthorDto;
import com.peasch.model.dto.BookDto;
import com.peasch.model.entities.Author;
import com.peasch.model.entities.Book;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-13T15:12:48+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 12.0.2 (Oracle Corporation)"
)
@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Autowired
    private BookMapper bookMapper;

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
        author.setBooks( bookDtoSetToBookSet( authorDto.getBooks() ) );

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
        authorDto.setBooks( bookSetToBookDtoSet( author.getBooks() ) );

        return authorDto;
    }

    protected Set<Book> bookDtoSetToBookSet(Set<BookDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Book> set1 = new HashSet<Book>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( BookDto bookDto : set ) {
            set1.add( bookMapper.fromDtoToBook( bookDto ) );
        }

        return set1;
    }

    protected Set<BookDto> bookSetToBookDtoSet(Set<Book> set) {
        if ( set == null ) {
            return null;
        }

        Set<BookDto> set1 = new HashSet<BookDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Book book : set ) {
            set1.add( bookMapper.fromBookToDto( book ) );
        }

        return set1;
    }
}
