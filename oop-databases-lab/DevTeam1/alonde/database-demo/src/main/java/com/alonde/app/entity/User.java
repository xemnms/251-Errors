package com.alonde.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "users")  // "user" is a reserved SQL word, use "users"
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;       // auto-generated ID

    private String name;
    private String phoneNumber;
    private String email;
    private boolean isRegular;
    private String role;

}