package com.app.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

// GRASP: Information Expert - Order calculates its own total from its own data
// GRASP: Creator - Order creates and manages its own OrderItems
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

    public Order() {}

    public Order(String customerName) {
        this.customerName = customerName;
        this.status = "PENDING";
    }

    // GRASP: Information Expert - logic lives where the data lives
    public double calculateTotal() {
        return items.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }

    // GRASP: Creator - Order is responsible for creating its own items
    public void addItem(String productName, double price, int quantity) {
        OrderItem item = new OrderItem(productName, price, quantity, this);
        this.items.add(item);
    }

    public Long getId() { return id; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String name) { this.customerName = name; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public List<OrderItem> getItems() { return items; }
}
