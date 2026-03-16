
# Peer Lab Exercise: Practicing Inheritance in Java

## Objective

The goal of this lab is to practice **Inheritance in Java** through collaboration with your teammates.
You will design a **parent class**, extend a **teammate’s class**, implement **method overriding**, and observe **dynamic binding behavior**.

You will also practice a **professional Git workflow** using your team repository.

---

# Challenge Goal

By completing this exercise you should demonstrate:

• Correct use of **IS-A relationships**  
• Implementation of **parent and child classes**  
• Proper **method overriding**  
• Understanding of **dynamic binding behavior**  
• Ability to extend a **teammate’s class**  
• Collaborative **GitHub workflow**  

---

# Tasks

## 1. Create a New Branch

Create a new branch from `main`.

Example:

```
inheritance-<your-name>
```

Make sure your branch is **updated with the latest main branch**.

---

## 2. Create Your Parent Class

Create a **base class** representing a general concept.

Examples:

- Animal  
- Vehicle  
- Employee  
- Device  
- Character  
- Product  

### Requirements

Your parent class must contain:

- At least **3 attributes**
- At least **2 behaviors (methods)**
- At least **1 method that can later be overridden**

Example structure:

```java
class Animal {

    String name;

    void speak() {
        System.out.println("Animal makes a sound");
    }

    void move() {
        System.out.println("Animal moves");
    }

}
```

---

## 3. Commit and Push Your Parent Class

Add your class to the repository.

Commit example:

```
Added Animal parent class
```

Push your branch.

Your classmates will **extend your class later**.

---

## 4. Find a Teammate’s Parent Class

Browse the repository and find a **parent class created by a teammate**.

Rules:

- You **cannot use your own class**
- A class should **only be extended once if possible**

---

## 5. Create a Child Class

Create a subclass that extends your teammate’s class.

Example:

```java
class Dog extends Animal {

}
```

This establishes the **IS-A relationship**.

Example meaning:

```
Dog IS-A Animal
```

---

## 6. Add New Behavior in the Child Class

Your subclass must add **at least one new method**.

Example:

```java
void bark() {
    System.out.println("Dog barks");
}
```

---

## 7. Override a Parent Method

Override at least **one method from the parent class**.

Example:

```java
@Override
void speak() {
    System.out.println("Dog barks");
}
```

This demonstrates **method overriding**.

---

## 8. Demonstrate Dynamic Binding

Create a test program (Main_<Lastname>.java) that demonstrates **runtime polymorphism**.


Example:

```java
Animal a = new Dog();
a.speak();
```

Explain what happens:

- The variable type is **Animal**
- The actual object is **Dog**
- The **Dog version of speak() executes**

---

## 9. Demonstrate Multiple Subclasses (Optional Bonus) x2 multiplier

If possible, create **another subclass** extending the same parent class.

Example:

```
Animal
 ├ Dog
 └ Cat
```

This demonstrates **hierarchical inheritance**.

---

## 10. Create an Inheritance Demo Program

Update Main_<Lastname>.java file:

The program must:

- Create objects of your subclass
- Call inherited methods
- Call overridden methods
- Show dynamic binding behavior

Example output:

```
Dog barks
Animal moves
```

---

## 11. Analyze the Inheritance Behavior

Update Main_<Lastname>.java file:

Answer the following questions, just add them as comments on top of the actual implementation:

- What is the **IS-A relationship** in your program?
- Which method was **overridden**?
- What happens during **dynamic binding**?
- What methods were **inherited from the parent class**?
- What new behavior did the subclass introduce?

---

## 12. Commit and Push All Files

Your branch should contain:

- Your parent class
- Your subclass
- Main_<Lastname>.java

Push your branch to GitHub.

---

## 13. Review and Retrospect

Think of **at least 2 things you each could have done better** during the activity.

---

## 14. Update your changelog files

### a. Create an entry in your existing Team changelog (team-changelog.md) with format:

```
<Name> <StudentNo/ID> <MM/DD/YYYY> <LabTopic> Completed!
```

Example:

```
Juan Dela Cruz 2025-1023456 03/20/2026 Inheritance Lab Completed!
```

---

### b. Update your personal `.md` file

Create a short journal on how you completed today's tasks and the **2 things you raised during retrospection**.

Format:

```
<MM/DD/YYYY> : I learned _____ and next time I will _____
```

---

### c. Add a feedback entry in your teammates' `personal.md` file

Answer the questions in **one sentence**.

Format:

```
<MM/DD/YYYY> : Comment by: <COMMENTER's name>; You did well in _____ and you can improve by _____
```

---

### d. Create a Pull Request

Create a **PR** and ask **2 teammates to approve**.

Each teammate must add the comment:

```
I confirm that <Your Name> completed this lab.
```
