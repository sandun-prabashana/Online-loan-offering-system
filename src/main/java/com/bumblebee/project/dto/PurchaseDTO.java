package com.bumblebee.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PurchaseDTO {

    private Long purchaseId;

    private CustomerDTO customer;

    private ProductDTO product;

    private int purchaseQuantity;

    private LocalDate purchaseDate;

}
