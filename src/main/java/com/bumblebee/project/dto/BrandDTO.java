package com.bumblebee.project.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BrandDTO {

    private Long brandId;

    @NotBlank(message = "Brand Name cannot be blank")
    @Size(max = 50, message = "Brand Name must be less than or equal to 50 characters")
    private String brandName;

    private String status;
}
