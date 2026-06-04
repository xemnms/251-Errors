package com.dizon.app.entity;

import jakarta.persistence.*;

// SOLID: SRP - OrderItem is responsible only for its own line-item data and subtotal.
// GOOD DESIGN PRESERVED (Information Expert): the class that owns price & quantity
// is the one that knows how to compute the subtotal. Left unchanged from the GRASP version.
@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private double price;
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    // JPA requires a no-arg constructor. Entities are intentionally NOT immutable
    // (the persistence layer must hydrate them); immutability is applied to DTOs instead.
    public OrderItem() {}

    public OrderItem(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // SOLID: SRP / Information Expert - the item computes its own subtotal.
    public double getSubtotal() {
        return price * quantity;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }
}
