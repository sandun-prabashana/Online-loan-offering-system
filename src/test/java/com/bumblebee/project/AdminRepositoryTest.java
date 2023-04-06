package com.bumblebee.project;


import com.bumblebee.project.model.Admin;
import com.bumblebee.project.model.Brand;
import com.bumblebee.project.model.User;
import com.bumblebee.project.repository.AdminRepository;
import com.bumblebee.project.repository.BrandRepository;
import com.bumblebee.project.repository.UserRepository;
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
class AdminRepositoryTest {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveAdminTest(){
        User user = userRepository.findById("Customer").get();
        Admin admin = Admin.builder()
                .userName(user)
                .firstName("TEST")
                .lastName("USER")
                .phoneNumber("1111")
                .email("test@gmail.com")
                .build();
        adminRepository.save(admin);
        Assertions.assertThat(admin.getAdminId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getBAdminTest(){
        Admin admin = adminRepository.findById(1L).get();
        Assertions.assertThat(admin.getAdminId()).isEqualTo(1L);
    }

    @Test
    @Order(3)
    public void getListOfAdminsTest(){
        List<Admin> admin = adminRepository.findAll();
        Assertions.assertThat(admin.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateAdminTest(){
        Admin admin = adminRepository.findById(1L).get();
        admin.setEmail("test@gmail.com");
        Admin adminpdated =  adminRepository.save(admin);
        Assertions.assertThat(adminpdated.getEmail()).isEqualTo("test@gmail.com");
    }


}