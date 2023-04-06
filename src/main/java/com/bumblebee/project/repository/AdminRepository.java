package com.bumblebee.project.repository;

import com.bumblebee.project.model.Admin;
import com.bumblebee.project.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface AdminRepository extends JpaRepository<Admin, Long> {


    @Query(value = "SELECT COUNT(email)  FROM Admin WHERE email = :email", nativeQuery = true)
    Integer existsByEmail(@Param("email") String email);

//    Optional<Admin> findByEmail(String email);


}
