package com.bautista.grasp.service;

import com.bautista.grasp.dto.*;
import com.bautista.grasp.entity.*;
import com.bautista.grasp.exception.*;
import com.bautista.grasp.repository.*;
import com.bautista.grasp.util.OrderItemMapper;
import com.bautista.grasp.util.PaymentFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * GRASP: Pure Fabrication (service layer exists for business logic)
 * GRASP: Creator (creates Order and OrderItems)
 * GRASP: Low Coupling (depends on abstractions)
 * GRASP: High Cohesion (only order processing logic)
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository,
                            ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    public OrderResponseDTO createOrder(OrderRequestDTO request) {

        List<OrderItem> items = request.getItems()
                .stream()
                .map(dto -> {

                    Product product = productRepository.findById(dto.getProductId())
                            .orElseThrow(() ->
                                    new ProductNotFoundException("Product not found: " + dto.getProductId()));

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

        return order.calculateTotal();
    }

    /*
     * GRASP: Polymorphism (via factory abstraction)
     * GRASP: Protected Variations (payment type extensible)
     */
    @Override
    public String processPayment(Long orderId, String paymentType) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() ->
                        new OrderNotFoundException("Order not found: " + orderId));

        double total = order.calculateTotal();

        Payment payment = PaymentFactory.getPayment(paymentType);

        return payment.process(total);
    }
}