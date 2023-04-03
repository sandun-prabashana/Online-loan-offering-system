package com.bumblebee.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminDTO {

    private Long adminId;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;


}
