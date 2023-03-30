package com.bumblebee.project.repository;

import com.bumblebee.project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
