package com.dizon.app.service;

import com.dizon.app.dto.OrderItemRequest;
import com.dizon.app.dto.OrderRequest;
import com.dizon.app.dto.OrderResponse;
import com.dizon.app.entity.Order;
import com.dizon.app.entity.OrderItem;
import com.dizon.app.entity.OrderStatus;
import com.dizon.app.exception.OrderNotFoundException;
import com.dizon.app.mapper.OrderMapper;
import com.dizon.app.repository.OrderRepository;
import com.dizon.app.validator.OrderValidator;
import org.springframework.stereotype.Service;

import java.util.List;

// SOLID: SRP - after the refactor this class does ONLY order orchestration/business flow.
//        Validation moved to OrderValidator; entity->DTO mapping moved to OrderMapper.
// SOLID: DIP - every collaborator below is an INTERFACE (OrderRepository, OrderValidator,
//        OrderMapper). The service never news-up a concrete class, which is what makes it
//        fully unit-testable with mocked interfaces.
// OOP:  COMPOSITION OVER INHERITANCE - the service is composed of three injected
//        collaborators rather than inheriting behaviour from a base "service" class.
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderValidator orderValidator;
    private final OrderMapper orderMapper;

    // DIP: collaborators are injected via the constructor as abstractions.
    public OrderService(OrderRepository orderRepository,
                        OrderValidator orderValidator,
                        OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderValidator = orderValidator;
        this.orderMapper = orderMapper;
    }

    public OrderResponse createOrder(OrderRequest request) {
        // SRP: delegate validation - the service doesn't know the rules, only that it must validate.
        orderValidator.validate(request);

        Order order = new Order(request.customerName());
        for (OrderItemRequest itemReq : request.items()) {
            order.addItem(new OrderItem(itemReq.productName(), itemReq.price(), itemReq.quantity()));
        }

        Order saved = orderRepository.save(order);
        // SRP: delegate mapping.
        return orderMapper.toResponse(saved);
    }

    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toResponse)
                .toList();
    }

    public OrderResponse getOrderById(Long id) {
        return orderMapper.toResponse(findOrderOrThrow(id));
    }

    public OrderResponse updateOrderStatus(Long id, String status) {
        Order order = findOrderOrThrow(id);
        order.setStatus(OrderStatus.valueOf(status.toUpperCase()));
        return orderMapper.toResponse(orderRepository.save(order));
    }

    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        orderRepository.deleteById(id);
    }

    // DRY: the "find by id or 404" rule lived in three methods BEFORE. Now it lives once.
    private Order findOrderOrThrow(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }
}
