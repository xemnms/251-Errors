# 🚀 SOLID + OOP Best Practices Unit Testing Lab
## Reusing the Previous GRASP + Unit Testing Spring Boot Project

---

# 🎯 Objective

Enhance your previous **GRASP + Unit Testing Spring Boot project** by refactoring and improving the design using:

- SOLID Principles
- OOP Best Practices
- Better architecture and maintainability
- Unit Testing using Mockito and JUnit

---

# 🧠 Main Goal

> You are NOT creating a new project.

You are:
- Improving an existing project
- Refactoring bad design
- Making the system easier to maintain and test

---

# 📦 Reuse Your Previous Project

Use your completed:

GRASP + Unit Testing Lab Project

You must:
- Refactor existing code
- Improve design quality
- Add missing principles
- Improve testability

---

# 🧩 Required Principles (MANDATORY)

Your updated system must demonstrate:

## SOLID Principles

- Single Responsibility Principle (SRP)
- Open-Closed Principle (OCP)
- Liskov Substitution Principle (LSP)
- Interface Segregation Principle (ISP)
- Dependency Inversion Principle (DIP)

## OOP Best Practices

- DRY (Don’t Repeat Yourself)
- KISS (Keep It Simple)
- YAGNI (You Aren’t Gonna Need It)
- Composition Over Inheritance
- Immutability (where appropriate)

---

# 🧠 Refactoring Requirement (IMPORTANT)

You MUST identify and improve:

- Tight coupling
- Large “God classes”
- Duplicate logic
- Hardcoded implementations
- Poor inheritance usage
- Fat interfaces

⚠️ IMPORTANT:
If bad design is NOT present in a certain area of your project,
you MUST:
- Mention where the good design already exists
- Explain which principle is already being followed
- Explain why the implementation is considered good design

---

# 🧪 Unit Testing Requirement (CRITICAL)

You must PROVE your implementation using:

- JUnit 5
- Mockito
- Test-Driven Development(TDD)
---

# 🔥 Required Test Coverage

## 1️⃣ Service Layer Tests

You MUST:
- Mock repositories
- Test business logic
- Verify interactions

Example:

```java
@Mock
OrderRepository repo;

@InjectMocks
OrderService service;
```

---

## 2️⃣ Dependency Inversion Proof

You must:
- Mock interfaces
- Avoid testing concrete implementations directly

---

## 3️⃣ Polymorphism Tests

You must test multiple implementations.

Example:

```java
Payment gcash = new GCashPayment();
Payment card = new CardPayment();
```

Verify:
- Both behave correctly
- System works without changing core logic

---

## 4️⃣ Immutability Validation

Test that immutable objects:
- Cannot be modified
- Preserve consistent state

---

## 5️⃣ Edge Case Testing

You MUST test:
- Null values
- Empty collections
- Invalid input
- Missing records

---

# 🧩 Required Refactoring Demonstrations

You must include BEFORE and AFTER examples.

## Example Areas

### SRP

❌ One class doing:
- Validation
- Persistence
- Email sending

✅ Separate services

---

### OCP

❌ Long if-else chains

✅ Interface-based polymorphism

---

### DIP

❌ Concrete dependency creation

```java
new MySQLDatabase()
```

✅ Dependency injection

---

### Composition Over Inheritance

❌ Incorrect inheritance hierarchy

✅ Proper HAS-A relationship

---

# 🧠 Required Comments in Code

Inside your code add comments like:

```java
// SOLID: SRP - Handles only report generation

// DIP: Depends on abstraction instead of implementation

// DRY: Shared reusable validation method
```

---

# 📁 Required Project Structure

```text
<YourSurname>/
 ├── src/main/java/
 ├── src/test/java/
 ├── refactoring-evidence/
 └── README.md
```

---

# 📸 Refactoring Evidence Folder

Inside:

```text
/refactoring-evidence/
```

Add:
- Screenshots
- Before vs After code
- Test results
- Record Red-Green-Blue(Refactor) Cycle testing

---

# 🎥 Screen Recording Requirement

Record a demonstration showing:

- Refactored system
- Test-Driven Development Cycle
- Passing unit tests
- Explanation of SOLID usage
- Explanation of refactoring decisions

---

# 🔥 Minimum Checklist

- [ ] Existing project reused
- [ ] SOLID principles implemented
- [ ] OOP best practices implemented
- [ ] Mockito used correctly
- [ ] At least 10 meaningful unit tests
- [ ] Edge cases tested
- [ ] Refactoring evidence added
- [ ] Screen recording added

---

# 🔥 Bonus Points

- [ ] Parameterized tests
- [ ] Integration tests
- [ ] DTO pattern
- [ ] Custom exception handling
- [ ] Better package organization

---

# 🔄 Git Workflow

## Branch Name

```text
solid-refactor-ut-<surname>
```

## Steps

1. Pull latest main
2. Create branch
3. Commit regularly
4. Push branch
5. Create PR to main

---

# 🔚 Final Tasks (ALWAYS INCLUDE)

## 8. Review and Retrospect

Answer:
- Which principle improved your design the most?
- What bad design did you remove?
- Which principle was hardest to apply?

---

## 9. Update Changelog Files

### a. Team changelog

```text
<Name> <ID> <Date> SOLID-UT Completed
```

### b. Personal reflection

```text
<Date> : I learned _____ and improved _____
```

### c. Peer feedback

```text
<Date> : Comment by <Name>; Strength: _____ Improvement: _____
```

---

# 💡 Final Insight

> “Good software is not measured only by working features, but by how safely and easily it can evolve.”
