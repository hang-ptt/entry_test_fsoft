package com.example.entrytest.service;

import com.example.entrytest.dto.OrderDTO;
import com.example.entrytest.entity.Order;

import java.util.List;

public interface OrderService {

    public Order createOrder(OrderDTO orderDTO) throws Exception;

    public Order editOrder(int orderId, OrderDTO orderDTO);

    public List<Order> searchByCustomerId(int customerId);
}
