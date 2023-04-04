package com.bumblebee.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {

    private Long productId;

    @NotBlank(message = "Product Name cannot be blank")
    private String productName;

    @NotBlank(message = "Product Description cannot be blank")
    private String productDescription;

    @NotBlank(message = "Price cannot be blank")
    private BigDecimal price;

    @NotBlank(message = "Category cannot be blank")
    private CategoryDTO category;

    @NotBlank(message = "Brand cannot be blank")
    private BrandDTO brand;

    @NotBlank(message = "Quantity cannot be blank")
    private int quantity;
}
