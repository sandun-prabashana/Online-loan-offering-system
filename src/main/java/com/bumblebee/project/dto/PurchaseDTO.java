package com.bumblebee.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PurchaseDTO {

    private Long purchaseId;

    @NotBlank(message = "Customer cannot be blank")
    private CustomerDTO customer;

    @NotBlank(message = "Product cannot be blank")
    private ProductDTO product;

    @NotBlank(message = "Purchase Quantity cannot be blank")
    private int purchaseQuantity;

    @NotBlank(message = "Purchase Date cannot be blank")
    private String purchaseDate;

}
