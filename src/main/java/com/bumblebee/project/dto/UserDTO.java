package com.bumblebee.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

    @NotBlank(message = "User Name cannot be blank")
    private String username;

    private String status;

    @NotBlank(message = "User Role cannot be blank")
    private UserroleDTO userrole;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    private Date lastupdatedtime;

    private Date createdtime;
}
