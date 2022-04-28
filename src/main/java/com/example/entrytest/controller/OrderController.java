package com.example.entrytest.controller;

import com.example.entrytest.dto.OrderDTO;
import com.example.entrytest.entity.Order;
import com.example.entrytest.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping("/v1/orders")
    public ResponseEntity<Order> createNewOrder(@RequestBody OrderDTO orderDTO) throws Exception {
        return ResponseEntity.ok(orderService.createOrder(orderDTO));
    }

    @GetMapping("/v1/orders/customers/{customerId}")
    public ResponseEntity<List<Order>> getAllOrdersByCustomerId(@PathVariable("customerId") int customerId) {
        return ResponseEntity.ok(orderService.searchByCustomerId(customerId));
    }
}
