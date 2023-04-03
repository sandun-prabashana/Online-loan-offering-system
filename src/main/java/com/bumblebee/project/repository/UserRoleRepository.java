package com.bumblebee.project.repository;


import com.bumblebee.project.model.Userrole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<Userrole, String> {
}
