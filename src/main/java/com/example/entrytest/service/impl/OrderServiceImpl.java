package com.example.entrytest.service.impl;

import com.example.entrytest.dto.OrderDTO;
import com.example.entrytest.entity.Customer;
import com.example.entrytest.entity.Order;
import com.example.entrytest.entity.Product;
import com.example.entrytest.repository.CustomerRepository;
import com.example.entrytest.repository.OrderRepository;
import com.example.entrytest.repository.ProductRepository;
import com.example.entrytest.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final CustomerRepository customerRepository;

    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;


    public OrderServiceImpl(CustomerRepository customerRepository, OrderRepository orderRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Order createOrder(OrderDTO orderDTO) throws Exception {

        Optional<Customer> customer = customerRepository.findById(orderDTO.getCustomer().getCustomerId());
        Optional<Product> product = productRepository.findById(orderDTO.getProduct().getProductId());

        Order order;
        if (product.isPresent()) {
            order = new Order();
            order.setProduct(product.get());
            order.setOrderDate(Instant.now());
            order.setAmount(orderDTO.getAmount());
            if (customer.isPresent()) {
                order.setCustomer(customer.get());
            } else {
                Customer newCustomer = new Customer();
                newCustomer.setCustomerName(orderDTO.getCustomer().getCustomerName());
                newCustomer.setAddress(orderDTO.getCustomer().getAddress());
                newCustomer.setPhone(orderDTO.getCustomer().getPhone());
                order.setCustomer(customerRepository.save(newCustomer));
            }
        } else {
            throw new Exception("Product is not found");
        }
        return orderRepository.save(order);
    }

    @Override
    public Order editOrder(int orderId, OrderDTO orderDTO) {
        return null;
    }

    @Override
    public List<Order> searchByCustomerId(int customerId) {
        return orderRepository.findByCustomer_CustomerId(customerId);
    }
}
