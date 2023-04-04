package com.bumblebee.project.service.impl;

import com.bumblebee.project.dto.LoginDTO;
import com.bumblebee.project.model.User;
import com.bumblebee.project.repository.UserRepository;
import com.bumblebee.project.service.LoginService;
import com.bumblebee.project.utility.Util2.StandardResponse;
import com.bumblebee.project.utility.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;


@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public StandardResponse authenticateUser(LoginDTO loginDTO) throws Exception {
        StandardResponse responseBean = new StandardResponse();
        HashMap<String, Object> responseData = new HashMap<>();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getUsername(),
                        loginDTO.getPassword()
                )
        );

        Optional<User> byUsername = userRepository.findByUsername(loginDTO.getUsername());
        User user;
        String token;
        if (byUsername.isPresent()) {
            user = byUsername.get();
            token = jwtUtil.generateToken(user);
            responseData.put("userData", user);
            responseData.put("token", token);
        }
        responseBean.setMessage("User Successfully login");
        responseBean.setCode(HttpStatus.OK.toString());
        responseBean.setData(responseData);
        return responseBean;
    }
}
