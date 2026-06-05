# SOLID + OOP Summary

| Principle | Where |
|-----------|-------|
| SRP | `OrderValidatorImpl` (validation only), `PaymentServiceImpl` (payment only), `OrderServiceImpl` (order lifecycle only) |
| OCP | `GCashPayment` added without touching `CardPayment`, `CashPayment`, or `PaymentFactory` logic |
| LSP | `CardPayment`, `CashPayment`, `GCashPayment` all substitutable — proven in `PaymentTest` parameterized test |
| ISP | `OrderService` (no payment), `PaymentService` (no order), `OrderValidator` (no business logic) |
| DIP | `PaymentServiceImpl` depends on `PaymentProvider`; `PaymentFactory` is injected by Spring, mock injected in tests |
| DRY | Mapping in `OrderItemMapper`, type resolution in `PaymentFactory` registry, subtotal in `ImmutableOrderItem.calculateSubtotal()` |
| Immutability | `ImmutableOrderItem` record — final fields, no setters, validated at construction |
| Composition | `PaymentServiceImpl` has-a `PaymentProvider`, doesn't extend it |

Already good before refactoring: `OrderController` (pure controller, no business logic), `Payment` interface, repository layer, constructor injection throughout.
