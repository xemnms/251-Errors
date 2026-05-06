package com.acosta.springboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;

    //Getters
    public String getName () {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        if (price == null || price < 0) {
            throw new IllegalArgumentException("Product price cannot be null or negative");
        }
        return price;
    }

    //Setters
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        if (price == null || price < 0) {
            throw new IllegalArgumentException("Product price cannot be null or negative");
        }
        this.price = price;
    }
}