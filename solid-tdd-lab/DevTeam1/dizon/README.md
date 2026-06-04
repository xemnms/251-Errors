# SOLID + OOP Best Practices Unit Testing Lab — Vic Andrew A. Dizon

**Branch:** `solid-refactor-ut-dizon`
**Project:** Order Management System (refactor of my previous GRASP + Unit Testing lab)
**Package:** `com.dizon.app`

> This is **not** a new project. It is the SOLID refactor of my existing
> [GRASP + Unit Testing lab](../../../grasp-ut-lab/DevTeam1/dizon). Same domain
> (orders, items, payments), redesigned for SOLID principles, OOP best practices and testability.

---

## ▶️ How to run

```bash
mvn test        # runs all 46 unit tests
mvn spring-boot:run   # starts the API on http://localhost:8080
```

**Result:** `Tests run: 46, Failures: 0, Errors: 0` — `BUILD SUCCESS`.

---

## 🧩 SOLID Principles — where each one lives

| Principle | Where | BEFORE → AFTER |
|-----------|-------|----------------|
| **SRP** | `OrderValidatorImpl`, `OrderMapperImpl`, `OrderService` | `OrderService` did business logic **+** validation **+** mapping. Split into three classes, each with one reason to change. |
| **OCP** | `PaymentService` + `payment/*` | Routing a payment no longer needs an `if/else` chain. A new payment type = one new `@Component`; `PaymentService` never changes. |
| **LSP** | `CashPaymentProcessor`, `CreditCardPaymentProcessor` | Both fully honour `PaymentProcessor` and are substitutable. Proven in parameterized tests. |
| **ISP** | `OrderValidator`, `OrderMapper` | Two tiny single-method interfaces. No class implements methods it doesn't use. |
| **DIP** | `OrderService` constructor | Depends only on the `OrderRepository`, `OrderValidator`, `OrderMapper` **interfaces**. Proven by unit-testing it with all three mocked. |

## 🧠 OOP Best Practices — where each one lives

| Practice | Where |
|----------|-------|
| **DRY** | `OrderService.findOrderOrThrow()` (the "find or 404" rule, previously duplicated 3×); `PriceFormatter.round()`; `OrderValidatorImpl.requireText()` |
| **KISS** | `PriceFormatter` is a 1-line rounding helper; null item lists are normalised once in `OrderRequest` so nothing downstream null-checks |
| **YAGNI** | Did **not** add currency/locale formatting to `PriceFormatter` — nothing needs it yet (documented in code) |
| **Composition over inheritance** | `Order` HAS-A `List<OrderItem>`; `OrderService` and `PaymentService` are *composed of* injected collaborators, not subclasses |
| **Immutability** | `OrderRequest`, `OrderItemRequest`, `OrderResponse` are immutable **records** with defensive list copies |

---

## 🔍 Refactoring demonstrations (BEFORE → AFTER)

### 1. SRP — `OrderService` was doing three jobs
**BEFORE:** validation was inline `if` checks, and `toResponse()` mapping was a private method, all inside `OrderService`.
**AFTER:** `OrderValidatorImpl` owns validation, `OrderMapperImpl` owns mapping, `OrderService` only orchestrates.
Full side-by-side: [`refactoring-evidence/`](./refactoring-evidence).

### 2. DIP — concrete logic → injected abstractions
**BEFORE:** validation and mapping were hardcoded inside the service — impossible to swap or mock.
**AFTER:** `OrderService` receives `OrderValidator` and `OrderMapper` interfaces. `OrderServiceTest` mocks **all** collaborators — that mockability *is* the proof DIP works.

### 3. OCP — `if/else` payment routing → polymorphic registry
**BEFORE (typical):** `if (type.equals("CASH")) … else if (type.equals("CREDIT_CARD")) …`
**AFTER:** `PaymentService` builds a `Map<type, PaymentProcessor>` from every injected processor. `PaymentServiceTest` adds a brand-new `GCASH` processor and it works with **zero** changes to `PaymentService`.

### 4. Composition over inheritance
**AFTER:** behaviour is assembled by composing `OrderRepository` + `OrderValidator` + `OrderMapper` inside `OrderService`, and `List<OrderItem>` inside `Order` — no inheritance hierarchy.

