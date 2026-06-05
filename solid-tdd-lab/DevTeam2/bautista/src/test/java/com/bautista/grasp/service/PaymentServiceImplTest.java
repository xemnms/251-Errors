package com.bautista.grasp.service;

import com.bautista.grasp.entity.*;
import com.bautista.grasp.exception.OrderNotFoundException;
import com.bautista.grasp.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PaymentServiceImplTest {

    @Mock
    OrderRepository orderRepository;

    // DIP proof: we mock the interface, not PaymentFactory directly
    @Mock
    PaymentProvider paymentProvider;

    @InjectMocks
    PaymentServiceImpl paymentService;

    @Test
    void shouldProcessPaymentUsingAbstraction() {

        // DIP: mocking the abstraction - this test has zero knowledge of PaymentFactory
        Payment mockPayment = mock(Payment.class);
        when(mockPayment.process(1000.0))
                .thenReturn("[PAYMENT SUCCESS] method=CARD | amount=1000.00 | status=SUCCESS");
        when(paymentProvider.getPayment("CARD")).thenReturn(mockPayment);

        // Using real Order instance (Mockito cannot inline-mock JPA entities on Java 25)
        Product product = new Product(1L, "Laptop", 1000.0);
        Order order = new Order(List.of(new OrderItem(product, 1)));
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        String result = paymentService.processPayment(1L, "CARD");

        assertTrue(result.contains("SUCCESS"));
        // verify the abstraction was used, not any concrete implementation
        verify(paymentProvider).getPayment("CARD");
    }

    @Test
    void shouldThrowWhenOrderNotFoundDuringPayment() {

        when(orderRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(OrderNotFoundException.class,
                () -> paymentService.processPayment(99L, "CASH"));
    }

    @Test
    void shouldWorkWithAnyPaymentImplementationViaDIP() {

        // LSP: GCashPayment substitutes cleanly for Payment - system does not break
        Payment gcash = new GCashPayment();
        when(paymentProvider.getPayment("GCASH")).thenReturn(gcash);

        Product product = new Product(2L, "Bag", 250.0);
        Order order = new Order(List.of(new OrderItem(product, 2)));
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        String result = paymentService.processPayment(1L, "GCASH");

        assertTrue(result.contains("GCASH"));
        assertTrue(result.contains("SUCCESS"));
    }
}
