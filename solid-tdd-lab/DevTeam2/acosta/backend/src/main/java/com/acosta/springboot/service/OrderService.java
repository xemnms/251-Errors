package com.acosta.springboot.service;

import com.acosta.springboot.dto.OrderRequest;
import com.acosta.springboot.dto.OrderResponse;
import com.acosta.springboot.entity.Order;
import com.acosta.springboot.entity.OrderItem;
import com.acosta.springboot.repository.OrderRepository;
import com.acosta.springboot.exception.OrderNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// SOLID: SRP  - OrderService only orchestrates: build, save, pay, respond
// SOLID: DIP  - Depends on abstractions (OrderRepository, PaymentProcessor, OrderValidator)
// GRASP: Pure Fabrication - exists only to coordinate business logic
// GRASP: High Cohesion    - every method here is about order management
// GRASP: Low Coupling     - no concrete dependencies created inside this class
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final PaymentProcessorFactory paymentProcessorFactory;

    // SOLID: SRP - validation is now delegated to OrderValidator
    private final OrderValidator orderValidator;

    // DIP: All dependencies injected — no "new ConcreteClass()" anywhere
    public OrderService(OrderRepository orderRepository,
            PaymentProcessorFactory paymentProcessorFactory,
            OrderValidator orderValidator) {
        this.orderRepository = orderRepository;
        this.paymentProcessorFactory = paymentProcessorFactory;
        this.orderValidator = orderValidator;
    }

    public OrderResponse createOrder(OrderRequest request) {

        // SRP: Validation delegated to OrderValidator
        orderValidator.validate(request);

        Order order = new Order(request.getCustomerName());

        for (OrderRequest.OrderItemRequest itemReq : request.getItems()) {
            OrderItem item = new OrderItem(
                    itemReq.getProductName(),
                    itemReq.getPrice(),
                    itemReq.getQuantity());
            order.addItem(item);
        }

        Order saved = orderRepository.save(order);

        // OCP: Factory picks the processor — OrderService doesn't know or care which
        PaymentProcessor processor = paymentProcessorFactory
                .getProcessor(request.getPaymentMethod());
        processor.process(saved);

        orderRepository.save(saved);

        return OrderResponse.fromEntity(saved);
    }

    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
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
                .orElseThrow(() -> new OrderNotFoundException(id));
        order.setStatus(newStatus);
        return OrderResponse.fromEntity(orderRepository.save(order));
    }

    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        orderRepository.deleteById(id);
    }
}