# ðŸš€ OOP Full-Stack Lab Exercise (React + Spring Boot + PostgreSQL)

---

# ðŸŽ¯ Objective

Build a **full-stack web application** that demonstrates:

- Frontend development using **React (Vite + TypeScript)**
- Backend development using **Spring Boot (Java + JPA)**
- Database integration using **PostgreSQL**
- Application of **OOP principles across frontend and backend**

---

# ðŸ§  Challenge Goal

By completing this exercise you should demonstrate:

- Encapsulation (state management, entity design)
- Abstraction (API layer, repositories)
- Separation of Concerns (Frontend â†” Backend â†” Database)
- Full CRUD functionality
- Successful frontend-backend integration

---

# ðŸ“ Required Folder Structure

Each student must create a folder using their **SURNAME**:

```
/<YourSurname>
 â”œâ”€â”€ frontend/        (React Vite Project)
 â”œâ”€â”€ backend/         (Spring Boot Project)
 â””â”€â”€ evidence/        (Screenshots / Screen Recording)
```

---

# ðŸ§© Application Requirement

Create a web application that manages a list of:

- Products OR
- Tasks OR
- Employees

---

# ðŸ”„ Required Features (CRUD)

Your application must support:

- âœ… Get All Items
- âœ… Add Item
- âœ… Update Item
- âœ… Delete Item

---

# ðŸŒ Frontend Requirements (React + TypeScript)

- Use **React with Vite**
- Use **TypeScript**
- Create components for:
  - List display
  - Form input
- Use `fetch` or `axios` to call backend APIs
- Maintain proper **state management**

---

# ðŸ§  OOP Concepts (Frontend)

- Encapsulation â†’ component state
- Abstraction â†’ API calls hidden in functions/services
- Separation of concerns â†’ UI vs logic

---

# âš™ï¸ Backend Requirements (Spring Boot)

- Use:
  - Spring Web
  - Spring Data JPA
- Implement:
  - Entity
  - Repository
  - Service
  - Controller
- Provide full CRUD endpoints

---

# ðŸ˜ Database Requirement (PostgreSQL)

- Must connect to **PostgreSQL**
- Must:
  - Create tables automatically (JPA)
  - Persist data beyond restart

---

# ðŸ§  OOP Concepts (Backend)

- Encapsulation â†’ private fields in entity
- Abstraction â†’ repository layer
- Polymorphism â†’ JpaRepository
- Separation of concerns â†’ layered architecture

---

# ðŸ”— Integration Requirement

- Frontend must successfully:
  - Fetch data from backend
  - Send data (POST, PUT, DELETE)
- Data must be reflected in the UI

---

# ðŸŽ¥ Evidence Requirement (MANDATORY)

After completing integration:

Inside `/evidence` folder:

- ðŸŽ¥ **Screen Recording (REQUIRED)**
  - Show:
    - Get all items
    - Add item
    - Update item
    - Delete item
  - Clearly demonstrate:
    - UI updates
    - Data persistence

---

# ðŸ”¥ Minimum Checklist

- [ ] React frontend created
- [ ] Spring Boot backend created
- [ ] PostgreSQL connected
- [ ] CRUD endpoints working
- [ ] Frontend connected to backend
- [ ] UI updates correctly
- [ ] Screen recording added

---

# ðŸ”¥ Bonus Points

- [ ] Use DTOs
- [ ] Add validation
- [ ] Add error handling
- [ ] Use better UI styling
- [ ] Add loading states

---

# ðŸ”„ Git Workflow

1. Create your folder:
```
<YourSurname>
```

2. Commit your work regularly

3. Push to your branch

4. Create a PR to main

---

# ðŸ”š Final Tasks (ALWAYS INCLUDE)

### 8. Review and Retrospect  
Think of at least 2 things you could have done better  

---

### 9. Update your changelog files  

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

#### d. Create a PR  
Ask 2 teammates to approve and comment:  
"I confirm that <Your Name> completed this lab."

---

# ðŸ’¡ Final Insight

> â€œFrontend and backend are separate systems, but good OOP design allows them to work together seamlessly.â€
