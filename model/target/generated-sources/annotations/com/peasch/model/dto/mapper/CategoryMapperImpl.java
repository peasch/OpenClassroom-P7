package com.peasch.model.dto.mapper;

import com.peasch.model.dto.Book.BookDto;
import com.peasch.model.dto.Categories.CategoryDto;
import com.peasch.model.entities.Book;
import com.peasch.model.entities.Category;
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
public class CategoryMapperImpl implements CategoryMapper {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Category fromDtoToCategory(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryDto.getId() );
        category.setName( categoryDto.getName() );
        category.setDescription( categoryDto.getDescription() );
        category.setBooksOfCategory( bookDtoSetToBookSet( categoryDto.getBooksOfCategory() ) );

        return category;
    }

    @Override
    public CategoryDto fromCategoryToDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId( category.getId() );
        categoryDto.setName( category.getName() );
        categoryDto.setDescription( category.getDescription() );

        return categoryDto;
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
}
