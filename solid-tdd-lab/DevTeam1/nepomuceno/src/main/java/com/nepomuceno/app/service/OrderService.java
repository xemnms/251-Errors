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

// SOLID: SRP - OrderService now only orchestrates business logic.
//             Validation → OrderValidator, Mapping → OrderMapper
//
// SOLID: DIP - all dependencies are injected as abstractions (interfaces),
//              not as concrete classes
//
// BEFORE (OrderService had 3 responsibilities):
//   1. Business logic (createOrder, processPayment, etc.)
//   2. Input validation (inline if-checks)
//   3. Response mapping (private toResponse() method)
//
// AFTER (OrderService has 1 responsibility):
//   1. Business logic only — delegates validation and mapping
//
// WHY: When validation rules change, only OrderValidator changes.
// When the response shape changes, only OrderMapper changes.
// OrderService has one reason to change: business rules.
@Service
public class OrderService {

    // SOLID: DIP - depends on abstractions, never on concrete classes
    private final OrderRepository orderRepository;
    private final List<Payment> payments;
    private final OrderValidator orderValidator;
    private final OrderMapper orderMapper;

    // SOLID: DIP - all dependencies injected via constructor (not new'd internally)
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
        // SOLID: SRP - validation delegated; service only orchestrates
        orderValidator.validateRequest(request);

        Order order = new Order();
        for (ItemDto item : request.getItems()) {
            // DRY: Reusable item validation rule lives in OrderValidator, not repeated here
            orderValidator.validateItem(item);
            order.addItem(item.getName(), item.getPrice(), item.getQuantity());
        }

        Order saved = orderRepository.save(order);
        // SOLID: DIP - mapping delegated to abstraction (OrderMapper interface)
        return orderMapper.toResponse(saved);
    }

    public OrderResponse getOrder(Long id) {
        Order order = findOrderOrThrow(id);
        return orderMapper.toResponse(order);
    }

    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toResponse)
                .toList();
    }

    // GRASP: Polymorphism — dispatches to the correct Payment implementation at runtime
    // SOLID: OCP - adding a new payment type never requires changes here
    public OrderResponse processPayment(Long id, String paymentType) {
        Order order = findOrderOrThrow(id);

        Payment payment = payments.stream()
                .filter(p -> p.getType().equalsIgnoreCase(paymentType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown payment type: " + paymentType));

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

    // DRY: Shared reusable lookup — avoids duplicating findById + orElseThrow across methods
    private Order findOrderOrThrow(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Order not found: " + id));
    }
}
