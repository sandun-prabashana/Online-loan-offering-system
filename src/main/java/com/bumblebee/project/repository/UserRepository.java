package com.bumblebee.project.repository;


import com.bumblebee.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    @Query(value = "SELECT COUNT(username)  FROM User WHERE username = :username", nativeQuery = true)
    Integer existsByUserName(@Param("username") String username);


    Optional<User> findByUsername(String userName);


}
