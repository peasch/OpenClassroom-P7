package com.peasch.model.dto.mapper;

import com.peasch.model.dto.CategoryDto;
import com.peasch.model.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses={BookMapper.class})
public interface CategoryMapper {

    Category fromDtoToCategory (CategoryDto categoryDto);

    @Mapping(source = "booksOfCategory",target = "booksOfCategory",ignore=true)
    CategoryDto fromCategoryToDto (Category category);


}
