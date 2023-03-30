package com.bumblebee.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "inventory")
public class Inventory implements Serializable {

    @EmbeddedId
    private InventoryId id;

    private int quantity;

}
