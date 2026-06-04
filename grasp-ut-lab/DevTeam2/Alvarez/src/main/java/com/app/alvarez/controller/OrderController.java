package com.app.alvarez.controller;

import com.app.alvarez.dto.CreateOrderRequest;
import com.app.alvarez.dto.OrderResponse;
import com.app.alvarez.dto.PaymentRequest;
import com.app.alvarez.service.OrderUseCase;
import com.app.alvarez.util.OrderMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderUseCase orderUseCase;

    public OrderController(OrderUseCase orderUseCase) {
        this.orderUseCase = orderUseCase;
    }

    // GRASP: Controller - Spring controller receives HTTP requests and delegates work to the service layer.
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse create(@Valid @RequestBody CreateOrderRequest request) {
        return OrderMapper.toResponse(orderUseCase.createOrder(request));
    }

    @GetMapping("/{id}")
    public OrderResponse getById(@PathVariable Long id) {
        return OrderMapper.toResponse(orderUseCase.getOrder(id));
    }

    @PostMapping("/{id}/payments")
    public OrderResponse pay(@PathVariable Long id, @Valid @RequestBody PaymentRequest request) {
        return OrderMapper.toResponse(orderUseCase.payOrder(id, request.method()));
    }
}