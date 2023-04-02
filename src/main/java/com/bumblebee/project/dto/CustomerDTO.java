package com.bumblebee.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {

    private Long customerId;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String password;

    private String addressLine1;

    private String city;

    private String postalCode;

    private String status;

    private boolean isEnabled;

    private String activationCode;

    private Date dateCreated;
}
