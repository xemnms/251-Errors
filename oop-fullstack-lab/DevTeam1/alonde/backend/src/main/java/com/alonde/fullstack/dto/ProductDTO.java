package com.alonde.fullstack.dto;

import jakarta.validation.constraints.*;

public class ProductDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be positive")
    private Double price;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String d) { this.description = d; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}