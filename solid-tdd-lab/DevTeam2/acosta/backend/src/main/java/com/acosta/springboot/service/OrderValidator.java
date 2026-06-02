package com.acosta.springboot.service;

import com.acosta.springboot.dto.OrderRequest;

// SOLID: ISP - Small, focused interface with one responsibility
// SOLID: DIP - OrderService depends on this abstraction, not a concrete class
public interface OrderValidator {
    void validate(OrderRequest request);
}