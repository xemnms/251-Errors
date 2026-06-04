package com.app.util;

import com.app.dto.OrderDTO;
import org.springframework.stereotype.Component;

// GRASP: High Cohesion - only responsible for validating order input
@Component
public class OrderValidatorImpl implements OrderValidator {
    @Override
    public boolean isValid(OrderDTO dto) {
        if (dto == null) return false;
        if (dto.getCustomerName() == null || dto.getCustomerName().isBlank()) return false;
        if (dto.getPaymentType() == null || dto.getPaymentType().isBlank()) return false;
        return true;
    }
}
