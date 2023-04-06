package com.bumblebee.project;


import com.bumblebee.project.model.Brand;
import com.bumblebee.project.repository.BrandRepository;
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
class BrandRepositoryTest {

    @Autowired
    BrandRepository brandRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveBrandTest(){

        Brand brand = Brand.builder()
                .brandName("Test Brand")
                .status("Fadatare")
                .build();

        brandRepository.save(brand);

        Assertions.assertThat(brand.getBrandId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getBrandTest(){
        Brand brand = brandRepository.findById(1L).get();
        Assertions.assertThat(brand.getBrandId()).isEqualTo(1L);
    }

    @Test
    @Order(3)
    public void getListOfBrandsTest(){
        List<Brand> brand = brandRepository.findAll();
        Assertions.assertThat(brand.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateBrandTest(){
        Brand brand = brandRepository.findById(1L).get();
        brand.setBrandName("Test_Change_Brand_Name");
        Brand brandUpdated =  brandRepository.save(brand);
        Assertions.assertThat(brandUpdated.getBrandName()).isEqualTo("Test_Change_Brand_Name");
    }


}