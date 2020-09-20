package com.peasch.model.dto.mapper;

import com.peasch.model.dto.CategoryDto;
import com.peasch.model.entities.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category fromDtoToCategory (CategoryDto categoryDto);
    CategoryDto fromCategoryToDto (Category category);
}
