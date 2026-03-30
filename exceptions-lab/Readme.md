# Peer Lab Exercise: Errors & Exceptions in OOP (Java 2026)

## Objective

The goal of this lab is to collaboratively design and implement a **Calculator system** that demonstrates:

- OOP principles (Encapsulation, Abstraction, Inheritance, Polymorphism)
- Proper handling of **Errors and Exceptions**
- Use of **custom exceptions**
- **Exception propagation and handling strategies**

This is a **group activity (2–3 members per group)** and enforces a professional Git workflow.

---

## Challenge Goal

By completing this exercise you should demonstrate:

- Proper use of **checked and unchecked exceptions**
- Implementation of **try-catch-finally**
- Use of **throw and throws**
- Creation of **custom exceptions**
- Demonstration of **method overloading**
- Application of **OOP concepts in a Calculator system**
- Professional **Git collaboration workflow**

---

## Group Setup

- Form a group of **2–3 students**
- Each member must contribute to:
  - Class design
  - Exception handling
  - Code review

---

## Scenario

Design and implement a **Calculator system** that supports operations such as:

- Addition
- Subtraction
- Multiplication
- Division

The system must handle **invalid inputs and runtime issues properly using exceptions**.

---

## Tasks

### 1. Create a New Branch (Required)

Create a branch from `main`:

```
exceptions-calc-<group-name>
```

---

### 2. Design the Calculator Class

Create a `Calculator` class with:

- At least **4 methods** (add, subtract, multiply, divide)
- Use **method overloading** (e.g., int vs double)

---

### 3. Implement Exception Handling

Your calculator must handle:

- Division by zero
- Invalid input values
- Negative numbers (if restricted)

Use:

- `try-catch-finally`
- Specific exception types

---

### 4. Create Custom Exceptions

Each group must create at least:

- 1 checked exception (extends Exception)
- 1 unchecked exception (extends RuntimeException)

---

### 5. Use throw and throws

- Use `throw` to manually trigger exceptions
- Use `throws` in method signatures

---

### 6. Demonstrate Exception Propagation

- Let exceptions flow between methods
- Decide where to handle them

---

### 7. Create a Demo Program

Create:

```
CalculatorDemo_<GroupName>.java
```

The program must:

- Call calculator methods
- Trigger multiple exceptions
- Show proper handling
- Print meaningful error messages

---

### 8. Apply OOP Concepts

Your design must demonstrate:

- **Encapsulation**
- **Abstraction**
- **Inheritance**
- **Polymorphism**

---

### 9. Add Code-Based Analysis (Comments)

In your code, answer:

- What exceptions did you create?
- Which are checked vs unchecked?
- Where are exceptions thrown?
- Where are they handled?
- Where does propagation occur?
- How did you apply OOP concepts?

---

### 10. Commit, Push, and Create PR

- Commit your work  
- Push your branch  
- Create a **Pull Request to `main`**

---

### 11. Sync with Main

- Pull latest updates from `main`
- Merge into your branch

---

### 12. Review and Retrospect

Each member must reflect:

- At least **2 improvements**
- Contribution to the group

---

### 13. Update your changelog files

#### a. Team changelog:

```
<Name> <StudentNo/ID> <MM/DD/YYYY> <LabTopic> Completed!
```

#### b. Personal `.md`:

```
<MM/DD/YYYY> : I learned _____ and next time I will _____
```

#### c. Peer feedback:

```
<MM/DD/YYYY> : Comment by: <COMMENTER's name>; You did well in _____ and you can improve by _____
```

---

## Why This Lab Works

This lab forces students to:

- Apply **OOP in a real system (Calculator)**
- Design **exception handling properly**
- Work collaboratively using **Git**
- Think beyond syntax → **system design**

---
