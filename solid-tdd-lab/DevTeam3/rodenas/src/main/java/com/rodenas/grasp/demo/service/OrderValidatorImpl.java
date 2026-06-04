package com.rodenas.grasp.demo.service;

import com.rodenas.grasp.demo.dto.OrderItemDTO;
import com.rodenas.grasp.demo.dto.OrderRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class OrderValidatorImpl implements OrderValidator {

    @Override
    public void validate(OrderRequestDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Order request cannot be null");
        }
        if (dto.customerName() == null || dto.customerName().trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be empty");
        }
        if (dto.paymentMethod() == null || dto.paymentMethod().trim().isEmpty()) {
            throw new IllegalArgumentException("Payment method is required");
        }
        if (dto.items() != null) {
            for (OrderItemDTO item : dto.items()) {
                if (item.menuItemName() == null || item.menuItemName().trim().isEmpty()) {
                    throw new IllegalArgumentException("Menu item name cannot be empty");
                }
                if (item.price() <= 0) {
                    throw new IllegalArgumentException("Price must be greater than zero");
                }
                if (item.quantity() <= 0) {
                    throw new IllegalArgumentException("Quantity must be at least one");
                }
            }
        }
    }
}
