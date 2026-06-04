package com.app.alvarez.service;

import com.app.alvarez.dto.CreateOrderRequest;
import com.app.alvarez.entity.Order;
import com.app.alvarez.entity.PaymentMethod;

// GRASP: Protected Variations - controller depends on this use-case interface, allowing service changes behind it.
public interface OrderUseCase {

    Order createOrder(CreateOrderRequest request);

    Order getOrder(Long id);

    Order payOrder(Long id, PaymentMethod method);
}