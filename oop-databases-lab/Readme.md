# 🚀 Lab Exercise: CRUD API with H2 → PostgreSQL (Spring Boot + JPA)

---

# 🎯 Objective

Upgrade your existing Spring Boot application into a **fully functional CRUD API** that:

- Uses **Spring Data JPA**
- Persists data using **H2 (development)**
- Migrates to **PostgreSQL (real-world database)**

---

# 🧠 Context (IMPORTANT)

In the previous lab, you:
- Created a Spring Boot app  
- Built a basic GET API  
- Used **hardcoded or in-memory data**

👉 Now:
You will replace that with **real database persistence**

---

# 🧩 Task Overview

You will:

1. Convert your existing model into a **JPA Entity**
2. Create a **Repository**
3. Implement full **CRUD endpoints**
4. Connect to **H2 database**
5. Migrate to **PostgreSQL**

---

# 🧱 Required Project Structure

com.yourname.app
 ├── controller
 ├── service
 ├── repository
 ├── entity
 └── exception

---

# 🧾 Step 1: Create 2 Entities with at least 5 fields

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;
    private String email;
    private boolean isRegular;
    private String role;
}


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
}

---

# 🧩 Step 2: Create Repositories for both entities 

example: 
public interface UserRepository extends JpaRepository<User, Long> {}

---

# ⚙️ Step 3: Connect to H2 Database

spring.datasource.url=jdbc:h2:mem:testdb  
spring.h2.console.enabled=true  
spring.jpa.hibernate.ddl-auto=update  

---

# 🔄 Step 4: Implement CRUD Endpoints

GET /api/users  
GET /api/users/{id}
POST /api/users
PUT /api/users/{id}
- Update any or all user details
DELETE /api/users/{id}

GET /api/products  
GET /api/products/{id}
POST /api/products
PUT /api/products/{id}
- Update any or all product details
DELETE /api/product/{id}

---

# 🧪 Step 5: Test Using Postman or CURL

Verify all CRUD operations are working properly

---

# 🔍 Step 6: Verify Using H2 Console

http://localhost:8080/h2-console

---

# 🐘 Step 7: Migrate to PostgreSQL

Just comment out the h2 configuration, DO NOT DELETE.

Add dependency and update properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/yourdb  
spring.datasource.username=postgres  
spring.datasource.password=yourpassword  

---

# 🧠  Step 8: Concept Requirements

- Encapsulation  
- Abstraction  
- Separation of concerns  
- Persistence mapping  

---

# 🔥 Step 9:  Minimum Feature Checklist

- Entity with annotations  
- Repository working  
- Service layer  
- CRUD endpoints  
- H2 working  
- PostgreSQL working  

---

# 🔥 Bonus Points

- Validation  
- Exception handling  
- DTO layer  
- Relationships  

---

# 📝  Step 10: Reflection

- What changed from previous lab?  
- Why database is better?  
- How JPA helped?  
- What changed when switching DB?  

---

# 🔚 Final Tasks

### 11. Commit, Push, and Create PR

- Commit your work
- Push your branch
- Create a **Pull Request to main**

---

### 12. Sync with Main

- Pull latest updates
- Merge into your branch

---

### 13. Review and Retrospect

Think of at least **2 improvements** you could make to your Spring Boot application.

---

### 14. Update your changelog files

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


---

# 💡 Final Insight

If your API still uses hardcoded data, it is not a real backend system.
