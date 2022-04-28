package com.example.entrytest.dto;

import com.example.entrytest.entity.Customer;
import com.example.entrytest.entity.Product;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public class OrderDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Customer customer;

    private float amount;

    private Instant orderDate;

    private Product product;
}
