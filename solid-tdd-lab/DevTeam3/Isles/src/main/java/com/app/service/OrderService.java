package com.app.service;

import com.app.dto.CreateOrderRequest;
import com.app.dto.OrderItemResponse;
import com.app.dto.OrderResponse;
import com.app.entity.Order;
import com.app.exception.OrderNotFoundException;
import com.app.repository.OrderRepository;
import com.app.util.OrderValidation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final PaymentGateway paymentGateway;
    private final OrderValidation orderValidation;

    public OrderService(OrderRepository orderRepository, PaymentGateway paymentGateway, OrderValidation orderValidation) {
        this.orderRepository = orderRepository;
        this.paymentGateway = paymentGateway;
        this.orderValidation = orderValidation;
    }

    // GRASP: Pure Fabrication - Service coordinates business workflow without being an entity or database object.
    // GRASP: Low Coupling - Service depends on repository and payment interfaces instead of concrete infrastructure.
    // GRASP: High Cohesion - This method only creates an order, charges payment, and saves through the repository boundary.
    // SOLID: SRP - Coordinates order creation only; validation, payment, and persistence are delegated.
    // DIP: Depends on PaymentGateway and OrderValidation abstractions instead of concrete implementations.
    public OrderResponse createOrder(CreateOrderRequest request) {
        orderValidation.validate(request);

        Order order = new Order(request.customerName());
        request.items().forEach(item -> order.addItem(item.productName(), item.quantity(), item.unitPrice()));

        paymentGateway.process(request.paymentMethod(), order.calculateTotal());

        Order saved = orderRepository.save(order);
        return toResponse(saved);
    }

    public OrderResponse getOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        return toResponse(order);
    }

    private OrderResponse toResponse(Order order) {
        List<OrderItemResponse> items = order.getItems().stream()
                .map(item -> new OrderItemResponse(
                        item.getProductName(),
                        item.getQuantity(),
                        item.getUnitPrice(),
                        item.calculateSubtotal()))
                .toList();
        return new OrderResponse(order.getId(), order.getCustomerName(), items, order.calculateTotal());
    }
}
