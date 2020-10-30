package com.peasch.model.dto.mapper;

import com.peasch.model.dto.BookDto;
import com.peasch.model.entities.Book;
import com.peasch.model.entities.Copy;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-26T09:14:57+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 12.0.2 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public Book fromDtoToBook(BookDto bookDto) {
        if ( bookDto == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookDto.getId() );
        book.setTitle( bookDto.getTitle() );
        book.setSummary( bookDto.getSummary() );
        book.setCategory( bookDto.getCategory() );
        book.setAuthor( bookDto.getAuthor() );
        Set<Copy> set = bookDto.getCopiesOfBook();
        if ( set != null ) {
            book.setCopiesOfBook( new HashSet<Copy>( set ) );
        }

        return book;
    }

    @Override
    public BookDto fromBookToDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setId( book.getId() );
        bookDto.setTitle( book.getTitle() );
        bookDto.setSummary( book.getSummary() );
        bookDto.setCategory( book.getCategory() );
        bookDto.setAuthor( book.getAuthor() );
        Set<Copy> set = book.getCopiesOfBook();
        if ( set != null ) {
            bookDto.setCopiesOfBook( new HashSet<Copy>( set ) );
        }

        return bookDto;
    }
}
