package com.app.service;

import com.app.dto.OrderDTO;
import com.app.entity.Order;
import com.app.repository.OrderRepository;
import com.app.payment.Payment;

// SOLID: SRP - only handles order business logic
// SOLID: DIP - depends on abstraction (Payment)
public class OrderService {

    private final OrderRepository orderRepository;
    private final Payment payment;

    // DIP: constructor injection
    public OrderService(OrderRepository orderRepository, Payment payment) {
        this.orderRepository = orderRepository;
        this.payment = payment;
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order getOrder(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public void payForOrder(Long orderId, double amount) {
        Order order = getOrder(orderId);

        payment.pay(amount); // DIP in action
        order.markAsPaid();

        orderRepository.save(order);
    }
}