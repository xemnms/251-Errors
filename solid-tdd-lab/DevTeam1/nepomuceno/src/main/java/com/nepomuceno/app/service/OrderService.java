package com.nepomuceno.app.service;

import com.nepomuceno.app.dto.ItemDto;
import com.nepomuceno.app.dto.OrderRequest;
import com.nepomuceno.app.dto.OrderResponse;
import com.nepomuceno.app.entity.Order;
import com.nepomuceno.app.mapper.OrderMapper;
import com.nepomuceno.app.repository.OrderRepository;
import com.nepomuceno.app.validator.OrderValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

// SOLID: SRP - OrderService only orchestrates business logic.
//             Validation → OrderValidator, Mapping → OrderMapper
//
// SOLID: DIP - all dependencies injected as abstractions (interfaces),
//              never as concrete classes
//
// BEFORE (OrderService had 3 responsibilities):
//   1. Business logic
//   2. Input validation (inline if-checks)
//   3. Response mapping (private toResponse() method)
//
// AFTER (OrderService has 1 responsibility):
//   1. Business logic only — delegates validation and mapping
@Service
public class OrderService {

    // SOLID: DIP - depends on abstractions, never on concrete classes
    private final OrderRepository orderRepository;
    private final List<Payment> payments;
    private final OrderValidator orderValidator;
    private final OrderMapper orderMapper;

    // SOLID: DIP - all dependencies injected via constructor (never new'd internally)
    public OrderService(OrderRepository orderRepository,
                        List<Payment> payments,
                        OrderValidator orderValidator,
                        OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.payments = payments;
        this.orderValidator = orderValidator;
        this.orderMapper = orderMapper;
    }

    public OrderResponse createOrder(OrderRequest request) {
        // SOLID: SRP - validation fully delegated; service only orchestrates
        // SOLID: DIP - calls abstraction, not implementation
        orderValidator.validateRequest(request);

        Order order = new Order();
        for (ItemDto item : request.getItems()) {
            order.addItem(item.getName(), item.getPrice(), item.getQuantity());
        }

        Order saved = orderRepository.save(order);
        return orderMapper.toResponse(saved); // SRP: mapping delegated
    }

    public OrderResponse getOrder(Long id) {
        Order order = findOrderOrThrow(id); // DRY: reusable lookup
        return orderMapper.toResponse(order);
    }

    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toResponse)
                .toList();
    }

    // GRASP: Polymorphism — dispatches to correct Payment at runtime
    // SOLID: OCP - new payment types never require changes here
    public OrderResponse processPayment(Long id, String paymentType) {
        Order order = findOrderOrThrow(id);         // DRY
        Payment payment = resolvePayment(paymentType); // DRY: extracted method

        payment.process(order);
        Order saved = orderRepository.save(order);
        return orderMapper.toResponse(saved);
    }

    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new NoSuchElementException("Order not found: " + id);
        }
        orderRepository.deleteById(id);
    }

    // DRY: single reusable lookup — avoids duplicating findById + orElseThrow
    private Order findOrderOrThrow(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Order not found: " + id));
    }

    // DRY: extracted from processPayment — single place for payment resolution
    // SOLID: OCP - stream-based lookup; no if-else chain to modify when adding new types
    private Payment resolvePayment(String paymentType) {
        return payments.stream()
                .filter(p -> p.getType().equalsIgnoreCase(paymentType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "Unknown payment type: " + paymentType));
    }
}
