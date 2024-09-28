package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product findById(UUID uuid){
        return productRepository.findById(uuid).orElse(null);
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProductById(UUID uuid){
        productRepository.deleteById(uuid);
    }
}
