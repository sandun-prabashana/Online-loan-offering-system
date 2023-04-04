package com.bumblebee.project.controller;


import com.bumblebee.project.dto.PurchaseDTO;
import com.bumblebee.project.model.Purchase;
import com.bumblebee.project.service.PurchaseService;
import com.bumblebee.project.utility.Util2.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<Purchase> createAdmin(@Valid @RequestBody PurchaseDTO purchaseDTO) throws MessagingException {
        Purchase purchase = purchaseService.createPurchase(purchaseDTO);
        return new ResponseEntity(new StandardResponse("200", "Purchase Register successfully", purchase), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Purchase> getAdminById(@PathVariable Long purchaseId) {
        Purchase purchase = purchaseService.getPurchaseById(purchaseId);
        return new ResponseEntity(new StandardResponse("200", "Purchase retrieved successfully", purchase), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Purchase> updateAdmin(@PathVariable Long purchaseId, @RequestBody Purchase purchase2) {
        Purchase purchase = purchaseService.updatePurchase(purchaseId, purchase2);
        return new ResponseEntity(new StandardResponse("200", "Purchase updated successfully", purchase), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long purchaseId) {
        purchaseService.deletePurchase(purchaseId);
        return new ResponseEntity(new StandardResponse("200", "Purchase deleted successfully", purchaseId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Purchase>> getAllAdmins() {
        List<Purchase> purchase = purchaseService.getAllPurchase();
        return new ResponseEntity(new StandardResponse("200", "Purchase retrieved successfully", purchase), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getPurchaseCount() {
        Number count = purchaseService.getPurchaseCount();
        return new ResponseEntity(new StandardResponse("200", "Product Count", count), HttpStatus.OK);
    }

}
