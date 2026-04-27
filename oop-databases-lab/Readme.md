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

# 🧾 Step 1: Create Entity

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
}

---

# 🧩 Step 2: Create Repository

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
DELETE /api/users/{id}  

---

# 🧪 Step 5: Test Using Postman or CURL

Verify all CRUD operations

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

# 🧠 Concept Requirements

- Encapsulation  
- Abstraction  
- Separation of concerns  
- Persistence mapping  

---

# 🔥 Minimum Feature Checklist

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

# 📝 Reflection

- What changed from previous lab?  
- Why database is better?  
- How JPA helped?  
- What changed when switching DB?  

---

# 🔄 Git Workflow

crud-persistence-<surname>

---

# 🔚 Final Tasks

8. Review and Retrospect  
9. Update changelog files  

---

# 💡 Final Insight

If your API still uses hardcoded data, it is not a real backend system.
