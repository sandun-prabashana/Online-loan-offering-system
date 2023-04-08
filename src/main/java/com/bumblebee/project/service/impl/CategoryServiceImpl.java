package com.bumblebee.project.service.impl;

import com.bumblebee.project.dto.CategoryDTO;
import com.bumblebee.project.exception.AdminNotFoundException;
import com.bumblebee.project.exception.ValidateException;
import com.bumblebee.project.model.Brand;
import com.bumblebee.project.model.Category;
import com.bumblebee.project.repository.CategoryRepository;
import com.bumblebee.project.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        if (categoryRepository.existsByCategory_name(categoryDTO.getCategoryName()) == 1){
            throw new ValidateException("This Category  Already Exists");
        }
        Category category = modelMapper.map(categoryDTO, Category.class);
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(() -> new AdminNotFoundException("Category not found with This Category ID: " + categoryId));
    }

    @Override
    public Category updateCategory(Long categoryId, CategoryDTO categoryDTO) {
        Category category = getCategoryById(categoryId);
        category.setCategoryName(categoryDTO.getCategoryName());
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category = getCategoryById(categoryId);
        categoryRepository.delete(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Long getCategoryCount() {
        return categoryRepository.count();
    }
}
