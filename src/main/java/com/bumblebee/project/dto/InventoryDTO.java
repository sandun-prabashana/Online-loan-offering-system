package com.bumblebee.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InventoryDTO {

    private InventoryIdDTO id;

    private int quantity;

}
