package com.example.entrytest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "product")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int productId;

    @Column(name = "product_price")
    private float productPrice;

    @Column(name = "product_type")
    private String productType;

    public Product(float productPrice, String productType) {
        this.productPrice = productPrice;
        this.productType = productType;
    }
}
