package com.example.entrytest.service.impl;

import com.example.entrytest.dto.ProductDTO;
import com.example.entrytest.entity.Product;
import com.example.entrytest.repository.ProductRepository;
import com.example.entrytest.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createNewProduct(ProductDTO productDTO) {
        Product product = new Product(productDTO.getProductPrice(), productDTO.getProductType());
        return productRepository.save(product);
    }
}
