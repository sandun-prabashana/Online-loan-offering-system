package com.bumblebee.project.service;


import com.bumblebee.project.dto.LoginDTO;
import com.bumblebee.project.utility.Util2.StandardResponse;

public interface LoginService {
    StandardResponse authenticateUser(LoginDTO loginDTO) throws Exception;
}
