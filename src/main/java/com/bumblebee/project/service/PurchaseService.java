package com.bumblebee.project.service;



import com.bumblebee.project.dto.PurchaseDTO;
import com.bumblebee.project.model.Purchase;

import java.util.List;

public interface PurchaseService {
    Purchase createPurchase(PurchaseDTO purchaseDTO);
    Purchase getPurchaseById(Long productId);
    Purchase updatePurchase(Long productId, Purchase purchase);
    void deletePurchase(Long productId);
    List<Purchase> getAllPurchase();

    Long getPurchaseCount();
}
