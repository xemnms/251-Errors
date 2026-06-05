package com.bautista.grasp.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> items;

    public Order() {
    }

    public Order(List<OrderItem> items) {
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    /*
     * GRASP: Information Expert
     * Order owns OrderItems, so it calculates total.
     */
    public double calculateTotal() {

        if (items == null || items.isEmpty()) {
            return 0.0;
        }

        return items.stream()
                .mapToDouble(OrderItem::getSubTotal)
                .sum();
    }
}