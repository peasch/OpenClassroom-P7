package com.peasch.service.Impl;

import com.peasch.model.dto.CategoryDto;
import com.peasch.model.dto.UserDto;
import com.peasch.model.dto.mapper.CategoryMapper;
import com.peasch.model.entities.Book;
import com.peasch.model.entities.Category;
import com.peasch.model.entities.User;
import com.peasch.repository.dao.BookDao;
import com.peasch.repository.dao.CategoryDao;
import com.peasch.service.BookService;
import com.peasch.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private CategoryMapper mapper;

    public List<CategoryDto> getCategories(){
        List<CategoryDto> categoryDtos = new ArrayList<>();
        List<Category> categories = categoryDao.findAll();
        for (Category category:categories){
            categoryDtos.add(mapper.fromCategoryToDto(category));
        }
        return categoryDtos ;
    }

    public CategoryDto findById(Integer id){
        return mapper.fromCategoryToDto(categoryDao.findById(id).get());

    }

    public CategoryDto save(CategoryDto categoryDto){
        return mapper.fromCategoryToDto(categoryDao.save(mapper.fromDtoToCategory(categoryDto)));
    }

}
