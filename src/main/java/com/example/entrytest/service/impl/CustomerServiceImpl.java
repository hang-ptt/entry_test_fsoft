package com.example.entrytest.service.impl;

import com.example.entrytest.dto.CustomerDTO;
import com.example.entrytest.entity.Customer;
import com.example.entrytest.repository.CustomerRepository;
import com.example.entrytest.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer addCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setCustomerName(customerDTO.getCustomerName());
        customer.setAddress(customerDTO.getAddress());
        customer.setPhone(customerDTO.getPhone());
        return customerRepository.save(customer);
    }

    @Override
    public Customer editCustomer(int customerId, CustomerDTO customerDTO) throws Exception {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            customer.get().setCustomerName(customerDTO.getCustomerName());
            customer.get().setAddress(customerDTO.getAddress());
            customer.get().setPhone(customerDTO.getPhone());
        } else {
            throw new Exception("Customer is not found");
        }
        return customerRepository.save(customer.get());
    }

    @Override
    public Customer deleteCustomer() {
        return null;
    }
}
