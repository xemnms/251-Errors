package com.alonde.app.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String status;       // "pending", "paid", "cancelled"
    private String paymentType;  // "credit_card", "cash", "gcash"
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

    public Order() {}
    public Order(String customerName, String paymentType) {
        this.customerName = customerName;
        this.paymentType  = paymentType;
        this.status       = "PENDING";
        this.createdAt    = LocalDateTime.now();
    }

    // grasp: information expert - order owns items, so it calculates the total
    public double calculateTotal() {
        return items.stream()
                .mapToDouble(i -> i.getUnitPrice() * i.getQuantity())
                .sum();
    }

    // grasp: creator - order creates and links its own OrderItems
    public void addItem(String productName, int qty, Double price) {
        OrderItem item = new OrderItem(productName, qty, price);
        item.setOrder(this);
        items.add(item);
    }

    // getters and setters
    public Long getId()                     { return id; }
    public String getCustomerName()         { return customerName; }
    public void setCustomerName(String n)   { this.customerName = n; }
    public String getStatus()               { return status; }
    public void setStatus(String s)         { this.status = s; }
    public String getPaymentType()          { return paymentType; }
    public void setPaymentType(String t)    { this.paymentType = t; }
    public LocalDateTime getCreatedAt()     { return createdAt; }
    public List<OrderItem> getItems()       { return items; }
}