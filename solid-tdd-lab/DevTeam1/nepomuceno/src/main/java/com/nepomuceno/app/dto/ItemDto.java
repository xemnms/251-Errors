package com.nepomuceno.app.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

// SOLID: SRP - carries item data only; no logic
// OOP: Immutability - all fields are final; no setters
//
// BEFORE (mutable DTO with setters):
//   private String name;
//   public void setName(String name) { this.name = name; }
//
// AFTER (immutable DTO):
//   private final String name;
//   (no setters)
//
// WHY: DTOs travel across layers and should never change mid-flight.
// Making them immutable prevents accidental mutation and makes them
// safe to pass around without defensive copying.
public final class ItemDto {

    private final String name;
    private final double price;
    private final int quantity;

    @JsonCreator
    public ItemDto(@JsonProperty("name")     String name,
                   @JsonProperty("price")    double price,
                   @JsonProperty("quantity") int    quantity) {
        this.name     = name;
        this.price    = price;
        this.quantity = quantity;
    }

    public String getName()    { return name; }
    public double getPrice()   { return price; }
    public int    getQuantity(){ return quantity; }
}
