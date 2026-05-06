package com.acosta.springboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;
    private String email;
    private boolean isRegular;
    private String role;

    //Getters with Validation
    public String getName() {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        return name;
    }

    public String getPhoneNumber() {
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Phone Number cannot be empty");
        }
        return phoneNumber;
    }

    public String getEmail() {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        return email;
    }

    public boolean isRegular() {
        return isRegular;
    }

    public String getRole() {
        if (role == null || role.isBlank()) {
            throw new IllegalArgumentException("Role cannot be empty");
        }
        return role;
    }

    //Setters with Validation
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Phone Number cannot be empty");
        }
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        this.email = email;
    }

    public void setRegular(boolean isRegular) {
        this.isRegular = isRegular;
    }

    public void setRole(String role) {
        if (role == null || role.isBlank()) {
            throw new IllegalArgumentException("Role cannot be empty");
        }
        this.role = role;
    }

}