package com.rodenas.grasp.demo.service;

import com.rodenas.grasp.demo.dto.OrderItemDTO;
import com.rodenas.grasp.demo.dto.OrderRequestDTO;
import com.rodenas.grasp.demo.entity.Order;
import com.rodenas.grasp.demo.entity.OrderItem;
import com.rodenas.grasp.demo.exception.OrderNotFoundException;
import com.rodenas.grasp.demo.payment.PaymentProcessor;
import com.rodenas.grasp.demo.repository.OrderRepository;
import com.rodenas.grasp.demo.util.PriceCalculator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderValidator orderValidator;
    private final PriceCalculator priceCalculator;
    private final Map<String, PaymentProcessor> paymentProcessors;

    public OrderServiceImpl(OrderRepository orderRepository,
                            OrderValidator orderValidator,
                            PriceCalculator priceCalculator,
                            List<PaymentProcessor> processors) {
        this.orderRepository = orderRepository;
        this.orderValidator = orderValidator;
        this.priceCalculator = priceCalculator;
        this.paymentProcessors = processors.stream()
                .collect(Collectors.toMap(processor -> processor.getPaymentMethod().toUpperCase(), Function.identity()));
    }

    @Override
    public Order createOrder(OrderRequestDTO dto) {
        orderValidator.validate(dto);
        Order order = new Order(dto.customerName(), dto.paymentMethod().toUpperCase());
        if (dto.items() != null) {
            dto.items().forEach(itemDTO -> order.addItem(createOrderItem(itemDTO)));
        }

        PaymentProcessor processor = paymentProcessors.get(order.getPaymentMethod());
        if (processor != null) {
            processor.process(order.calculateTotal());
        }

        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    @Override
    public List<Order> getOrdersByStatus(String status) {
        return orderRepository.findByStatus(status.toUpperCase());
    }

    @Override
    public Order updateOrderStatus(Long id, String status) {
        Order order = getOrderById(id);
        order.setStatus(status.toUpperCase());
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = getOrderById(id);
        orderRepository.delete(order);
    }

    @Override
    public double getOrderTotalWithVat(Long id) {
        Order order = getOrderById(id);
        return priceCalculator.calculateTotalWithVat(order);
    }

    @Override
    public String getReceipt(Long id) {
        Order order = getOrderById(id);
        PaymentProcessor processor = paymentProcessors.get(order.getPaymentMethod());
        if (processor != null) {
            return processor.getReceipt(order.calculateTotal());
        }
        return "No receipt available";
    }

    private OrderItem createOrderItem(OrderItemDTO itemDTO) {
        return new OrderItem(itemDTO.menuItemName(), itemDTO.price(), itemDTO.quantity());
    }
}
