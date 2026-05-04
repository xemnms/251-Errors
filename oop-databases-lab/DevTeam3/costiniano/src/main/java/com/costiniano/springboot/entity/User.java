package com.costiniano.springboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users_table") // This fixes the SQL syntax error
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;
    private String email;
    private boolean isRegular;
    private String role;

    public User() {}

    // Getters and Setters stay exactly as you have them
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public boolean isRegular() { return isRegular; }
    public void setRegular(boolean regular) { isRegular = regular; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}