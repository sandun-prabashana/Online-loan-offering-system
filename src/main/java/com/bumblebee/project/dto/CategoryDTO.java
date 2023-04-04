package com.bumblebee.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryDTO {

    private Long categoryId;

    @NotBlank(message = "Category Name cannot be blank")
    private String categoryName;

    private String status;
}
