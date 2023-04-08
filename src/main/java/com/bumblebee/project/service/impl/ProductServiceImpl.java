package com.bumblebee.project.service.impl;

import com.bumblebee.project.dto.ProductDTO;
import com.bumblebee.project.exception.AdminNotFoundException;
import com.bumblebee.project.model.Admin;
import com.bumblebee.project.model.Category;
import com.bumblebee.project.model.Product;
import com.bumblebee.project.repository.ProductRepository;
import com.bumblebee.project.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Product createProduct(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new AdminNotFoundException("Product not found with id: " + productId));
    }

    @Override
    public Product updateProduct(Long productId, Product product2) {
        Product product = getProductById(productId);
        product.setProductName(product2.getProductName());
        product.setProductDescription(product2.getProductDescription());
        product.setPrice(product2.getPrice());
        product.setCategory(product2.getCategory());
        product.setBrand(product2.getBrand());
        product.setQuantity(product2.getQuantity());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = getProductById(productId);
        productRepository.delete(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Long getProductCount() {
        return productRepository.count();
    }
}
