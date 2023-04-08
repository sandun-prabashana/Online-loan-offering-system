package com.bumblebee.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {

    private Long customerId;

    @NotBlank(message = "First Name cannot be blank")
    private String firstName;

    @NotBlank(message = "Last Name cannot be blank")
    private String lastName;

    private UserDTO user;

    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotBlank(message = "Phone Number cannot be blank")
    private String phoneNumber;

    @NotBlank(message = "Address cannot be blank")
    private String addressLine1;

    @NotBlank(message = "City cannot be blank")
    private String city;

    @NotBlank(message = "Postal Code cannot be blank")
    private String postalCode;

    private String status;

    private boolean isEnabled;

    private String activationCode;

    private Date dateCreated;

    private String password;
}
