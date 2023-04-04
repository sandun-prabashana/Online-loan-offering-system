package com.bumblebee.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserroleDTO {

    private String userrolecode;
    private String status;
    private String description;
    private Date lastupdatedtime;
    private Date createdtime;

}
