package com.example.entrytest.service;


import com.example.entrytest.dto.CustomerDTO;
import com.example.entrytest.entity.Customer;

public interface CustomerService {

     public Customer addCustomer(CustomerDTO customerDTO);

     public Customer editCustomer(int customerId, CustomerDTO customerDTO) throws Exception;

     public Customer deleteCustomer();

}
