# Lab Exercise: Encapsulation and Object Collaboration

## Objective

The goal of this lab is to design **well-encapsulated Java classes** that protect their internal data, enforce validation rules, and safely interact with other objects created by your teammates.  

You will also practice a **professional Git workflow** while collaborating in the team repository.

---

# Challenge Goal

By completing this exercise you should demonstrate:

• Strong encapsulation design  
• Enforcement of object invariants  
• Safe data access through getters/setters  
• Validation logic  
• Static class behavior  
• Object collaboration  
• Professional Git workflow  

---

# Team Setup

- Work in your **team GitHub repository**.
- Each student must create **one encapsulated class**.
- Your class will later be used by **other teammates** to demonstrate object collaboration.

---

# Tasks

## 1. Create a New Branch

Create a new branch from `main`.

Example branch name:
encapsulation-<your-last-name>


Confirm your branch is based on the latest version of **main**.

---

## 2. Design an Encapsulated Class

Create a Java class that represents a **real-world entity**.

Examples:

- BankAccount  
- Product  
- Student  
- UserAccount  
- Device  
- LibraryBook  
- Order  
- Reservation  

### Requirements

Your class must contain:

- **At least 4 private attributes**
- **At least 1 static attribute**
- **At least 2 constructors**
- **At least 2 behaviors (methods)**

Example ideas for attributes:
name
id
price
balance
status
stock
age


---

## 3. Enforce Strong Encapsulation

All attributes must be declared:
private


Provide **getters** for attributes that should be readable.

Provide **setters only when modification is allowed**.

Avoid unnecessary setters.

---

## 4. Implement Validation Logic

At least **3 validation rules** must be implemented in setters or behaviors.

Examples:
price cannot be negative
age must be between 0 and 120
withdrawal cannot exceed balance
name cannot be empty
stock cannot be negative


Example:

```java
public void setPrice(double price){
    if(price >= 0){
        this.price = price;
    }
}
```

## 5. Enforce an Object Invariant

Define a rule that must always remain true for your object.

Examples:
- balance >= 0
- stock >= 0
- age >= 0
- password length >= 8

Your methods must prevent the object from entering an invalid state.

Example:
public void withdraw(double amount){
    if(amount > 0 && amount <= balance){
        balance -= amount;
    }
}

## 6. Implement Static Class Behavior

Your class must contain static functionality.

Examples:

- Count number of objects created
- Track total transactions
- Track total users created

Example:
```
static int totalAccounts = 0;

public BankAccount(){
    totalAccounts++;
}
```

## 7. Commit and Push Your Class

Add your class to the repository.

Commit message example:

```
Added encapsulated BankAccount class with validation and static counter
```
Push your branch to GitHub.

## 8. Use Two Classes Created by Teammates

Browse the repository and select two classes created by teammates.

Rules:

- You cannot use your own class
- Choose two different teammate classes

## 9. Create an Object Collaboration Program

Create a Main_<Surname>.java that demonstrates object collaboration.

Your program must:

1. Create objects from the two teammate classes
2. Use their getters and setters
3. Call at least two behaviors from each class
4. Demonstrate validation rules
5. Print meaningful output

Example scenario:

- Student enrolls in Course
- User purchases Product
- Customer withdraws from BankAccount
- LibraryMember borrows Book

## 10. Test Invalid Inputs

Test your teammate classes by attempting invalid operations.

Examples:

- negative price
- withdraw more than balance
- invalid age
- empty name

Observe how encapsulation prevents invalid object states.


## 11. Commit and Push All Work

Your branch should include:

Your encapsulated class

Collaboration test program

EncapsulationReview.md

Push your work to GitHub.

## 12. Review and Retrospect

Think of at least 2 things you each could have done better during the activity.

## 13. Update your changelog files
a. Create an entry in your Team changelog with format:
<Name> <StudentNo/ID> <MM/DD/YYYY> <LabTopic> Completed!

Example:
```
Juan Dela Cruz 2025-1023456 03/15/2026 Encapsulation Lab Completed!
```

b. Update your personal .md file

Create a short journal on how you completed today's tasks and the 2 things you raised during retrospection.

Format:
```
<MM/DD/YYYY> : I learned _____ and next time I will _____
```

c. Add a feedback entry in your teammates' personal.md file

Answer the questions in one sentence.

Format:
```
<MM/DD/YYYY> : Comment by: <COMMENTER's name>; You did well in _____ and you can improve by _____
```

d. Create a Pull Request

Create a PR and ask 2 teammates to approve.

Each teammate must approve and add the comment:

I confirm that <Your Name> completed this lab.