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

    private String username;

    private String status;

    private UserroleDTO userrole;

    private String password;

    private Date lastupdatedtime;

    private Date createdtime;
}
