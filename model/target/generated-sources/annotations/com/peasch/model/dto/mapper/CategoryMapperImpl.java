package com.peasch.model.dto.mapper;

import com.peasch.model.dto.CategoryDto;
import com.peasch.model.entities.Book;
import com.peasch.model.entities.Category;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-26T09:14:56+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 12.0.2 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category fromDtoToCategory(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryDto.getId() );
        category.setName( categoryDto.getName() );
        category.setDescription( categoryDto.getDescription() );
        Set<Book> set = categoryDto.getBooksOfCategory();
        if ( set != null ) {
            category.setBooksOfCategory( new HashSet<Book>( set ) );
        }

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
        Set<Book> set = category.getBooksOfCategory();
        if ( set != null ) {
            categoryDto.setBooksOfCategory( new HashSet<Book>( set ) );
        }

        return categoryDto;
    }
}
