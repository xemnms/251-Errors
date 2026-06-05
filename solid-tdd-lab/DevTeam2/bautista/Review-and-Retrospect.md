# Review and Retrospect - SOLID + Unit Testing Lab

Bautista
Date: 2026-06-05

---

## Which principle improved your design the most?

DIP — Dependency Inversion Principle. Before, `OrderServiceImpl` was calling `PaymentFactory.getPayment()` as a static method. That one detail made it impossible to test the payment flow in isolation because you can't swap a static call for a mock. Converting `PaymentFactory` into a `@Component` that implements the `PaymentProvider` interface meant I could inject a mock in any test and the service class never needed to know what concrete class was behind it. That single change made the entire payment layer testable and replaceable.

It also felt like the principle that forced everything else to fall into place. Once you start thinking in terms of "depend on the interface, not the class," the need for ISP (small interfaces) and SRP (classes that only do one thing) becomes obvious on its own.

---

## What bad design did you remove?

1. **Payment processing inside OrderServiceImpl** — `processPayment()` had no business being in the order management service. It was doing a completely different job. Moved it to `PaymentServiceImpl` which is solely responsible for payment concerns.

2. **Static factory dependency** — `PaymentFactory.getPayment()` was a static call inside the service. Static dependencies are basically hardcoded concrete classes that cannot be tested. Converted to an injectable `PaymentProvider` interface.

3. **Fat OrderService interface** — The interface had `createOrder`, `getOrderTotal`, and `processPayment` all in one. That means any class implementing `OrderService` had to think about payment too, even if it only needed order retrieval. Split into `OrderService` (order only) and `PaymentService` (payment only).

4. **Validation inlined into the service** — Input validation was something the service was doing on the side. Extracted to `OrderValidatorImpl` with its own interface. Now the service just calls `orderValidator.validate(request)` and doesn't care about what the rules are.

5. **Only two payment types with no OCP story** — There was no third implementation to prove the system was extensible. Adding `GCashPayment` required writing the class and adding one line to the `PaymentFactory` registry. Nothing else changed, which is exactly what OCP promises.

---

## Which principle was hardest to apply?

ISP — Interface Segregation Principle. In a project this size, interfaces don't naturally feel too fat. Three methods on `OrderService` doesn't sound like much. The challenge was that the violation was subtle — `processPayment` doesn't feel out of place until you ask the question: "why would a class that only needs to read order totals also need to implement a payment method?" That question took a while to surface.

With SRP and DIP, the problems show up as pain points in testing. Static dependencies and bloated classes are hard to mock. ISP violations are more conceptual — the code works fine, but the design is quietly wrong. Making the decision to split the interface felt arbitrary at first, but once `OrderServiceImpl` stopped carrying payment logic and `PaymentServiceImpl` existed on its own, the two classes became noticeably cleaner and independently maintainable.

---

## SOLID Usage Explanation

| Principle | Applied In |
|-----------|-----------|
| SRP | `OrderValidatorImpl` (validation only), `PaymentServiceImpl` (payment only), `OrderServiceImpl` (order lifecycle only) |
| OCP | `PaymentFactory` registry — `GCashPayment` added without touching any existing class |
| LSP | `CardPayment`, `CashPayment`, `GCashPayment` — all substitutable via `Payment` interface; proven in parameterized tests |
| ISP | `OrderService` (no payment), `PaymentService` (no order), `OrderValidator` (no business logic) |
| DIP | `PaymentServiceImpl` depends on `PaymentProvider` interface; Spring injects `PaymentFactory`; tests inject mocks |

---

## Refactoring Decisions Explained

**Why extract to `OrderValidatorImpl` instead of keeping `@Valid`?**
Spring's `@Valid` handles HTTP-layer Bean Validation. The `OrderValidator` handles business-layer rules (like quantity > 0) that are not tied to the web layer. Both serve different purposes and should coexist.

**Why make `PaymentFactory` a `@Component`?**
A static utility class can't be injected, which means it can't be swapped in tests. Making it a Spring-managed component and having it implement `PaymentProvider` costs nothing in terms of complexity but unlocks full testability and replaceability.

**Why use a Java record for `ImmutableOrderItem`?**
Records are the cleanest immutability tool in Java. All fields are `final`, no setters are generated, and validation can be added in the compact constructor. It communicates intent clearly — this object exists to carry data, not to be mutated.
