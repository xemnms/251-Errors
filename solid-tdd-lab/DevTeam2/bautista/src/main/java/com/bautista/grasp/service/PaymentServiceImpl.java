package com.bautista.grasp.service;

import com.bautista.grasp.entity.Order;
import com.bautista.grasp.entity.Payment;
import com.bautista.grasp.exception.OrderNotFoundException;
import com.bautista.grasp.repository.OrderRepository;
import org.springframework.stereotype.Service;

// SRP: Handles only payment processing - order creation and retrieval live elsewhere
// DIP: Depends on PaymentProvider abstraction, not on PaymentFactory directly
@Service
public class PaymentServiceImpl implements PaymentService {

    private final OrderRepository orderRepository;
    private final PaymentProvider paymentProvider; // DIP: abstraction, not a concrete factory

    public PaymentServiceImpl(OrderRepository orderRepository, PaymentProvider paymentProvider) {
        this.orderRepository = orderRepository;
        this.paymentProvider = paymentProvider;
    }

    @Override
    public String processPayment(Long orderId, String paymentType) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() ->
                        new OrderNotFoundException("Order not found: " + orderId));

        double total = order.calculateTotal();

        // DIP: we ask the abstraction for a Payment - we don't know or care which concrete class returns
        // OCP: adding a new payment type only requires adding it to PaymentFactory registry, not here
        Payment payment = paymentProvider.getPayment(paymentType);

        return payment.process(total);
    }
}
