package com.app.costiniano.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();
    
    private double totalAmount;
    private String status;

    public Order() { 
        this.status = "PENDING"; 
    }

    // GRASP: Creator - Order creates its own OrderItems because it aggregates them.
    public void addItem(String name, double price, int quantity) {
        this.items.add(new OrderItem(name, price, quantity));
        this.totalAmount = calculateTotal();
    }

    // GRASP: Information Expert - Order owns the item data, so it calculates its own total cost.
    public double calculateTotal() {
        return items.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public List<OrderItem> getItems() { return items; }
    public double getTotalAmount() { return totalAmount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}