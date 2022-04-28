package com.example.entrytest.controller;

import com.example.entrytest.dto.CustomerDTO;
import com.example.entrytest.entity.Customer;
import com.example.entrytest.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/v1/customers")
    public ResponseEntity<Customer> addCustomer(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.addCustomer(customerDTO));
    }

    @PutMapping("/v1/customers/{customerId}")
    public ResponseEntity<Customer> editCustomer(@PathVariable("customerId") int customerId, @RequestBody CustomerDTO customerDTO) throws Exception {
        return ResponseEntity.ok(customerService.editCustomer(customerId, customerDTO));
    }

}
