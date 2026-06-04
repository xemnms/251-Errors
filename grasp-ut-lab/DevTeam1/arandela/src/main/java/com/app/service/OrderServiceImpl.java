package com.app.service;

import com.app.dto.OrderDTO;
import com.app.entity.*;
import com.app.repository.OrderRepository;
import com.app.util.OrderNotFoundException;
import com.app.util.OrderValidator;
import org.springframework.stereotype.Service;
import java.util.List;

// GRASP: Pure Fabrication - holds business logic cleanly
// GRASP: Low Coupling - depends on interfaces, not concrete classes
// GRASP: High Cohesion - only handles order business logic
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderValidator orderValidator;

    public OrderServiceImpl(OrderRepository orderRepository, OrderValidator orderValidator) {
        this.orderRepository = orderRepository;
        this.orderValidator = orderValidator;
    }

    @Override
    public Order createOrder(OrderDTO dto) {
        // GRASP: Protected Variations - validation isolated here
        if (!orderValidator.isValid(dto)) {
            throw new IllegalArgumentException("Invalid order data");
        }
        Order order = new Order(dto.getCustomerName());
        // GRASP: Polymorphism - resolves payment without knowing which type
        Payment payment = resolvePayment(dto.getPaymentType());
        payment.process(0);
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    @Override
    public Order updateStatus(Long id, String status) {
        Order order = getOrderById(id);
        order.setStatus(status);
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        orderRepository.deleteById(id);
    }

    // GRASP: Polymorphism + Protected Variations
    private Payment resolvePayment(String type) {
        if (type == null) return new CashPayment();
        return switch (type.toUpperCase()) {
            case "CARD" -> new CardPayment();
            default -> new CashPayment();
        };
    }
}
