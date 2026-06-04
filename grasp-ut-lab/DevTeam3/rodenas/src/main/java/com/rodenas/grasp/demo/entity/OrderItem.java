package com.rodenas.grasp.demo.entity;

import jakarta.persistence.*;

// GRASP: Information Expert - OrderItem knows its own subtotal
// GRASP: Creator - OrderItem is created with all data it needs
@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String menuItemName;
    private double price;
    private int quantity;

    public OrderItem() {}

    public OrderItem(String menuItemName, double price, int quantity) {
        this.menuItemName = menuItemName;
        this.price = price;
        this.quantity = quantity;
    }

    // GRASP: Information Expert - subtotal calculated by the class that owns the data
    public double getSubtotal() {
        return price * quantity;
    }

    public Long getId() { return id; }
    public String getMenuItemName() { return menuItemName; }
    public void setMenuItemName(String n) { this.menuItemName = n; }
    public double getPrice() { return price; }
    public void setPrice(double p) { this.price = p; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int q) { this.quantity = q; }
}
