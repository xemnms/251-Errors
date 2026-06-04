package com.app.service;

import com.app.entity.Order;
import com.app.entity.OrderItem;
import com.app.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    // GRASP: Pure Fabrication
    public Order createOrder(Order order) {

        if(order == null){
            throw new IllegalArgumentException(
                    "Order cannot be null");
        }

        return repository.save(order);
    }

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public Order getOrder(Long id) {
        return repository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Order not found"));
    }

    // GRASP: Creator
    public Order createSampleOrder() {

        Order order = new Order();

        OrderItem item =
                new OrderItem(
                        null,
                        "Laptop",
                        2,
                        500
                );

        order.getItems().add(item);

        return repository.save(order);
    }
}