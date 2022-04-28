package com.example.entrytest.service;

import com.example.entrytest.dto.ProductDTO;
import com.example.entrytest.entity.Product;

public interface ProductService {

    public Product createNewProduct(ProductDTO productDTO);
}
