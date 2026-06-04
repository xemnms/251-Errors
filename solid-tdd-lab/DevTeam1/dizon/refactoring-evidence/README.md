# Refactoring Evidence — Vic Andrew A. Dizon

This folder documents the SOLID refactor of my GRASP project.

```
refactoring-evidence/
├── before/      OrderService_BEFORE.java   (the God-ish service from the GRASP lab)
├── after/       OrderService_AFTER.java     (slim, orchestration-only service)
├── before/      DTO_BEFORE.java             (mutable DTO with setters)
├── after/       DTO_AFTER.java              (immutable record)
├── test-results/   <-- I add the `mvn test` screenshot here
└── screenshots/    <-- I add IDE/Red-Green-Blue screenshots + recording here
```

> The `before/` snapshots are copied from `grasp-ut-lab/DevTeam1/dizon`. The `after/`
> snapshots are the live files in `src/main/java/com/dizon/app`.

---

## 🔴🟢🔵 Red–Green–Blue (TDD Refactor) Cycle

I drove each refactor with the TDD cycle. Example for extracting the **`OrderValidator`** (SRP + DIP):

### 🔴 RED — write a failing test first
`OrderServiceTest.shouldNotSave_whenValidatorRejectsRequest()` mocks an `OrderValidator`
interface **that did not exist yet** and asserts the repository is never called when validation
fails. → Does not compile / fails. This *forces* the abstraction into existence.

```java
@Mock private OrderValidator orderValidator;   // interface doesn't exist yet → RED
...
doThrow(new InvalidOrderException("...")).when(orderValidator).validate(request);
assertThrows(InvalidOrderException.class, () -> orderService.createOrder(request));
verify(orderRepository, never()).save(any());
```

### 🟢 GREEN — write the minimum code to pass
1. Create the `OrderValidator` interface and `OrderValidatorImpl`.
2. Inject `OrderValidator` into `OrderService` and call `validate()` before saving.
3. Move the old inline `if (customerName == null …)` checks out of the service into the impl.
→ `mvn test` is now **green** (46/46 passing).

### 🔵 BLUE (REFACTOR) — clean it up with tests green
- Extracted the duplicated `findById + orElseThrow` into `findOrderOrThrow()` (DRY).
- Extracted the `toResponse()` mapping into `OrderMapper`/`OrderMapperImpl` (SRP).
- Extracted the repeated "required text" rule into `requireText()` inside the validator (DRY).
- Replaced the latent payment `if/else` with the polymorphic `PaymentService` registry (OCP).
The tests stayed green throughout — that is what made the refactor safe.

---

## Summary of BEFORE → AFTER

| # | Smell (BEFORE) | Fix (AFTER) | Principle |
|---|----------------|-------------|-----------|
| 1 | `OrderService` did logic + validation + mapping | Split into 3 classes | SRP |
| 2 | Validation/mapping hardcoded, un-mockable | Injected `OrderValidator` / `OrderMapper` interfaces | DIP |
| 3 | (Latent) `if/else` payment routing | `PaymentService` map of processors | OCP |
| 4 | Mutable DTOs with setters | Immutable records + defensive copies | Immutability |
| 5 | `findById + orElseThrow` duplicated ×3 | One `findOrderOrThrow()` | DRY |
