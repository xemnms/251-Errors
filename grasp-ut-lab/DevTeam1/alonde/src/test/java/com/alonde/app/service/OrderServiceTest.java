package com.alonde.app.service;

import com.alonde.app.dto.*;
import com.alonde.app.entity.*;
import com.alonde.app.entity.Order;
import com.alonde.app.exception.OrderNotFoundException;
import com.alonde.app.payment.*;
import com.alonde.app.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository repo;

    @Mock
    private PaymentProcessorFactory paymentFactory;

    @Mock
    private PaymentProcessor mockProcessor;

    @InjectMocks
    private OrderService service;

    // test 1: creating an order succeeds

    @Test
    void shouldCreateOrderSuccessfully() {
        // arrange
        CreateOrderRequest req = buildRequest("Maria Santos", "CASH", "Laptop", 1, 50000.0);

        Order savedOrder = new Order("Maria Santos", "CASH");
        savedOrder.addItem("Laptop", 1, 50000.0);

        when(paymentFactory.getProcessor("CASH")).thenReturn(mockProcessor);
        when(repo.save(any(Order.class))).thenReturn(savedOrder);

        // act
        OrderResponse result = service.createOrder(req);

        // assert
        assertThat(result).isNotNull();
        assertThat(result.getCustomerName()).isEqualTo("Maria Santos");
        assertThat(result.getTotal()).isEqualTo(50000.0);
        verify(mockProcessor).process(50000.0);  // payment was called
    }

    // test 2: get all orders returns correct list

    @Test
    void shouldReturnAllOrders() {
        // arrange
        Order o1 = new Order("Ana", "CASH");
        Order o2 = new Order("Ben", "GCASH");
        when(repo.findAll()).thenReturn(List.of(o1, o2));

        // act
        List<OrderResponse> results = service.getAllOrders();

        // assert
        assertThat(results).hasSize(2);
        assertThat(results.get(0).getCustomerName()).isEqualTo("Ana");
    }

    // test 3: get by id - order found

    @Test
    void shouldReturnOrderById() {
        // arrange
        Order order = new Order("Carlo", "CREDIT_CARD");
        when(repo.findById(1L)).thenReturn(Optional.of(order));

        // act
        OrderResponse result = service.getOrderById(1L);

        // assert
        assertThat(result.getCustomerName()).isEqualTo("Carlo");
    }

    // test 4: get by id - order NOT found -> exception

    @Test
    void shouldThrowWhenOrderNotFound() {
        // arrange
        when(repo.findById(99L)).thenReturn(Optional.empty());

        // act and assert
        assertThatThrownBy(() -> service.getOrderById(99L))
                .isInstanceOf(OrderNotFoundException.class)
                .hasMessageContaining("99");
    }

    // test 5: cancel order changes status

    @Test
    void shouldCancelOrder() {
        // arrange
        Order order = new Order("Diana", "CASH");
        when(repo.findById(1L)).thenReturn(Optional.of(order));
        when(repo.save(any())).thenReturn(order);

        // act
        service.cancelOrder(1L);

        // assert
        assertThat(order.getStatus()).isEqualTo("CANCELLED");
        verify(repo).save(order);
    }

    // test 6: empty item list - total is 0

    @Test
    void shouldReturnZeroTotalForEmptyOrder() {
        // arrange
        Order emptyOrder = new Order("Empty", "CASH");
        when(repo.findAll()).thenReturn(List.of(emptyOrder));

        // act
        List<OrderResponse> result = service.getAllOrders();

        // assert
        assertThat(result.get(0).getTotal()).isEqualTo(0.0);
    }

    // test 7: delete - not found -> exception

    @Test
    void shouldThrowWhenDeletingNonExistentOrder() {
        when(repo.existsById(77L)).thenReturn(false);

        assertThatThrownBy(() -> service.deleteOrder(77L))
                .isInstanceOf(OrderNotFoundException.class);
    }

    // helper: builds a simple CreateOrderRequest
    private CreateOrderRequest buildRequest(String customer, String payType,
                                            String product, int qty, double price) {
        OrderItemRequest item = new OrderItemRequest();
        item.setProductName(product);
        item.setQuantity(qty);
        item.setUnitPrice(price);

        CreateOrderRequest req = new CreateOrderRequest();
        req.setCustomerName(customer);
        req.setPaymentType(payType);
        req.setItems(List.of(item));
        return req;
    }
}
