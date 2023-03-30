package com.bumblebee.project.repository;

import com.bumblebee.project.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByUsername(String username);

    @Query(value = "SELECT COUNT(email)  FROM Admin WHERE email = :email", nativeQuery = true)
    Integer existsByEmail(@Param("email") String email);


}
