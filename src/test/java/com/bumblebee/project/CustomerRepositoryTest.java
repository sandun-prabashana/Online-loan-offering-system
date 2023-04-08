package com.bumblebee.project;


import com.bumblebee.project.model.Brand;
import com.bumblebee.project.model.Customer;
import com.bumblebee.project.model.User;
import com.bumblebee.project.repository.BrandRepository;
import com.bumblebee.project.repository.CustomerRepository;
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
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    UserRepository userRepository;


    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveCustomerTest(){
        User user = userRepository.findById("Customer").get();
        Customer customer = Customer.builder()
                .firstName("Test 1")
                .lastName("Test 2")
                .user(user)
                .email("test2@gmail.com")
                .phoneNumber("119")
                .addressLine1("Test")
                .city("Test")
                .postalCode("00000")
                .status("ACTIVE")
                .build();
        customerRepository.save(customer);
        Assertions.assertThat(customer.getCustomerId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getCustomerest(){
        Customer customer = customerRepository.findById(1L).get();
        Assertions.assertThat(customer.getCustomerId()).isEqualTo(1L);

    }

    @Test
    @Order(3)
    public void getListOfCustomersTest(){
        List<Customer> customers = customerRepository.findAll();
        Assertions.assertThat(customers.size()).isGreaterThan(0);

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateCustomerTest(){
        Customer customer = customerRepository.findById(1L).get();
        customer.setEmail("test8@gmail.com");
        Customer customerUpdated =  customerRepository.save(customer);
        Assertions.assertThat(customerUpdated.getEmail()).isEqualTo("test8@gmail.com");

    }


}