package com.bumblebee.project;


import com.bumblebee.project.model.Brand;
import com.bumblebee.project.model.Category;
import com.bumblebee.project.repository.BrandRepository;
import com.bumblebee.project.repository.CategoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveCategoryTest(){

        Category category = Category.builder()
                .categoryName("Test Category")
                .status("ACTIVE")
                .build();

        categoryRepository.save(category);

        Assertions.assertThat(category.getCategoryId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getCategoryTest(){
        Category category = categoryRepository.findById(1L).get();
        Assertions.assertThat(category.getCategoryId()).isEqualTo(1L);
    }

    @Test
    @Order(3)
    public void getListOfCategorysTest(){
        List<Category> category = categoryRepository.findAll();
        Assertions.assertThat(category.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateCategoryTest(){
        Category category = categoryRepository.findById(1L).get();
        category.setCategoryName("Test_Change_Category_Name");
        Category categoryUpdated =  categoryRepository.save(category);
        Assertions.assertThat(categoryUpdated.getCategoryName()).isEqualTo("Test_Change_Category_Name");
    }


}