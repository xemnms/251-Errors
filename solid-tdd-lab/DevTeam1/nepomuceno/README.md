# SOLID + OOP Refactoring Lab — Nepomuceno

## Branch
`solid-refactor-ut-nepomuceno`

---

## What Was Refactored

### 1. SRP — OrderService was doing too much (BEFORE → AFTER)

**BEFORE:** `OrderService` handled three separate concerns in one class:
- Business logic (creating, retrieving, deleting orders)
- Input validation (inline `if` checks inside `createOrder`)
- Response mapping (private `toResponse()` method)

**AFTER:** Each concern is in its own class:
- `OrderService` — business logic only
- `OrderValidatorImpl` — all validation rules
- `OrderMapperImpl` — all entity-to-DTO mapping

---

### 2. DIP — OrderService now depends on abstractions

**BEFORE:** Mapping and validation logic were hardcoded inside `OrderService` with no way to swap them.

**AFTER:** Two new interfaces were introduced:
- `OrderValidator` — injected into `OrderService`; `OrderValidatorImpl` provides the implementation
- `OrderMapper` — injected into `OrderService`; `OrderMapperImpl` provides the implementation

`OrderService` only ever references the interfaces, never the concrete classes.

---

### 3. ISP — Small focused interfaces

Both `OrderValidator` and `OrderMapper` are small, single-purpose interfaces. No class is forced to implement methods it does not use.

---

### 4. OCP — Payment system (already good, preserved)

The `Payment` interface + `CashPayment` / `CreditCardPayment` already followed OCP. A new payment type can be added by creating a new class — zero changes to `OrderService` or any existing class.

This principle was already correctly applied. It has been preserved and documented with comments.

---

### 5. LSP — Both payment implementations are substitutable

`CashPayment` and `CreditCardPayment` both fully implement `Payment`. Either can be used wherever a `Payment` is expected without breaking behaviour. Verified in polymorphism tests.

---

### 6. OOP: Immutability — DTOs are now immutable

**BEFORE:** `ItemDto`, `OrderRequest`, `OrderResponse` all had mutable fields with public setters.

**AFTER:** All fields are `final`. Setters have been removed. `OrderRequest` returns an unmodifiable list view. Immutability is validated in unit tests.

---

### 7. OOP: YAGNI — Removed unused `formatUSD` from PriceFormatter

`PriceFormatter.formatUSD()` was never called anywhere in the codebase. It was removed. If USD support is genuinely needed in the future, it can be added at that time.

---

### 8. DRY — Shared `findOrderOrThrow` helper in OrderService

`getOrder`, `processPayment` all needed `findById + orElseThrow`. This was extracted into a private `findOrderOrThrow(Long id)` method, called in all three places.

---

## What Was Already Good (No Changes Made)

| Area | Principle Already Followed |
|------|---------------------------|
| `OrderController` | SRP — pure HTTP layer, no business logic |
| `Order.calculateTotal()` | Information Expert — logic lives where the data lives |
| `OrderItem.getSubtotal()` | Information Expert — subtotal calculated by the class that owns price × quantity |
| `OrderRepository` | DIP — service uses the `JpaRepository` interface, never a concrete DB class |
| `GlobalExceptionHandler` | SRP — handles only exception-to-HTTP mapping |
| `Payment` interface | OCP + Polymorphism — new types added without modifying existing code |
| `PriceFormatter` | Pure Fabrication + DRY — single place for all price formatting |

---

## New File Structure

```
src/main/java/com/nepomuceno/app/
├── controller/       OrderController.java         (unchanged)
├── dto/              ItemDto, OrderRequest, OrderResponse (now immutable)
├── entity/           Order.java, OrderItem.java    (unchanged)
├── mapper/           OrderMapper.java (interface), OrderMapperImpl.java
├── repository/       OrderRepository.java          (unchanged)
├── service/          OrderService.java (refactored), Payment.java,
│                     CashPayment.java, CreditCardPayment.java
├── util/             PriceFormatter.java (YAGNI: removed formatUSD),
│                     GlobalExceptionHandler.java
└── validator/        OrderValidator.java (interface), OrderValidatorImpl.java

src/test/java/com/nepomuceno/app/
└── OrderServiceTest.java  (22 unit tests)
```

---

## Test Coverage Summary

| Category | Tests |
|----------|-------|
| Service layer (mock repo) | 4 |
| DIP proof (mock interfaces) | 2 |
| Polymorphism (both Payment impls) | 3 |
| Immutability validation | 3 |
| Edge cases (null, empty, missing) | 4 |
| Validator unit tests | 4 |
| Parameterized test (bonus) | 1 |
| Mapper unit tests | 1 |
| Domain / Information Expert | 3 |
| PriceFormatter | 1 |
| **Total** | **26** |

---

## Retrospective

**Which principle improved the design the most?**
SRP. Splitting validation and mapping out of `OrderService` made the class significantly shorter and gave each class a single, clear reason to change.

**What bad design was removed?**
- Mutable DTOs with public setters
- Inline validation mixed into business logic
- Unused `formatUSD` method (YAGNI violation)
- `toResponse()` mapping logic hardcoded inside the service

**Which principle was hardest to apply?**
DIP. It required introducing two new interfaces (`OrderMapper`, `OrderValidator`) that felt unnecessary at first glance. Understanding that the purpose is to make things *mockable and swappable* — not just to add layers — made it click.

---

## Changelog

```
Nepomuceno <ID> <Date> SOLID-UT Completed
```

## Personal Reflection

```
<Date>: I learned that SRP is about reasons to change, not just "one method per class",
        and improved my understanding of DIP by introducing mapper and validator abstractions
        that made unit testing significantly easier.
```
