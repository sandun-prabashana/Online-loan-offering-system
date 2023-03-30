package com.bumblebee.project.service;

import com.bumblebee.project.dto.AdminDTO;
import com.bumblebee.project.model.Admin;

import java.util.List;

public interface AdminService {
    Admin createAdmin(AdminDTO adminDTO);
    Admin getAdminById(Long id);
    Admin updateAdmin(Long id, AdminDTO adminDTO);
    void deleteAdmin(Long id);
    List<Admin> getAllAdmins();
}
