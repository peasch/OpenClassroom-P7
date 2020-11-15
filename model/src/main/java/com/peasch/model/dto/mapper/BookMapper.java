package com.peasch.model.dto.mapper;

import com.peasch.model.dto.BookDto;
import com.peasch.model.dto.CopyDto;
import com.peasch.model.entities.Book;
import com.peasch.model.entities.Copy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {CopyMapper.class, CategoryMapper.class, AuthorMapper.class, LibraryMapper.class, BorrowingMapper.class})
public interface BookMapper {

    Book fromDtoToBook(BookDto bookDto);

    @Mapping(source = "category", target = "category", ignore = true)
    @Mapping(source = "copiesOfBook", target = "copiesOfBook", ignore = true)
    @Mapping(source = "author", target = "author", ignore = true)
    BookDto fromBookToDto(Book book);

    List<BookDto> fromBooksToDtos(List<Book> books);

    Set<CopyDto> fromCopiesofBookToDto(Set<Copy> copiesOfBook);
}
