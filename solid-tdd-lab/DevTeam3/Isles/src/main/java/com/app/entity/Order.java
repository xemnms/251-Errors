package com.app.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

    protected Order() {
    }

    public Order(String customerName) {
        this.customerName = customerName;
    }

    // GRASP: Creator - Order creates and owns OrderItem objects that belong to it.
    public void addItem(String productName, int quantity, double unitPrice) {
        // Composition Over Inheritance: Order has OrderItems; items do not inherit from Order.
        OrderItem item = new OrderItem(productName, quantity, unitPrice, this);
        items.add(item);
    }

    // GRASP: Information Expert - Order calculates its own total because it owns the order items.
    public double calculateTotal() {
        return items.stream()
                .mapToDouble(OrderItem::calculateSubtotal)
                .sum();
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<OrderItem> getItems() {
        // Immutability: callers cannot modify the internal item collection directly.
        return Collections.unmodifiableList(items);
    }
}
