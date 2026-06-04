package com.app.util;

import com.app.dto.OrderDTO;

// GRASP: Pure Fabrication - not a real-world concept, created for clean separation
// GRASP: Protected Variations - impl hidden behind interface, easily swappable and mockable
public interface OrderValidator {
    boolean isValid(OrderDTO dto);
}
