package com.bumblebee.project.controller;

import com.bumblebee.project.dto.AdminDTO;
import com.bumblebee.project.model.Admin;
import com.bumblebee.project.service.AdminService;
import com.bumblebee.project.utility.Util2.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseEntity<Admin> createAdmin(@Valid @RequestBody AdminDTO adminDTO) {
        Admin admin = adminService.createAdmin(adminDTO);
        return new ResponseEntity(new StandardResponse("200", "Admin Register successfully", adminDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        Admin admin = adminService.getAdminById(id);
        return new ResponseEntity(new StandardResponse("200", "Admin retrieved successfully", admin), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody AdminDTO adminDTO) {
        Admin admin = adminService.updateAdmin(id, adminDTO);
        return new ResponseEntity(new StandardResponse("200", "Admin updated successfully", admin), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return new ResponseEntity(new StandardResponse("200", "Admin deleted successfully", id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admin = adminService.getAllAdmins();
        return new ResponseEntity(new StandardResponse("200", "Admin retrieved successfully", admin), HttpStatus.OK);
    }
}
