package com.example.entrytest.controller;

import com.example.entrytest.dto.ProductDTO;
import com.example.entrytest.entity.Product;
import com.example.entrytest.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/v1/products")
    public ResponseEntity<Product> createNewProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.createNewProduct(productDTO));
    }
}
