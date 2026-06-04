package com.app.alvarez.service;

import com.app.alvarez.dto.CreateOrderRequest;
import com.app.alvarez.dto.OrderItemRequest;
import com.app.alvarez.entity.Order;
import com.app.alvarez.entity.OrderItem;
import com.app.alvarez.entity.PaymentMethod;
import com.app.alvarez.exception.OrderNotFoundException;
import com.app.alvarez.repository.OrderRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService implements OrderUseCase {

    private final OrderRepository orderRepository;
    private final PaymentProcessorResolver paymentProcessorResolver;
    private final OrderRequestValidator validator;

    public OrderService(
            OrderRepository orderRepository,
            PaymentProcessorResolver paymentProcessorResolver,
            OrderRequestValidator validator
    ) {
        this.orderRepository = orderRepository;
        this.paymentProcessorResolver = paymentProcessorResolver;
        this.validator = validator;
    }

    // GRASP: Pure Fabrication - service coordinates business use cases without owning persistence details.
    // GRASP: Low Coupling - service depends on repository/resolver interfaces instead of concrete implementations.
    @Transactional
    @Override
    public Order createOrder(CreateOrderRequest request) {
        validator.validate(request);
        List<OrderItem> items = request.items().stream()
                .map(this::toEntity)
                .toList();
        Order order = Order.createWithItems(request.customerName(), items);
        return orderRepository.save(order);
    }

    @Transactional(readOnly = true)
    @Override
    public Order getOrder(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    @Transactional
    @Override
    public Order payOrder(Long id, PaymentMethod method) {
        Order order = getOrder(id);
        PaymentProcessor processor = paymentProcessorResolver.resolve(method);
        processor.process(order.calculateTotal());
        order.markPaid();
        return orderRepository.save(order);
    }

    private OrderItem toEntity(OrderItemRequest item) {
        return new OrderItem(item.productName(), item.quantity(), item.unitPrice());
    }
}