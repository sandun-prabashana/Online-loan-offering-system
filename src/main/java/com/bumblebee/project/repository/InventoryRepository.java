package com.bumblebee.project.repository;

import com.bumblebee.project.model.Inventory;
import com.bumblebee.project.model.InventoryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, InventoryId> {
}
