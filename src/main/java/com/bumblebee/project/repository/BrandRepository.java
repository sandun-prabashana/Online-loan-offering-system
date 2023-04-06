package com.bumblebee.project.repository;

import com.bumblebee.project.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {

    @Query(value = "SELECT COUNT(brand_name)  FROM Brand WHERE brand_name = :brand_name", nativeQuery = true)
    Integer existsByBrand_name(@Param("brand_name") String brand_name);





}
