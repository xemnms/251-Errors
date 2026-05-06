package com.alvarez.demo.fullstack;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data // This automatically adds Getters and Setters (Lombok)
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Double price;

    private Integer quantity;
}