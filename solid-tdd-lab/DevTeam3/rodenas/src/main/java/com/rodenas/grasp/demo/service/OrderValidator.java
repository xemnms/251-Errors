package com.rodenas.grasp.demo.service;

import com.rodenas.grasp.demo.dto.OrderRequestDTO;

// SRP: Validation is separated from order creation and persistence.
public interface OrderValidator {
    void validate(OrderRequestDTO dto);
}
