package com.bautista.grasp.entity;

import jakarta.persistence.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    @ManyToOne
    private Product product;

    public OrderItem() {
    }

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    /*
     * GRASP: Information Expert
     * This class owns both product and quantity,
     * so it is responsible for subtotal calculation.
     */
    public double getSubTotal() {
        return product.getPrice() * quantity;
    }
}