package com.bumblebee.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {

    private Long customerId;

    private String fullName;

    private LocalDate dateOfBirth;

    private String email;

    private String password;

    private String phoneNumber;
}
