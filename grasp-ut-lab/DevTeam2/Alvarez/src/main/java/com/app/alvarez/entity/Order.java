package com.app.alvarez.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "customer_orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private Instant createdAt;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<OrderItem> items = new ArrayList<>();

    protected Order() {
    }

    private Order(String customerName) {
        this.customerName = customerName;
        this.createdAt = Instant.now();
        this.status = OrderStatus.CREATED;
    }

    // GRASP: Creator - Order creates and owns its OrderItem objects because it aggregates them.
    public static Order createWithItems(String customerName, List<OrderItem> items) {
        Order order = new Order(customerName);
        items.forEach(order::addItem);
        return order;
    }

    // GRASP: High Cohesion - Order only manages order state and item membership.
    public void addItem(OrderItem item) {
        item.assignTo(this);
        items.add(item);
    }

    // GRASP: Information Expert - Order calculates its own total from the items it owns.
    public double calculateTotal() {
        return items.stream()
                .mapToDouble(OrderItem::calculateSubtotal)
                .sum();
    }

    public void markPaid() {
        this.status = OrderStatus.PAID;
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }
}