package com.example.entrytest.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private float productPrice;

    private String productType;

}
