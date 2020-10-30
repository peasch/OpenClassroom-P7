package com.peasch.service;

import com.peasch.model.dto.CategoryDto;
import com.peasch.model.entities.Book;
import com.peasch.model.entities.Category;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getCategories();

    CategoryDto findById(Integer id);

    CategoryDto save(CategoryDto categoryDto);
}
