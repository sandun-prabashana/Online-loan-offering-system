package com.bumblebee.project;


import com.bumblebee.project.model.Brand;
import com.bumblebee.project.model.Purchase;
import com.bumblebee.project.repository.BrandRepository;
import com.bumblebee.project.repository.PurchaseRepository;
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
class PurchaseRepositoryTest {

    @Autowired
    PurchaseRepository purchaseRepository;

    @Test
    @Order(1)
    public void getListOfBrandsTest(){
        List<Purchase> purchases = purchaseRepository.findAll();
        Assertions.assertThat(purchases.size()).isGreaterThan(0);

    }


}