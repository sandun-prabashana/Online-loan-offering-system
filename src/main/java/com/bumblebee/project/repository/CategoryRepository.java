package com.bumblebee.project.repository;

import com.bumblebee.project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT COUNT(category_name)  FROM Category WHERE category_name = :category_name", nativeQuery = true)
    Integer existsByCategory_name(@Param("category_name") String category_name);

}