### 5. Immutability
**BEFORE:** DTOs were mutable classes with public setters; `OrderResponse.items` was set *after* construction.
**AFTER:** all DTOs are records, built in one shot, with `List.copyOf` defensive copies. `ImmutabilityTest` proves later mutations to the source list don't leak in and the lists are unmodifiable.

---

## ✅ What was already good (kept and documented)

| Area | Principle already followed | Why it's good design |
|------|---------------------------|----------------------|
| `OrderController` | SRP | Thin HTTP adapter — no logic, just delegates to the service |
| `Order.calculateTotal()` | Information Expert | The total is computed where the item data lives |
| `OrderItem.getSubtotal()` | Information Expert | `price × quantity` computed by the class that owns those fields |
| `OrderRepository` | DIP | Already a `JpaRepository` interface; the service never sees a concrete DB class |
| `GlobalExceptionHandler` | SRP | Only maps exceptions → HTTP status |
| `PaymentProcessor` interface | OCP + Polymorphism | New payment types added without touching existing code |

These areas were left unchanged on purpose and carry `GOOD DESIGN PRESERVED` comments in the source.

---

## 🧪 Test coverage (46 tests, all passing)

| Test class | Tests | Category |
|------------|-------|----------|
| `OrderServiceTest` | 10 | Service layer + **DIP proof** (mocked interfaces) + edge cases |
| `OrderValidatorTest` | 11 | Validation + edge cases + **parameterized** |
| `PriceFormatterTest` | 5 | Utility + **parameterized** |
| `ImmutabilityTest` | 5 | **Immutability validation** |
| `PaymentProcessorTest` | 5 | **Polymorphism + LSP** + **parameterized** |
| `OrderControllerTest` | 4 | Web layer (`@WebMvcTest`, mocked service) |
| `PaymentServiceTest` | 3 | **OCP proof** + edge case |
| `OrderMapperTest` | 2 | Mapping / Information Expert preserved |
| `DizonApplicationTests` | 1 | Full-context integration smoke test (**bonus**) |

**Required coverage met:** service tests (mock repo + verify interactions), DIP (mock interfaces), polymorphism (multiple impls), immutability, and edge cases (null, empty, invalid input, missing records).

**Bonus delivered:** parameterized tests, an integration test, the DTO pattern, and custom exception handling (`OrderNotFoundException` → 404, `InvalidOrderException` → 400).

---

## 📁 Structure

```
solid-tdd-lab/DevTeam1/dizon/
├── pom.xml
├── README.md
├── refactoring-evidence/          before/after code, RGB cycle notes, screenshots*
└── src/
    ├── main/java/com/dizon/app/
    │   ├── controller/   OrderController, GlobalExceptionHandler
    │   ├── dto/          OrderRequest, OrderItemRequest, OrderResponse  (immutable records)
    │   ├── entity/       Order, OrderItem, OrderStatus
    │   ├── exception/    OrderNotFoundException, InvalidOrderException
    │   ├── mapper/       OrderMapper (interface), OrderMapperImpl
    │   ├── payment/      PaymentProcessor, Cash/CreditCard impls, PaymentService
    │   ├── repository/   OrderRepository
    │   ├── service/      OrderService          (refactored — orchestration only)
    │   ├── util/         PriceFormatter
    │   └── validator/    OrderValidator (interface), OrderValidatorImpl
    └── test/java/com/dizon/app/   (9 test classes, 46 tests)
```
`*` Screenshots and the screen recording are added by me separately.

---

## 8. Review and Retrospect

**Which principle improved my design the most?**
SRP. Pulling validation and mapping out of `OrderService` shrank it to pure orchestration and made every collaborator independently testable — which is what unlocked the clean DIP unit tests.

**What bad design did I remove?**
- Mutable DTOs with public setters → immutable records with defensive copies
- Inline validation tangled into business logic → `OrderValidator`
- `toResponse()` mapping hardcoded inside the service → `OrderMapper`
- Duplicated `findById + orElseThrow` in 3 methods → one `findOrderOrThrow` helper
- A latent `if/else` payment-routing smell → polymorphic `PaymentService` registry

**Which principle was hardest to apply?**
DIP. Introducing `OrderValidator` and `OrderMapper` interfaces felt like extra layers at first. It clicked once I saw the payoff in `OrderServiceTest`: because the service depends only on abstractions, I can mock every collaborator and test its logic in complete isolation with no database and no real validator/mapper.
