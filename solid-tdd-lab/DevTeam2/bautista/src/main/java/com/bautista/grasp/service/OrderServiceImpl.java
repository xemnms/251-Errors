package com.bautista.grasp.service;

import com.bautista.grasp.dto.*;
import com.bautista.grasp.entity.*;
import com.bautista.grasp.exception.*;
import com.bautista.grasp.repository.*;
import com.bautista.grasp.util.OrderItemMapper;
import org.springframework.stereotype.Service;

import java.util.List;

// SOLID: SRP - handles only order creation and retrieval, payment moved to PaymentServiceImpl
// SOLID: DIP - depends on interfaces (OrderRepository, ProductRepository, OrderValidator)
// GRASP: Pure Fabrication, Creator, Low Coupling, High Cohesion
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderValidator orderValidator; // SRP: validation is delegated, not inlined

    public OrderServiceImpl(OrderRepository orderRepository,
                            ProductRepository productRepository,
                            OrderValidator orderValidator) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.orderValidator = orderValidator;
    }

    @Override
    public OrderResponseDTO createOrder(OrderRequestDTO request) {

        // SRP: validation is a separate responsibility, handled by the validator
        orderValidator.validate(request);

        List<OrderItem> items = request.getItems()
                .stream()
                .map(dto -> {

                    Product product = productRepository.findById(dto.getProductId())
                            .orElseThrow(() ->
                                    new ProductNotFoundException("Product not found: " + dto.getProductId()));

                    // DRY: mapping logic lives in one place (OrderItemMapper)
                    return OrderItemMapper.toEntity(dto, product);
                })
                .toList();

        Order order = new Order(items);
        Order saved = orderRepository.save(order);

        return new OrderResponseDTO(saved.getId(), saved.calculateTotal());
    }

    @Override
    public double getOrderTotal(Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() ->
                        new OrderNotFoundException("Order not found: " + orderId));

        // GRASP: Information Expert - Order knows how to calculate its own total
        return order.calculateTotal();
    }
}