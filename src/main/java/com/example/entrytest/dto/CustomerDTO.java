package com.example.entrytest.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    private String customerName;

    private String address;

    private String phone;

}
