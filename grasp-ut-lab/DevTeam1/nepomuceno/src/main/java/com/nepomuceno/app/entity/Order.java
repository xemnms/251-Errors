package com.nepomuceno.app.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

// GRASP: Information Expert — Order calculates its own total (owns the data)
// GRASP: Creator — Order creates OrderItem objects via addItem()
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    // GRASP: Information Expert — owns the items, so it calculates the total
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<OrderItem> items = new ArrayList<>();

    public Order() {
        this.status = "PENDING";
    }

    // GRASP: Information Expert — logic is inside the class that owns the data
    public double calculateTotal() {
        return items.stream()
                    .mapToDouble(OrderItem::getSubtotal)
                    .sum();
    }

    // GRASP: Creator — Order is responsible for creating its own OrderItems
    public void addItem(String name, double price, int quantity) {
        this.items.add(new OrderItem(name, price, quantity));
    }

    public Long getId() { return id; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public List<OrderItem> getItems() { return items; }
}
