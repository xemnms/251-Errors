package com.acosta.springboot.service;

import com.acosta.springboot.dto.OrderRequest;
import com.acosta.springboot.dto.OrderResponse;
import com.acosta.springboot.entity.Order;
import com.acosta.springboot.entity.OrderItem;
import com.acosta.springboot.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// GRASP: Pure Fabrication  - made-up class that exists only to hold business logic
// GRASP: High Cohesion     - only handles order-related logic, nothing else
// GRASP: Low Coupling      - depends on the OrderRepository interface, not a real DB class

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    // We hold ONE payment processor here for simplicity
    // GRASP: Polymorphism - this could be Cash or Card, we don't care which
    private final PaymentProcessor paymentProcessor;

    // Spring injects both of these through the constructor
    public OrderService(OrderRepository orderRepository, PaymentProcessor paymentProcessor) {
        this.orderRepository = orderRepository;
        this.paymentProcessor = paymentProcessor;
    }

    // ─── CREATE ─────────────────────────────────────────────────────────────

    // GRASP: Creator - OrderService builds Order and OrderItem objects
    //   because it has all the data from the request needed to do so
    public OrderResponse createOrder(OrderRequest request) {

        // 1. Basic validation
        if (request.getCustomerName() == null || request.getCustomerName().isBlank()) {
            throw new IllegalArgumentException("Customer name cannot be empty");
        }
        if (request.getItems() == null || request.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order must have at least one item");
        }

        // 2. Build the Order
        Order order = new Order(request.getCustomerName());

        // 3. Build each OrderItem and add it to the order
        for (OrderRequest.OrderItemRequest itemReq : request.getItems()) {
            OrderItem item = new OrderItem(
                    itemReq.getProductName(),
                    itemReq.getPrice(),
                    itemReq.getQuantity()
            );
            order.addItem(item);
        }

        // 4. Save to database
        Order saved = orderRepository.save(order);

        // 5. Process payment (Polymorphism: Cash or Card, same call)
        paymentProcessor.process(saved);
        orderRepository.save(saved);  // save again so status update is stored

        // 6. Return a clean response DTO
        return OrderResponse.fromEntity(saved);
    }

    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found: " + id));
        return OrderResponse.fromEntity(order);
    }

    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderResponse> responses = new ArrayList<>();

        for (Order order : orders) {
            responses.add(OrderResponse.fromEntity(order));
        }

        return responses;
    }

    public OrderResponse updateStatus(Long id, String newStatus) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found: " + id));

        order.setStatus(newStatus);
        return OrderResponse.fromEntity(orderRepository.save(order));
    }

    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Order not found: " + id);
        }
        orderRepository.deleteById(id);
    }
}