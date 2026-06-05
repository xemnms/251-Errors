package com.bautista.grasp.service;

import com.bautista.grasp.dto.OrderRequestDTO;

// SRP: Dedicated interface for order validation only - not mixed into service logic
// ISP: Small focused interface, implementors are not forced to handle unrelated concerns
public interface OrderValidator {

    void validate(OrderRequestDTO request);
}
