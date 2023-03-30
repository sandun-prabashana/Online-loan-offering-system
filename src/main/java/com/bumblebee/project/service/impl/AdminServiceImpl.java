package com.bumblebee.project.service.impl;

import com.bumblebee.project.dto.AdminDTO;
import com.bumblebee.project.exception.AdminNotFoundException;
import com.bumblebee.project.exception.ValidateException;
import com.bumblebee.project.model.Admin;
import com.bumblebee.project.repository.AdminRepository;
import com.bumblebee.project.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Admin createAdmin(AdminDTO adminDTO) {
        System.out.println(adminRepository.existsByEmail(adminDTO.getEmail()));
        if (adminRepository.existsByEmail(adminDTO.getEmail()) == 1){
            throw new ValidateException("Admin Already Registered");
        }
        Admin admin = modelMapper.map(adminDTO, Admin.class);
        return adminRepository.save(admin);
    }

    @Override
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElseThrow(() -> new AdminNotFoundException("Admin not found with id: " + id));
    }

    @Override
    public Admin updateAdmin(Long id, AdminDTO adminDTO) {
        Admin admin = getAdminById(id);
        admin.setUsername(adminDTO.getUsername());
        admin.setPassword(adminDTO.getPassword());
        admin.setRole(adminDTO.getRole());
        admin.setEmail(adminDTO.getEmail());
        return adminRepository.save(admin);
    }

    @Override
    public void deleteAdmin(Long id) {
        Admin admin = getAdminById(id);
        adminRepository.delete(admin);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }



}

