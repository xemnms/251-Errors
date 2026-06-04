package com.rodenas.grasp.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// GRASP: Information Expert - Order calculates its own total
// GRASP: Creator - Order creates and owns OrderItems
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String status;
    private String paymentMethod;
    private LocalDateTime createdAt;

    // GRASP: Information Expert - Order owns its items
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private List<OrderItem> items = new ArrayList<>();

    public Order() {
        this.status = "PENDING";
        this.createdAt = LocalDateTime.now();
    }

    public Order(String customerName, String paymentMethod) {
        this();
        this.customerName = customerName;
        this.paymentMethod = paymentMethod;
    }

    // GRASP: Information Expert - Order calculates its own total
    public double calculateTotal() {
        return items.stream().mapToDouble(OrderItem::getSubtotal).sum();
    }

    // GRASP: Creator - Order adds its own items
    public void addItem(OrderItem item) {
        items.add(item);
    }

    public Long getId() { return id; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String c) { this.customerName = c; }
    public String getStatus() { return status; }
    public void setStatus(String s) { this.status = s; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String p) { this.paymentMethod = p; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }
}