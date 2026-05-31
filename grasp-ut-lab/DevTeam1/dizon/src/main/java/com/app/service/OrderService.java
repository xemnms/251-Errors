package com.app.service;

import com.app.dto.OrderItemRequest;
import com.app.dto.OrderRequest;
import com.app.dto.OrderResponse;
import com.app.entity.Order;
import com.app.entity.OrderItem;
import com.app.entity.OrderStatus;
import com.app.exception.OrderNotFoundException;
import com.app.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// GRASP: Pure Fabrication - not a real-world entity; created to house business logic
// GRASP: High Cohesion - only responsible for order business operations
// GRASP: Low Coupling - depends on OrderRepository interface, not a concrete class
@Service
public class OrderService {

    // GRASP: Low Coupling - injected via interface (Indirection)
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // GRASP: Creator - service creates Order objects since it holds the initializing data
    public OrderResponse createOrder(OrderRequest request) {
        if (request.getCustomerName() == null || request.getCustomerName().isBlank()) {
            throw new IllegalArgumentException("Customer name must not be empty");
        }

        Order order = new Order(request.getCustomerName());

        if (request.getItems() != null) {
            for (OrderItemRequest itemReq : request.getItems()) {
                // GRASP: Creator - Order adds its own items (owns them)
                OrderItem item = new OrderItem(
                        itemReq.getProductName(),
                        itemReq.getPrice(),
                        itemReq.getQuantity()
                );
                order.addItem(item);
            }
        }

        Order saved = orderRepository.save(order);
        return toResponse(saved);
    }

    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        return toResponse(order);
    }

    public OrderResponse updateOrderStatus(Long id, String status) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        order.setStatus(OrderStatus.valueOf(status.toUpperCase()));
        return toResponse(orderRepository.save(order));
    }

    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        orderRepository.deleteById(id);
    }

    // GRASP: Information Expert - delegates total calculation to Order (the expert)
    private OrderResponse toResponse(Order order) {
        OrderResponse response = new OrderResponse(
                order.getId(),
                order.getCustomerName(),
                order.getStatus(),
                order.calculateTotal(),
                order.getCreatedAt()
        );

        if (order.getItems() != null) {
            List<OrderItemRequest> itemDtos = order.getItems().stream()
                    .map(item -> new OrderItemRequest(
                            item.getProductName(),
                            item.getPrice(),
                            item.getQuantity()))
                    .collect(Collectors.toList());
            response.setItems(itemDtos);
        }

        return response;
    }
}
