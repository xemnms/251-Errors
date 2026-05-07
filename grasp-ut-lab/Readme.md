🚀 GRASP + Unit Testing Lab (Spring Boot + Mockito)

---

🎯 Objective

Design and implement a Spring Boot backend system that:

- Applies all 9 GRASP principles
- Uses clean OOP design
- Is fully testable using JUnit and Mockito

---

🧠 Core Challenge

«You are NOT just building features.
You are proving that your design is correct using unit tests.»

---

🧩 System Theme

Create a system that manages one of the following:

- Orders
- Tasks
- Products
- Employees

---

📁 Required Structure

<YourSurname>/
 ├── src/main/java/com/app/
 │    ├── controller/
 │    ├── service/
 │    ├── repository/
 │    ├── entity/
 │    ├── dto/
 │    └── util/
 └── src/test/java/com/app/
      ├── service/
      ├── controller/
      └── util/

---

⚙️ Required Technologies

- Spring Boot
- Spring Data JPA
- PostgreSQL (or H2 for testing)
- JUnit 5
- Mockito

---

🧠 GRASP Principles (MANDATORY)

Your system MUST demonstrate ALL:

1. Information Expert
2. Creator
3. Controller
4. Low Coupling
5. High Cohesion
6. Polymorphism
7. Pure Fabrication
8. Indirection
9. Protected Variations

---

🧩 Implementation Requirements

---

1. Entity (Information Expert)

class Order {
    List<OrderItem> items;

    double calculateTotal() { ... }
}

✔ Logic must be inside the class that owns the data

---

2. Creator

- Entity or Service must create related objects

---

3. Controller (Spring)

@RestController
class OrderController { }

✔ Handles incoming HTTP requests only

---

4. Service (Pure Fabrication)

@Service
class OrderService { }

✔ Contains business logic
✔ Should NOT contain persistence logic

---

5. Repository (Indirection)

interface OrderRepository extends JpaRepository<Order, Long> {}

✔ Acts as a layer between DB and service

---

6. Polymorphism

- Use interfaces:

interface Payment {
    void process();
}

✔ Multiple implementations required

---

7. Protected Variations

- Use interfaces to allow future changes

---

8. Low Coupling

✔ Service depends on interfaces, not implementations

---

9. High Cohesion

✔ Each class has ONE responsibility

---

🧪 Unit Testing Requirements (CRITICAL)

---

🔹 You MUST Write Tests For:

1. Service Layer (REQUIRED)

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    OrderRepository repo;

    @InjectMocks
    OrderService service;

    @Test
    void shouldCreateOrder() {
        // Arrange
        // Act
        // Assert
    }
}

✔ Use Mockito to mock dependencies
✔ No real database calls

---

2. Controller Layer

✔ Mock service
✔ Verify API behavior

---

3. Polymorphism Behavior

✔ Test different implementations

---

4. Edge Cases

- Empty list
- Invalid input
- Null values

---

🔥 GRASP Validation Requirement

Inside your code, you must add comments:

// GRASP: Information Expert - Order calculates its own total

You must clearly identify:

- Where each GRASP principle is applied

---

🔥 Minimum Checklist

- [ ] All 9 GRASP principles implemented
- [ ] Proper layered architecture
- [ ] Interfaces used where needed
- [ ] At least 5 unit tests in service layer
- [ ] Mockito used correctly
- [ ] No direct DB calls in tests
- [ ] Code comments explaining GRASP usage

---

🔥 Bonus Points

- [ ] Use DTO pattern
- [ ] Custom exception handling
- [ ] Integration tests (optional)
- [ ] Multiple polymorphic implementations

---

🔄 Git Workflow

1. Create branch:

grasp-ut-<surname>

2. Commit regularly

3. Push and create PR

4. Get at least 2 approvals

---

🔚 Final Tasks

---

8. Review and Retrospect

Write:

- What GRASP principle was hardest?
- What design mistake did you fix?

---

9. Update Changelog

a. Team changelog

<Name> <ID> <Date> GRASP-UT Completed

b. Personal log

<Date> : I learned _____ and improved _____

c. Peer feedback

<Date> : Comment by <Name> — Strength: _____ Improvement: _____

---

💡 Final Insight

«“Good code is not just working code—it is well-assigned responsibility.”»

---
