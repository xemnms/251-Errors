package com.app.service;

import com.app.dto.CreateOrderRequest;
import com.app.dto.OrderItemRequest;
import com.app.dto.OrderResponse;
import com.app.entity.Order;
import com.app.exception.InvalidOrderException;
import com.app.exception.OrderNotFoundException;
import com.app.repository.OrderRepository;
import com.app.util.OrderValidation;
import com.app.util.OrderValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private PaymentGateway paymentGateway;

    private final OrderValidation orderValidation = new OrderValidator();

    private OrderService orderService;

    @BeforeEach
    void setUp() {
        orderService = new OrderService(orderRepository, paymentGateway, orderValidation);
    }

    @Test
    void shouldCreateOrder() {
        CreateOrderRequest request = validRequest();
        when(orderRepository.save(any(Order.class))).thenAnswer(invocation -> invocation.getArgument(0));
        when(paymentGateway.process("CREDIT_CARD", 25.0)).thenReturn(new PaymentReceipt("credit-card", 25.0, "APPROVED"));

        OrderResponse response = orderService.createOrder(request);

        assertThat(response.customerName()).isEqualTo("Avi Cohen");
        assertThat(response.items()).hasSize(2);
        assertThat(response.total()).isEqualTo(25.0);
        verify(orderRepository).save(any(Order.class));
    }

    @Test
    void shouldSendCalculatedTotalToPaymentProcessorBeforeSaving() {
        CreateOrderRequest request = validRequest();
        when(orderRepository.save(any(Order.class))).thenAnswer(invocation -> invocation.getArgument(0));
        when(paymentGateway.process("CREDIT_CARD", 25.0)).thenReturn(new PaymentReceipt("credit-card", 25.0, "APPROVED"));

        orderService.createOrder(request);

        verify(paymentGateway).process("CREDIT_CARD", 25.0);
    }

    @Test
    void shouldRejectEmptyItemList() {
        CreateOrderRequest request = new CreateOrderRequest("Avi Cohen", "CREDIT_CARD", List.of());

        assertThatThrownBy(() -> orderService.createOrder(request))
                .isInstanceOf(InvalidOrderException.class)
                .hasMessage("Order must contain at least one item");
        verify(orderRepository, never()).save(any());
        verify(paymentGateway, never()).process(any(), anyDouble());
    }

    @Test
    void shouldRejectNullRequest() {
        assertThatThrownBy(() -> orderService.createOrder(null))
                .isInstanceOf(InvalidOrderException.class)
                .hasMessage("Order request is required");
        verify(orderRepository, never()).save(any());
    }

    @Test
    void shouldRejectInvalidQuantity() {
        CreateOrderRequest request = new CreateOrderRequest(
                "Avi Cohen",
                "CREDIT_CARD",
                List.of(new OrderItemRequest("Keyboard", 0, 100.0)));

        assertThatThrownBy(() -> orderService.createOrder(request))
                .isInstanceOf(InvalidOrderException.class)
                .hasMessage("Quantity must be greater than zero");
        verify(orderRepository, never()).save(any());
    }

    @Test
    void shouldReturnOrderById() {
        Order order = new Order("Avi Cohen");
        order.addItem("Mouse", 1, 15.0);
        when(orderRepository.findById(7L)).thenReturn(Optional.of(order));

        OrderResponse response = orderService.getOrder(7L);

        assertThat(response.customerName()).isEqualTo("Avi Cohen");
        assertThat(response.total()).isEqualTo(15.0);
    }

    @Test
    void shouldThrowWhenOrderDoesNotExist() {
        when(orderRepository.findById(99L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> orderService.getOrder(99L))
                .isInstanceOf(OrderNotFoundException.class)
                .hasMessage("Order 99 was not found");
    }

    @Test
    void shouldCreateRelatedItemsInsideOrderEntity() {
        CreateOrderRequest request = validRequest();
        when(orderRepository.save(any(Order.class))).thenAnswer(invocation -> invocation.getArgument(0));
        when(paymentGateway.process("CREDIT_CARD", 25.0)).thenReturn(new PaymentReceipt("credit-card", 25.0, "APPROVED"));
        ArgumentCaptor<Order> orderCaptor = ArgumentCaptor.forClass(Order.class);

        orderService.createOrder(request);

        verify(orderRepository).save(orderCaptor.capture());
        assertThat(orderCaptor.getValue().getItems()).hasSize(2);
    }

    private CreateOrderRequest validRequest() {
        return new CreateOrderRequest(
                "Avi Cohen",
                "CREDIT_CARD",
                List.of(
                        new OrderItemRequest("Keyboard", 2, 10.0),
                        new OrderItemRequest("Mouse", 1, 5.0)));
    }
}
