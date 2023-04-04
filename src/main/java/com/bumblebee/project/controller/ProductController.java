package com.bumblebee.project.controller;


import com.bumblebee.project.dto.ProductDTO;
import com.bumblebee.project.model.Product;
import com.bumblebee.project.service.ProductService;
import com.bumblebee.project.utility.Util2.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        Product product = productService.createProduct(productDTO);
        return new ResponseEntity(new StandardResponse("200", "Product Register successfully", productDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return new ResponseEntity(new StandardResponse("200", "Product retrieved successfully", product), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product2) {
        Product product = productService.updateProduct(id, product2);
        return new ResponseEntity(new StandardResponse("200", "Product updated successfully", product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity(new StandardResponse("200", "Product deleted successfully", id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> product = productService.getAllProduct();
        return new ResponseEntity(new StandardResponse("200", "Product retrieved successfully", product), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getProductCount() {
        Number count = productService.getProductCount();
        return new ResponseEntity(new StandardResponse("200", "Product Count", count), HttpStatus.OK);
    }


}

