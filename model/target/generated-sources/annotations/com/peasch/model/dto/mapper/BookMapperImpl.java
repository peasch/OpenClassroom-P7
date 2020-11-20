package com.peasch.model.dto.mapper;

import com.peasch.model.dto.Book.BookDto;
import com.peasch.model.dto.copies.CopyDto;
import com.peasch.model.entities.Book;
import com.peasch.model.entities.Copy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-13T15:12:47+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 12.0.2 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Autowired
    private CopyMapper copyMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public Book fromDtoToBook(BookDto bookDto) {
        if ( bookDto == null ) {
            return null;
        }

        Book book = new Book();

        book.setCover( bookDto.getCover() );
        book.setId( bookDto.getId() );
        book.setTitle( bookDto.getTitle() );
        book.setSummary( bookDto.getSummary() );
        book.setCategory( categoryMapper.fromDtoToCategory( bookDto.getCategory() ) );
        book.setAuthor( authorMapper.fromDtoToAuthor( bookDto.getAuthor() ) );
        book.setCopiesOfBook( copyDtoSetToCopySet( bookDto.getCopiesOfBook() ) );

        return book;
    }

    @Override
    public BookDto fromBookToDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setCover( book.getCover() );
        bookDto.setId( book.getId() );
        bookDto.setTitle( book.getTitle() );
        bookDto.setSummary( book.getSummary() );

        return bookDto;
    }

    @Override
    public List<BookDto> fromBooksToDtos(List<Book> books) {
        if ( books == null ) {
            return null;
        }

        List<BookDto> list = new ArrayList<BookDto>( books.size() );
        for ( Book book : books ) {
            list.add( fromBookToDto( book ) );
        }

        return list;
    }

    @Override
    public Set<CopyDto> fromCopiesofBookToDto(Set<Copy> copiesOfBook) {
        if ( copiesOfBook == null ) {
            return null;
        }

        Set<CopyDto> set = new HashSet<CopyDto>( Math.max( (int) ( copiesOfBook.size() / .75f ) + 1, 16 ) );
        for ( Copy copy : copiesOfBook ) {
            set.add( copyMapper.fromCopyToDto( copy ) );
        }

        return set;
    }

    protected Set<Copy> copyDtoSetToCopySet(Set<CopyDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Copy> set1 = new HashSet<Copy>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( CopyDto copyDto : set ) {
            set1.add( copyMapper.fromDtoToCopy( copyDto ) );
        }

        return set1;
    }
}
