package com.bumblebee.project.controller;

import com.bumblebee.project.dto.LoginDTO;
import com.bumblebee.project.service.LoginService;
import com.bumblebee.project.utility.Util2.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/bb")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/login")
    public StandardResponse login(@Valid @RequestBody LoginDTO loginDTO) throws Exception {
        System.out.println("Username : " + loginDTO.getUsername());
        System.out.println("Password : " + loginDTO.getPassword());
        return loginService.authenticateUser(loginDTO);
    }
}
