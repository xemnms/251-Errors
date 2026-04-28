package com.dizon.springboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9+\\-() ]{7,20}$", message = "Invalid phone number format")
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "is_regular")
    private boolean isRegular;

    @NotBlank(message = "Role is required")
    @Column(nullable = false)
    private String role;

    // ─── Constructors ────────────────────────────────────────────────────────

    public User() {}

    public User(String name, String phoneNumber, String email, boolean isRegular, String role) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.isRegular = isRegular;
        this.role = role;
    }

    // ─── Getters & Setters ───────────────────────────────────────────────────

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