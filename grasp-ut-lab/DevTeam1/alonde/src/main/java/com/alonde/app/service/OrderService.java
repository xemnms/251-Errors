package com.alonde.app.service;

import com.alonde.app.dto.*;
import com.alonde.app.entity.Order;
import com.alonde.app.exception.OrderNotFoundException;
import com.alonde.app.payment.*;
import com.alonde.app.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

// grasp: pure fabrication - invented class that holds business logic
// grasp: high cohesion - only does business logic
// grasp: low coupling - depends on interfaces (repo, factory), not concrete DB/payment classes
@Service
public class OrderService {

    private final OrderRepository         repo;
    private final PaymentProcessorFactory  paymentFactory;

    public OrderService(OrderRepository repo, PaymentProcessorFactory paymentFactory) {
        this.repo           = repo;
        this.paymentFactory = paymentFactory;
    }

    // grasp: creator - service creates Order and delegates item creation to Order itself
    public OrderResponse createOrder(CreateOrderRequest req) {
        Order order = new Order(req.getCustomerName(), req.getPaymentType());

        for (OrderItemRequest item : req.getItems()) {
            order.addItem(item.getProductName(), item.getQuantity(), item.getUnitPrice());
        }

        Order saved = repo.save(order);

        // process payment using the polymorphic processor
        PaymentProcessor processor = paymentFactory.getProcessor(req.getPaymentType());
        processor.process(saved.calculateTotal());
        saved.setStatus("PAID");
        repo.save(saved);

        return toResponse(saved);
    }

    public List<OrderResponse> getAllOrders() {
        return repo.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public OrderResponse getOrderById(Long id) {
        Order order = repo.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        return toResponse(order);
    }

    public void cancelOrder(Long id) {
        Order order = repo.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        order.setStatus("CANCELLED");
        repo.save(order);
    }

    public void deleteOrder(Long id) {
        if (!repo.existsById(id)) throw new OrderNotFoundException(id);
        repo.deleteById(id);
    }

    // private helper - converts Order entity -> OrderResponse DTO
    private OrderResponse toResponse(Order o) {
        return new OrderResponse(
                o.getId(), o.getCustomerName(),
                o.getStatus(), o.getPaymentType(),
                o.calculateTotal()   // grasp: info expert - order calculates its own total
        );
    }
}
