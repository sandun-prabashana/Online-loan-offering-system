package com.bumblebee.project.service.impl;

import com.bumblebee.project.dto.AdminDTO;
import com.bumblebee.project.exception.AdminNotFoundException;
import com.bumblebee.project.exception.ValidateException;
import com.bumblebee.project.model.Admin;
import com.bumblebee.project.model.User;
import com.bumblebee.project.model.Userrole;
import com.bumblebee.project.repository.AdminRepository;
import com.bumblebee.project.repository.UserRepository;
import com.bumblebee.project.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Admin createAdmin(AdminDTO adminDTO) {
        System.out.println(adminRepository.existsByEmail(adminDTO.getEmail()));
        if (adminRepository.existsByEmail(adminDTO.getEmail()) == 1){
            throw new ValidateException("Admin Already Registered");
        }
        User user = new User();
        Userrole userrole = new Userrole();
        userrole.setUserrolecode("2");

        user.setUsername(adminDTO.getUserName().getUsername());
        user.setPassword(passwordEncoder.encode(adminDTO.getUserName().getPassword()));
        System.out.println(adminDTO.getUserName().getUsername());
        System.out.println(adminDTO.getUserName().getPassword());
        user.setStatus("ACTIVE");
        user.setUserrole(userrole);
        userRepository.save(user);

        Admin admin = modelMapper.map(adminDTO, Admin.class);
        return adminRepository.save(admin);
    }

    @Override
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElseThrow(() -> new AdminNotFoundException("Admin not found with id: " + id));
    }

    @Override
    public Admin updateAdmin(Long id, AdminDTO adminDTO) {
        Admin admin = getAdminById(id);;
        admin.setFirstName(adminDTO.getFirstName());
        admin.setLastName(adminDTO.getLastName());
        admin.setPhoneNumber(adminDTO.getPhoneNumber());
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

