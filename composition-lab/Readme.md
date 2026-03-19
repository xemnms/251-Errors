# Peer Lab Exercise: Mastering Composition in Java (Collaborative Git Workflow)

## Objective

The goal of this lab is to **force the use of composition (HAS-A relationship)** in designing Java classes.  
Students will collaboratively build systems where objects are composed of other objects, ensuring:

- Low coupling  
- High cohesion  
- Proper encapsulation  

This lab also enforces a **professional Git workflow**:

- Branch from `main`  
- Commit properly  
- Create a Pull Request (PR) to `main`  

---

## Challenge Goal

By completing this exercise you should demonstrate:

- Correct use of **HAS-A relationships (composition)**  
- Proper **object collaboration**  
- Strong **encapsulation with composition**  
- Understanding of **low coupling and high cohesion**  
- Ability to integrate **multiple teammate classes**  
- Professional **Git branching and PR workflow**  

---

## Tasks

### 1. Create a New Branch (Required)

Create a new branch from `main`.

**Example:**
```
composition-**your-name**
```

Make sure your branch is **updated with the latest `main`** before starting.

---

### 2. Create a Component Class

Each student must create **ONE reusable component class**.

**Examples:**
- Engine  
- Address  
- Product  
- Payment  
- Battery  
- Course  
- Book  

#### Requirements

- At least **3 private attributes**  
- Use **encapsulation (getters/setters)**  
- At least **2 behaviors (methods)**  
- Validation in at least **one setter or method**  

---

### 3. Commit and Push Your Component

**Commit message example:**
```
Added Engine component class with encapsulation
```

PR your branch to main so that your teammates can use your class.

---

### 4. Use TWO Teammate Classes

Select **two component classes created by teammates**.

**Rules:**
- You **cannot use your own class**  
- Use **two different teammate classes**  

---

### 5. Create a Composed Class (MAIN TASK)

Create a class that uses **composition**.

**Example:**
```
Car HAS-A Engine  
Car HAS-A Battery  
```

#### Requirements

- Use **private fields**  
- Use **constructor injection OR setters**  
- Do **NOT use inheritance (`extends`)**  
- Demonstrate **low coupling and high cohesion**  

---

### 6. Create an Object Collaboration Demo

Create:

```
CompositionDemo**Surname**.java
```

Your program must:

- Instantiate teammate classes  
- Pass them into your composed class  
- Call methods across objects  

---

### 7. Demonstrate Low Coupling

Replace a component with another compatible object (if possible).

Explain:

> System still works → **LOW COUPLING**

---

### 8. Analyze the Design

Update your 

```
CompositionDemo**Surname**.java
```

Answer the following:

- What are the **HAS-A relationships**?  
- Which classes were reused?  
- How does composition reduce coupling?  
- How is cohesion maintained?  
- Why is inheritance **NOT appropriate** here?  

---

### 9. Commit and Push All Work

Your team's main branch must include:

- Your component class  
- Your composed class  
- `CompositionDemo**Surname**.java`  
- Add instructor as reviewer  
- Get approval from at least **2 teammates**  

---

### 10. Review and Retrospect

Think of **at least 2 things you each could have done better** during the activity.

---

### 11. Update your changelog files

#### a. Team changelog format:
```
<Name> <StudentNo/ID> <MM/DD/YYYY> <LabTopic> Completed!
```

#### b. Personal `.md` format:
```
<MM/DD/YYYY> : I learned _____ and next time I will _____
```

#### c. Peer feedback format:
```
<MM/DD/YYYY> : Comment by: <COMMENTER's name>; You did well in _____ and you can improve by _____
```

#### d. PR Confirmation comment (optional but recommended):
```
"I confirm that <Your Name> completed this lab."
```
