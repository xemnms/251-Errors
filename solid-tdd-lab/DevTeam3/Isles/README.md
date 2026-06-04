# SOLID + OOP Best Practices Unit Testing Lab

This project reuses the previous GRASP + Unit Testing Spring Boot order system and refactors it in place for SOLID, OOP best practices, maintainability, and testability.

## Refactored Design

- **SRP:** `OrderService` coordinates order creation only. Validation is handled by `OrderValidator`, persistence by `OrderRepository`, and payment routing by `PaymentGateway`.
- **OCP:** Payment methods are extended by adding a new `Payment` implementation such as `GCashPayment`; `PaymentProcessor` does not need new `if-else` branches.
- **LSP:** `CreditCardPayment`, `PayPalPayment`, and `GCashPayment` can all be used through the `Payment` abstraction without changing caller behavior.
- **ISP:** `PaymentGateway` exposes only payment processing, and `OrderValidation` exposes only validation.
- **DIP:** `OrderService` depends on `PaymentGateway` and `OrderValidation` abstractions. `PaymentProcessor` depends on `List<Payment>`, not specific payment classes.

## OOP Best Practices

- **DRY:** Shared validation helper methods avoid repeated blank-string checks.
- **KISS:** Payment routing uses a simple map lookup instead of long conditional chains.
- **YAGNI:** The design keeps only required order, validation, payment, DTO, and exception behavior.
- **Composition Over Inheritance:** `Order` owns `OrderItem` objects through a has-a relationship.
- **Immutability:** Response DTOs use Java records, `OrderResponse` defensively copies item lists, and `Order#getItems()` returns an unmodifiable view.

## Tests

The test suite includes service-layer tests, repository mocks, interaction verification, polymorphism tests, immutability tests, controller tests, and edge cases for null values, empty collections, invalid input, unsupported payment methods, and missing records.

Run tests with:

```powershell
.\mvnw.cmd test
```

If the Maven wrapper cannot run in the lab environment, use IntelliJ IDEA's Maven test runner or install Java and Maven on PATH.

## Refactoring Evidence

See `refactoring-evidence/` for before/after examples, TDD cycle notes, and test execution notes.

## Review and Retrospect

**Which principle improved the design the most?** DIP improved the design the most because services now depend on abstractions, making payment and validation behavior easy to mock and replace.

**What bad design was removed?** The hardcoded payment implementation wiring in `PaymentProcessor` was removed. The processor now receives all `Payment` implementations through dependency injection.

**Which principle was hardest to apply?** OCP was the hardest because it required changing the payment contract so new payment methods can be added without modifying core routing logic.

## Submission Notes

Required Git branch name:

```text
solid-refactor-ut-<surname>
```

This environment currently does not expose `git`, so branch creation and commits must be completed in a terminal where Git is installed.
