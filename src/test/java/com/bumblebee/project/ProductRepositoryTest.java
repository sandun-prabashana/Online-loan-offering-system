package com.bumblebee.project;


import com.bumblebee.project.model.Brand;
import com.bumblebee.project.model.Category;
import com.bumblebee.project.model.Customer;
import com.bumblebee.project.model.Product;
import com.bumblebee.project.repository.BrandRepository;
import com.bumblebee.project.repository.CategoryRepository;
import com.bumblebee.project.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BrandRepository brandRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveProductTest(){
        Category category = categoryRepository.findById((long) 1).get();
        Brand brand = brandRepository.findById((long) 4).get();
        Product product = Product.builder()
                .productName("Test_Product")
                .productDescription("Test_Product_Description")
                .price(BigDecimal.valueOf(100))
                .category(category)
                .brand(brand)
                .quantity(99)
                .build();
        productRepository.save(product);
        Assertions.assertThat(product.getProductId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getProductTest(){
        Product product = productRepository.findById(8L).get();
        Assertions.assertThat(product.getProductId()).isEqualTo(8L);
    }

    @Test
    @Order(3)
    public void getListOfProductsTest(){
        List<Product> products = productRepository.findAll();
        Assertions.assertThat(products.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateProductTest(){
        Product product = productRepository.findById(3L).get();
        product.setProductName("Test_Change_Product_Name");
        Product productUpdated =  productRepository.save(product);
        Assertions.assertThat(productUpdated.getProductName()).isEqualTo("Test_Change_Product_Name");

    }


}