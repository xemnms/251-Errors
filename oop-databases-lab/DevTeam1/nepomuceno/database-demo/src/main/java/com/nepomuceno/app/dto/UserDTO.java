package com.nepomuceno.app.dto;

import jakarta.validation.constraints.*;

public class UserDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    private boolean isRegular;

    @NotBlank(message = "Role is required")
    private String role;

    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
    public boolean isRegular() { return isRegular; }
    public String getRole() { return role; }

    public void setName(String name) { this.name = name; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setEmail(String email) { this.email = email; }
    public void setRegular(boolean isRegular) { this.isRegular = isRegular; }
    public void setRole(String role) { this.role = role; }
}