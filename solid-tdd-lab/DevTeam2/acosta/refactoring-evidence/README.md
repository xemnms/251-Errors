---

## Retrospect

### Which principle improved your design the most?
**DIP (Dependency Inversion Principle).** Depending on interfaces instead
of concrete classes fixed real build errors — Mockito on Java 25 cannot
mock concrete classes, so every time we converted a class to an interface
the tests became cleaner and the design became genuinely more flexible.

### What bad design did you remove?
- Validation logic mixed inside `OrderService` (SRP violation)
- Only one hardwired payment processor with no selection logic
  (OCP violation)
- Fully mutable `OrderItem` with public setters on all fields
  (Immutability violation)
- Generic `RuntimeException` thrown for missing orders
  (poor error handling)

### Which principle was hardest to apply?
**ISP (Interface Segregation Principle)** was the hardest to demonstrate
because the original project's interfaces were already small. It required
careful thought about what each interface should and should not include,
rather than fixing an obvious violation.



# SOLID + OOP Refactoring Lab — Acosta

## Project Overview
This project refactors the previous GRASP + Unit Testing Spring Boot
order management system using SOLID principles, OOP best practices,
and Test-Driven Development (TDD).

---

## What Was Refactored

### ✅ SRP — Single Responsibility Principle

**BEFORE:** `OrderService` was doing four things in one class:
- Input validation
- Building Order objects
- Processing payment
- Saving to the database

**AFTER:** Validation was extracted into its own `OrderValidator` interface
and `OrderValidatorImpl` class. `OrderService` now only orchestrates —
it delegates validation, payment, and persistence to separate components.

**Files changed:** `OrderService.java`, added `OrderValidator.java`,
`OrderValidatorImpl.java`

---

### ✅ OCP — Open-Closed Principle

**BEFORE:** Only `CashPaymentProcessor` existed. Adding a new payment
type would require modifying `OrderService` directly — it was hardwired
by Spring to inject whichever single `PaymentProcessor` bean it found.

**AFTER:** A `PaymentProcessorFactory` interface and
`PaymentProcessorFactoryImpl` were added. `OrderService` now asks the
factory for the right processor based on `request.getPaymentMethod()`.
Adding a new payment type (e.g. CardPayment) only requires adding a new
class and one new case in the factory — `OrderService` is never touched.

**Files added:** `GCashPaymentProcessor.java`,
`PaymentProcessorFactory.java`, `PaymentProcessorFactoryImpl.java`

---

### ✅ LSP — Liskov Substitution Principle

**EVIDENCE:** Both `CashPaymentProcessor` and `GCashPaymentProcessor`
fully implement the `PaymentProcessor` interface. Either can be swapped
in without breaking the system. Proven in `PaymentProcessorTest` —
Test 3 runs both processors through the same assertions and both pass.

---

### ✅ ISP — Interface Segregation Principle

**EVIDENCE:** All interfaces are small and focused:
- `PaymentProcessor` — one method: `process(Order)`
- `OrderValidator` — one method: `validate(OrderRequest)`
- `PaymentProcessorFactory` — one method: `getProcessor(String)`

No class is forced to implement methods it does not need.

---

### ✅ DIP — Dependency Inversion Principle

**BEFORE:** Spring injected a single concrete `PaymentProcessor` bean
directly. `PaymentProcessorFactory` was a concrete class that Mockito
could not mock on Java 25.

**AFTER:** `OrderService` depends only on interfaces:
- `OrderValidator` (not `OrderValidatorImpl`)
- `PaymentProcessorFactory` (not `PaymentProcessorFactoryImpl`)
- `OrderRepository` (already an interface from GRASP project)

All concrete implementations are injected by Spring — `OrderService`
never calls `new ConcreteClass()` anywhere.

---

### ✅ Immutability — OOP Best Practice

**BEFORE:** `OrderItem` had public setters for all fields. Price,
quantity, and product name could be changed at any point after creation.

**AFTER:** `productName`, `price`, and `quantity` are now `final`.
The public setters for these fields were removed. Validation was added
to the constructor — null names and negative prices now throw
`IllegalArgumentException` immediately. JPA still works via a
`protected` no-arg constructor.

**File changed:** `OrderItem.java`

---

### ✅ Custom Exception — Bonus Point

**BEFORE:** `OrderService` threw a generic `RuntimeException` when an
order was not found — vague and unhelpful.

**AFTER:** A dedicated `OrderNotFoundException` was created in a new
`exception` package. It stores the missing order ID and produces a
clear message. All three places in `OrderService` that threw
`RuntimeException` now throw `OrderNotFoundException` instead.

**File added:** `exception/OrderNotFoundException.java`

---

### ✅ Already Good Design (from GRASP project)

| Area | Principle | Reason |
|---|---|---|
| `OrderRepository` | DIP | Already an interface, never a concrete class |
| `OrderController` | SRP | Only handles HTTP, delegates everything to service |
| `OrderRequest` / `OrderResponse` | SRP | DTOs separate from entities |
| `Order.calculateTotal()` | Information Expert | Logic lives where data lives |
| Constructor injection everywhere | DIP | No `new ConcreteClass()` in any class |

---

## Test Summary

| Test Class | Tests | What It Proves |
|---|---|---|
| `OrderValidatorTest` | 5 | SRP — validation logic works in isolation |
| `OrderServiceTest` | 8 | Service orchestration, mocked dependencies |
| `PaymentProcessorTest` | 6 | OCP, LSP — both processors satisfy the contract |
| `OrderItemImmutabilityTest` | 6 | Immutability — state locked at construction |
| `OrderNotFoundExceptionTest` | 3 | Custom exception, clear error messages |
| **Total** | **28** | |

---

## Project Structure

```text