package com.acosta.springboot.entity;

import jakarta.persistence.*;

// OOP: Immutability - core fields are final and set only at construction
// SOLID: SRP - OrderItem only knows about itself, not order logic
// GRASP: Information Expert - OrderItem knows its own price, quantity, subtotal
@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // OOP: Immutability - these fields cannot change after construction
    private final String productName;
    private final double price;
    private final int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    // Required by JPA — do NOT use this directly in your code
    protected OrderItem() {
        this.productName = null;
        this.price = 0;
        this.quantity = 0;
    }

    // OOP: Immutability - all values must be provided at construction
    // KISS: Simple validation, clear error messages
    public OrderItem(String productName, double price, int quantity) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // GRASP: Information Expert - OrderItem calculates its own subtotal
    public double getSubtotal() {
        return price * quantity;
    }

    // Getters only — no setters for business fields (immutability)
    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // order reference still needs a setter for JPA relationship wiring
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}