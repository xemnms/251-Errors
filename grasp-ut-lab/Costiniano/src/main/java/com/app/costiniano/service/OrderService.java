package com.app.costiniano.service;

import com.app.costiniano.dto.OrderRequestDto;
import com.app.costiniano.dto.OrderResponseDto;
import com.app.costiniano.entity.Order;
import com.app.costiniano.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final Map<String, PaymentStrategy> paymentStrategies;

    public OrderService(OrderRepository orderRepository, List<PaymentStrategy> strategies) {
        this.orderRepository = orderRepository;
        this.paymentStrategies = strategies.stream()
                .collect(Collectors.toMap(PaymentStrategy::getMethodName, s -> s));
    }

    public OrderResponseDto checkout(OrderRequestDto request) {
        if (request.items() == null || request.items().isEmpty()) {
            throw new IllegalArgumentException("Order items list cannot be empty");
        }

        Order order = new Order();
        request.items().forEach(item -> order.addItem(item.name(), item.price(), item.quantity()));

        PaymentStrategy strategy = paymentStrategies.get(request.paymentMethod().toUpperCase());
        if (strategy == null) {
            throw new IllegalArgumentException("Unsupported payment method: " + request.paymentMethod());
        }

        strategy.processPayment(order);
        Order savedOrder = orderRepository.save(order);

        return new OrderResponseDto(savedOrder.getId(), savedOrder.getTotalAmount(), savedOrder.getStatus());
    }
}