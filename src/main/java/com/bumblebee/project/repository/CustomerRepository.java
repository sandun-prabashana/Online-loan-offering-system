package com.bumblebee.project.repository;

import com.bumblebee.project.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT COUNT(email)  FROM Customer WHERE email = :email", nativeQuery = true)
    Integer existsByEmail(@Param("email") String email);



    Customer findByEmail(String email);

    Customer findByActivationCode(String activationCode);

    @Query(value = "SELECT COUNT(customer_id)  FROM Customer WHERE status = :status", nativeQuery = true)
    Integer getCustomerCountByStatus(@Param("status") String status);
}
