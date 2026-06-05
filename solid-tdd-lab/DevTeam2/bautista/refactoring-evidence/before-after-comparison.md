# Refactoring Evidence

## SRP

`OrderServiceImpl` was doing order creation and payment processing at the same time. Pulled payment out into `PaymentServiceImpl` and validation into `OrderValidatorImpl`.

Before — `OrderServiceImpl` had this method that had no business being there:
```java
public String processPayment(Long orderId, String paymentType) {
    Order order = orderRepository.findById(orderId)
            .orElseThrow(() -> new OrderNotFoundException("Order not found: " + orderId));
    double total = order.calculateTotal();
    Payment payment = PaymentFactory.getPayment(paymentType);
    return payment.process(total);
}
```

After — `OrderServiceImpl` just delegates validation and builds the order:
```java
public OrderResponseDTO createOrder(OrderRequestDTO request) {
    orderValidator.validate(request);
    List<OrderItem> items = request.getItems().stream()
            .map(dto -> {
                Product product = productRepository.findById(dto.getProductId())
                        .orElseThrow(() -> new ProductNotFoundException("Product not found: " + dto.getProductId()));
                return OrderItemMapper.toEntity(dto, product);
            }).toList();
    Order order = new Order(items);
    Order saved = orderRepository.save(order);
    return new OrderResponseDTO(saved.getId(), saved.calculateTotal());
}
```

---

## OCP

Before — only CARD and CASH, adding anything new meant editing the factory:
```java
private static final Map<String, Supplier<Payment>> REGISTRY = Map.of(
        "CARD", CardPayment::new,
        "CASH", CashPayment::new
);
```

After — added GCash by writing one new class and one line in the registry. Nothing else changed:
```java
private static final Map<String, Supplier<Payment>> REGISTRY = Map.of(
        "CARD", CardPayment::new,
        "CASH", CashPayment::new,
        "GCASH", GCashPayment::new
);
```

---

## LSP

All three payment types go through the same `Payment` interface and all return the same format. The test confirms any of them can substitute for each other:
```java
List<Payment> payments = List.of(new CardPayment(), new CashPayment(), new GCashPayment());
for (Payment payment : payments) {
    String result = payment.process(100.0);
    assertNotNull(result);
    assertTrue(result.contains("SUCCESS"));
}
```

---

## ISP

Before — `OrderService` had `processPayment` in it even though it is a payment concern, not an order concern:
```java
public interface OrderService {
    OrderResponseDTO createOrder(OrderRequestDTO request);
    double getOrderTotal(Long orderId);
    String processPayment(Long orderId, String paymentType);
}
```

After — split into two focused interfaces:
```java
public interface OrderService {
    OrderResponseDTO createOrder(OrderRequestDTO request);
    double getOrderTotal(Long orderId);
}

public interface PaymentService {
    String processPayment(Long orderId, String paymentType);
}
```

---

## DIP

Before — `OrderServiceImpl` called `PaymentFactory` statically, which means it cannot be mocked or swapped:
```java
Payment payment = PaymentFactory.getPayment(paymentType);
```

After — `PaymentServiceImpl` receives `PaymentProvider` through the constructor. Spring injects `PaymentFactory` in production, a mock gets injected in tests:
```java
public PaymentServiceImpl(OrderRepository orderRepository, PaymentProvider paymentProvider) {
    this.orderRepository = orderRepository;
    this.paymentProvider = paymentProvider;
}

Payment payment = paymentProvider.getPayment(paymentType);
```

---

## Immutability

`ImmutableOrderItem` is a Java record. Fields are final by default, no setters are generated, and the compact constructor validates on creation:
```java
public record ImmutableOrderItem(Long productId, String productName, double price, int quantity) {
    public ImmutableOrderItem {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive");
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
        if (productName == null || productName.isBlank()) throw new IllegalArgumentException("Product name is required");
    }

    public double calculateSubtotal() {
        return price * quantity;
    }
}
```
