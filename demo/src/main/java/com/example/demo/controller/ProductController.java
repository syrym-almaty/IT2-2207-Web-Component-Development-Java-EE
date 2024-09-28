package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product Controller", description = "CRUD operations for Product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "Get all Products", description = "Gives a list of all products")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list")
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @Operation(summary = "Create Product", description = "Creates a new Product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product was created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public Product createProduct(
            @Parameter(description = "Product object to be created", required = true)
            @RequestBody Product product){
        return productService.createProduct(product);
    }

    @Operation(summary = "Get product by ID" , description = "Finds a product by its ID")
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable UUID uuid){
        return productService.findById(uuid);
    }

    @Operation(summary = "Delete Product by ID", description = "Deletes product by its ID")
    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable UUID uuid){
        productService.deleteProductById(uuid);
    }
}
