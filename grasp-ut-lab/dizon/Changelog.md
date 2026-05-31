# Changelog — Vic Andrew A. Dizon

---

## Team Changelog

| Name | ID | Date | Status |
|------|----|------|--------|
| Vic Andrew A. Dizon | dizonva | 2026-05-31 | GRASP-UT Completed |

---

## Personal Log

- **2026-05-31**: I learned how to properly apply the GRASP principles — especially the difference between Pure Fabrication (the Service class) and Indirection (the Repository) — and improved my ability to write meaningful Mockito unit tests that verify behavior without hitting a real database.

---

## Peer Feedback

- **2026-05-31**: [Pending — awaiting peer review]

---

## Review and Retrospect

### What GRASP Principle Was Hardest?

**Protected Variations** was the most challenging. It required thinking ahead about what parts of the system are likely to change (payment methods, error handling strategies) and wrapping them behind interfaces *before* those changes happen. Unlike the other principles which describe how to assign responsibility to what already exists, Protected Variations forces you to design for uncertainty — which is difficult without experience.

### What Design Mistake Did I Fix?

My initial approach placed the `calculateTotal()` logic inside `OrderService`. I corrected this by moving it into the `Order` entity itself, which properly follows the **Information Expert** principle — the class that owns the data (`items` list) should be the one that knows how to calculate the total from it. The service now simply calls `order.calculateTotal()` and delegates correctly.

---
