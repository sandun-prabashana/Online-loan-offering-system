package com.bumblebee.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class InventoryId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
