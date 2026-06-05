# SOLID + Unit Testing Lab — Bautista

Spring Boot project refactored from the GRASP + Unit Testing lab.

---

## What was refactored

| Before | After | Principle |
|--------|-------|-----------|
| `OrderServiceImpl` handled order creation AND payment processing | `OrderServiceImpl` handles orders only; `PaymentServiceImpl` handles payments | SRP |
| `PaymentFactory` was a static utility class | `PaymentFactory` implements `PaymentProvider` interface as a `@Component` | DIP |
| `OrderService` interface had 3 methods (createOrder, getOrderTotal, processPayment) | Split into `OrderService` (2 methods) and `PaymentService` (1 method) | ISP |
| Only CARD and CASH payment types; adding new one required editing the service | GCash added by creating `GCashPayment` + one registry line in factory | OCP |
| No validation abstraction; rules were inlined or left to `@Valid` only | `OrderValidator` interface + `OrderValidatorImpl` (business rules) | SRP |
| No immutable value objects | `ImmutableOrderItem` record with validation on construction | Immutability |

---

## New classes added

- `entity/GCashPayment.java` — third payment implementation (OCP demo)
- `entity/ImmutableOrderItem.java` — Java record for read-only order snapshots
- `service/PaymentProvider.java` — DIP abstraction for payment resolution
- `service/PaymentService.java` — ISP-segregated payment interface
- `service/OrderValidator.java` — SRP interface for input validation
- `service/OrderValidatorImpl.java` — validation implementation
- `service/PaymentServiceImpl.java` — payment processing with injected `PaymentProvider`

---

## Tests

37 total tests, all passing.

New test classes added:
- `OrderValidatorTest` — 6 tests (SRP + edge cases)
- `PaymentServiceImplTest` — 3 tests (DIP proof, LSP, edge case)
- `ImmutableOrderItemTest` — 6 tests (immutability validation)

Updated test classes:
- `OrderServiceTest` — added validator delegation test + zero-total edge case
- `PaymentTest` — added GCash test + LSP test + parameterized test
- `PaymentFactoryTest` — updated to use `PaymentProvider` interface, added GCash + case-insensitive tests

---

## Running the tests

```bash
./mvnw test
```

---

## Project structure

```
bautista/
├── src/main/java/com/bautista/grasp/
│   ├── controller/       OrderController
│   ├── dto/              OrderRequestDTO, OrderResponseDTO, OrderItemDTO
│   ├── entity/           Order, OrderItem, Product, Payment (interface),
│   │                     CardPayment, CashPayment, GCashPayment, ImmutableOrderItem
│   ├── exception/        OrderNotFoundException, ProductNotFoundException,
│   │                     GlobalExceptionHandler, ApiError
│   ├── repository/       OrderRepository, ProductRepository
│   ├── service/          OrderService, PaymentService, PaymentProvider,
│   │                     OrderValidator, OrderServiceImpl, OrderValidatorImpl,
│   │                     PaymentServiceImpl
│   └── util/             PaymentFactory, OrderItemMapper
├── src/test/java/com/bautista/grasp/
│   ├── controller/       OrderControllerTest
│   ├── entity/           ImmutableOrderItemTest
│   ├── service/          OrderServiceTest, PaymentTest, OrderValidatorTest,
│   │                     PaymentServiceImplTest
│   └── util/             PaymentFactoryTest, OrderItemMapperTest
├── refactoring-evidence/
│   ├── before/           BadOrderService.java (demo - shows all 5 violations)
│   ├── before-after-comparison.md
│   ├── red-green-refactor.md
│   ├── solid-analysis.md
│   └── test-results.txt
├── review-and-retrospect.md
├── personal-reflection.md
├── CHANGELOG.md
└── README.md
```
