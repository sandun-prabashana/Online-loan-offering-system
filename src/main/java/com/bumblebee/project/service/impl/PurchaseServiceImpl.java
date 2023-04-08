package com.bumblebee.project.service.impl;

import com.bumblebee.project.dto.PurchaseDTO;
import com.bumblebee.project.exception.AdminNotFoundException;
import com.bumblebee.project.model.Product;
import com.bumblebee.project.model.Purchase;
import com.bumblebee.project.repository.PurchaseRepository;
import com.bumblebee.project.service.PurchaseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Purchase createPurchase(PurchaseDTO purchaseDTO) {
        Purchase purchase = modelMapper.map(purchaseDTO, Purchase.class);
        return purchaseRepository.save(purchase);
    }

    @Override
    public Purchase getPurchaseById(Long purchaseId) {
        return purchaseRepository.findById(purchaseId).orElseThrow(() -> new AdminNotFoundException("Purchase not found with id: " + purchaseId));
    }

    @Override
    public Purchase updatePurchase(Long purchaseId, Purchase purchase2) {
        Purchase purchase = getPurchaseById(purchaseId);
        purchase.setCustomer(purchase2.getCustomer());
        purchase.setProduct(purchase2.getProduct());
        purchase.setPurchaseQuantity(purchase2.getPurchaseQuantity());
        purchase.setPurchaseDate(purchase2.getPurchaseDate());
        return purchaseRepository.save(purchase);
    }

    @Override
    public void deletePurchase(Long purchaseId) {
        Purchase purchase = getPurchaseById(purchaseId);
        purchaseRepository.delete(purchase);
    }

    @Override
    public List<Purchase> getAllPurchase() {
        return purchaseRepository.findAll();
    }

    @Override
    public Long getPurchaseCount() {
        return purchaseRepository.count();
    }
}
