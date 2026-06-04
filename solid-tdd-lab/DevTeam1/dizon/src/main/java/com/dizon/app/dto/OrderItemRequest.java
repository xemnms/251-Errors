package com.dizon.app.dto;

// OOP: IMMUTABILITY - a Java record is implicitly final with final fields and no setters.
// Once constructed, an OrderItemRequest can never change state. BEFORE this was a mutable
// class with public setters; AFTER it is an immutable record.
// BONUS: DTO pattern - decouples the API contract from the JPA entity.
public record OrderItemRequest(String productName, double price, int quantity) {
}
