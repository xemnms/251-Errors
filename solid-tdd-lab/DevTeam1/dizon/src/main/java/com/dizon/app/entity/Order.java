package com.dizon.app.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// SOLID: SRP - Order owns its items and its own total calculation, nothing else.
// OOP: COMPOSITION OVER INHERITANCE - an Order HAS-A list of OrderItem (composition),
//      rather than extending some "ItemContainer" base class. Behaviour is built by
//      composing items, not by inheriting from a hierarchy.
// GOOD DESIGN PRESERVED (Information Expert): calculateTotal() lives where the item
//      data lives. Unchanged from the GRASP version because it was already correct.
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

    public Order() {}

    public Order(String customerName) {
        this.customerName = customerName;
        this.status = OrderStatus.PENDING;
        this.createdAt = LocalDateTime.now();
    }

    // SOLID: SRP / Information Expert - Order computes its own total from data it owns.
    public double calculateTotal() {
        return items.stream()
                .mapToDouble(OrderItem::getSubtotal)
                .sum();
    }

    // OOP: COMPOSITION - Order manages the lifecycle of the items it is composed of.
    public void addItem(OrderItem item) {
        item.setOrder(this);
        items.add(item);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }
}
