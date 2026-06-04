package com.rodenas.grasp.demo.service;

import com.rodenas.grasp.demo.dto.OrderRequestDTO;

public interface OrderValidator {
    void validate(OrderRequestDTO dto);
}
