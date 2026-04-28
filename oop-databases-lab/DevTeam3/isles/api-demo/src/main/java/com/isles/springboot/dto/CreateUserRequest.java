package com.isles.springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateUserRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String phoneNumber;

    @Email
    @NotBlank
    private String email;

    @NotNull
    private Boolean regular;

    @NotBlank
    private String role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getRegular() {
        return regular;
    }

    public void setRegular(Boolean regular) {
        this.regular = regular;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
