package com.bumblebee.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminDTO {

    private Long adminId;

//    @NotBlank(message = "User Name cannot be blank")
    private UserDTO userName;

    @NotBlank(message = "First Name cannot be blank")
    private String firstName;

    @NotBlank(message = "Last Name cannot be blank")
    private String lastName;

    @NotBlank(message = "Phone Number cannot be blank")
    private String phoneNumber;

    @NotBlank(message = "Email cannot be blank")
    private String email;


}
