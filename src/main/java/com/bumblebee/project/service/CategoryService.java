package com.bumblebee.project.service;


import com.bumblebee.project.dto.CategoryDTO;
import com.bumblebee.project.model.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(CategoryDTO categoryDTO);
    Category getCategoryById(Long categoryId);
    Category updateCategory(Long categoryId, CategoryDTO categoryDTO);
    void deleteCategory(Long categoryId);
    List<Category> getAllCategory();

    Long getCategoryCount();
}
