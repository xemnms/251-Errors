package com.rodenas.grasp.demo.service;

import com.rodenas.grasp.demo.dto.OrderRequestDTO;
import com.rodenas.grasp.demo.entity.Order;
import com.rodenas.grasp.demo.entity.OrderItem;
import com.rodenas.grasp.demo.exception.OrderNotFoundException;
import com.rodenas.grasp.demo.payment.PaymentProcessor;
import com.rodenas.grasp.demo.repository.OrderRepository;
import com.rodenas.grasp.demo.util.PriceCalculatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// GRASP: Pure Fabrication - doesn't represent a real-world concept
// GRASP: High Cohesion - only handles order business logic
// GRASP: Low Coupling - depends on interfaces and abstractions
@Service
public class OrderService {

    // GRASP: Indirection - depends on repository interface, not DB directly
    private final OrderRepository orderRepository;
    private final PriceCalculatorUtil priceCalculator;

    // GRASP: Polymorphism + Low Coupling - depends on PaymentProcessor interface
    private final Map<String, PaymentProcessor> paymentProcessors;

    @Autowired
    public OrderService(OrderRepository orderRepository,
                        PriceCalculatorUtil priceCalculator,
                        List<PaymentProcessor> processors) {
        this.orderRepository = orderRepository;
        this.priceCalculator = priceCalculator;
        // GRASP: Protected Variations - new payment types just need to implement interface
        this.paymentProcessors = processors.stream()
                .collect(Collectors.toMap(PaymentProcessor::getPaymentMethod, Function.identity()));
    }

    // GRASP: Creator - Service creates Order and OrderItems from DTO
    public Order createOrder(OrderRequestDTO dto) {
        Order order = new Order(dto.getCustomerName(), dto.getPaymentMethod().toUpperCase());

        if (dto.getItems() != null) {
            dto.getItems().forEach(itemDTO -> {
                // GRASP: Creator - Order creates its own OrderItems
                OrderItem item = new OrderItem(
                        itemDTO.getMenuItemName(),
                        itemDTO.getPrice(),
                        itemDTO.getQuantity()
                );
                order.addItem(item);
            });
        }

        // GRASP: Polymorphism - correct processor selected at runtime
        PaymentProcessor processor = paymentProcessors.get(dto.getPaymentMethod().toUpperCase());
        if (processor != null) {
            processor.process(order.calculateTotal());
        }

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    public List<Order> getOrdersByStatus(String status) {
        return orderRepository.findByStatus(status.toUpperCase());
    }

    public Order updateOrderStatus(Long id, String status) {
        Order order = getOrderById(id);
        order.setStatus(status.toUpperCase());
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        Order order = getOrderById(id);
        orderRepository.delete(order);
    }

    public double getOrderTotalWithVat(Long id) {
        Order order = getOrderById(id);
        return priceCalculator.calculateTotalWithVat(order);
    }

    public String getReceipt(Long id) {
        Order order = getOrderById(id);
        PaymentProcessor processor = paymentProcessors.get(order.getPaymentMethod().toUpperCase());
        if (processor != null) {
            return processor.getReceipt(order.calculateTotal());
        }
        return "No receipt available";
    }
}