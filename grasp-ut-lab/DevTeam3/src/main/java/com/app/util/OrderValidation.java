package com.app.util;

import com.app.dto.CreateOrderRequest;

// GRASP: Protected Variations - validation rules can change without changing OrderService.
public interface OrderValidation {

    void validate(CreateOrderRequest request);
}
