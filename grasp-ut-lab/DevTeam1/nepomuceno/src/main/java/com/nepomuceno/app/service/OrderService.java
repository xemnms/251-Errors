package com.nepomuceno.app.service;

import com.nepomuceno.app.dto.ItemDto;
import com.nepomuceno.app.dto.OrderRequest;
import com.nepomuceno.app.dto.OrderResponse;
import com.nepomuceno.app.entity.Order;
import com.nepomuceno.app.repository.OrderRepository;
import com.nepomuceno.app.util.PriceFormatter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

// GRASP: Pure Fabrication — does not represent a domain concept; exists to hold business logic
// GRASP: Low Coupling — depends on interfaces (OrderRepository, Payment), not concrete classes
// GRASP: High Cohesion — only contains order-related business logic
@Service
public class OrderService {

    // GRASP: Low Coupling — injected as interface type, not implementation
    private final OrderRepository orderRepository;
    private final List<Payment> payments;

    public OrderService(OrderRepository orderRepository, List<Payment> payments) {
        this.orderRepository = orderRepository;
        this.payments = payments;
    }

    // GRASP: Creator — service delegates item creation to the Order entity (which is the Creator)
    public OrderResponse createOrder(OrderRequest request) {
        if (request.getItems() == null || request.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order must have at least one item.");
        }

        Order order = new Order();
        for (ItemDto item : request.getItems()) {
            if (item.getPrice() < 0 || item.getQuantity() <= 0) {
                throw new IllegalArgumentException("Invalid item: " + item.getName());
            }
            order.addItem(item.getName(), item.getPrice(), item.getQuantity());
        }

        Order saved = orderRepository.save(order);
        return toResponse(saved);
    }

    public OrderResponse getOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Order not found: " + id));
        return toResponse(order);
    }

    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // GRASP: Polymorphism — dispatches to the correct Payment implementation at runtime
    public OrderResponse processPayment(Long id, String paymentType) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Order not found: " + id));

        Payment payment = payments.stream()
                .filter(p -> p.getType().equalsIgnoreCase(paymentType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown payment type: " + paymentType));

        payment.process(order);
        Order saved = orderRepository.save(order);
        return toResponse(saved);
    }

    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new NoSuchElementException("Order not found: " + id);
        }
        orderRepository.deleteById(id);
    }

    // GRASP: High Cohesion — mapping logic centralized here, not scattered across layers
    private OrderResponse toResponse(Order order) {
        double total = order.calculateTotal();
        return new OrderResponse(
                order.getId(),
                order.getStatus(),
                total,
                PriceFormatter.format(total)
        );
    }
}
