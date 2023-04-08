package com.bumblebee.project.controller;


import com.bumblebee.project.dto.CategoryDTO;
import com.bumblebee.project.model.Category;
import com.bumblebee.project.service.CategoryService;
import com.bumblebee.project.utility.Util2.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        Category category = categoryService.createCategory(categoryDTO);
        return new ResponseEntity(new StandardResponse("200", "Category Create successfully", categoryDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{brand_id}")
    public ResponseEntity<Category> getBrandById(@PathVariable Long brand_id) {
        Category category = categoryService.getCategoryById(brand_id);
        return new ResponseEntity(new StandardResponse("200", "Category retrieved successfully", category), HttpStatus.OK);
    }

    @PutMapping("/{category_id}")
    public ResponseEntity<Category> updateBrand(@PathVariable Long category_id, @RequestBody CategoryDTO categoryDTO) {
        Category category = categoryService.updateCategory(category_id, categoryDTO);
        return new ResponseEntity(new StandardResponse("200", "Category updated successfully", category), HttpStatus.OK);
    }

    @DeleteMapping("/{brand_id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Long brand_id) {
        categoryService.deleteCategory(brand_id);
        return new ResponseEntity(new StandardResponse("200", "Category deleted successfully", brand_id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory() {
        List<Category> category = categoryService.getAllCategory();
        return new ResponseEntity(new StandardResponse("200", "Category retrieved successfully", category), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getCustomerCount() {
        Number count = categoryService.getCategoryCount();
        return new ResponseEntity(new StandardResponse("200", "Category Count", count), HttpStatus.OK);
    }
}
