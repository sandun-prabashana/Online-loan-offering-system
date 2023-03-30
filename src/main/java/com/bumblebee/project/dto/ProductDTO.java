package com.bumblebee.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {

    private Long productId;

    private String productName;

    private String productDescription;

    private BigDecimal price;

    private CategoryDTO category;

    private BrandDTO brand;

    private int quantity;
}
