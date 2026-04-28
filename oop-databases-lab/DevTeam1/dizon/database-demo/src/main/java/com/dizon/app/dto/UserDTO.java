package com.dizon.springboot.dto; 
import jakarta.validation.constraints.*;

public class UserDTO {
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100)
    private String name;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9+\\-() ]{7,20}$", message = "Invalid phone number format")
    private String phoneNumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    private boolean isRegular;

    @NotBlank(message = "Role is required")
    private String role;

    public UserDTO() {}

    public UserDTO(Long id, String name, String phoneNumber, String email, boolean isRegular, String role) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.isRegular = isRegular;
        this.role = role;
    }

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