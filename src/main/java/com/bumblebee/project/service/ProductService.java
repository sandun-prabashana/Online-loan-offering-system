package com.bumblebee.project.service;


import com.bumblebee.project.dto.ProductDTO;
import com.bumblebee.project.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductDTO productDTO);
    Product getProductById(Long productId);
    Product updateProduct(Long productId, Product product);
    void deleteProduct(Long productId);
    List<Product> getAllProduct();

    Long getProductCount();

}
