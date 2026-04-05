# Peer Lab Exercise: Packages, Project Organization, and Build Tools (Java 2026)

## Objective

This lab builds on your previous **Calculator with Exceptions system** and upgrades it into a **real-world structured Java project**.

You will now:
- Organize your code using **Java packages**
- Structure your project properly
- Use a **build tool (Maven or Gradle)**
- Work individually within a shared team repository

---

## Challenge Goal

By completing this exercise you should demonstrate:

- Proper **package organization**
- Use of **layered architecture (model, service, etc.)**
- Understanding of **access modifiers across packages**
- Ability to setup and use **Maven or Gradle**
- Clean **project structure**
- Professional **Git workflow**

---

## Important Rule (NEW)

Each student must:

👉 Create their own **subfolder using their SURNAME**

Example:

```
project-root/
 ├── delaCruz/
 ├── santos/
 ├── reyes/
```

Inside your folder, you will place your **own version of the Calculator system**.

---

## Tasks

### 1. Create a New Branch (Required)

```
packages-build-<your-name>
```

---

### 2. Create Your Personal Project Folder

Inside the repository:

```
<your-surname>/
```

All your work must be inside this folder.

---

### 3. Convert Your Previous Lab into a Structured Project

Take your **Calculator + Exceptions system** and reorganize it using packages:

Example:

```
com.calculator.<surname>
 ├── model
 ├── service
 ├── exception
 ├── util
 └── main
```

---

### 4. Apply Proper Package Declarations

Each class must include:

```java
package com.calculator.<surname>.service;
```

---

### 5. Enforce Layered Structure

You must separate:

- **model** → data classes (if any)
- **service** → calculator logic
- **exception** → custom exceptions
- **main** → demo / execution class

---

### 6. Use Access Modifiers Properly

- Use `private` for fields  
- Use `public` only when needed  
- Use package-private where appropriate  

---

### 7. Setup Maven OR Gradle (Required)

Choose ONE:

---

#### Option A: Maven

Inside your folder:

```
pom.xml
```

Basic structure:

```xml
<project>
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.calculator</groupId>
  <artifactId><surname>-calculator</artifactId>
</project>
```

Run:

```
mvn clean install
```

---

#### Option B: Gradle

Inside your folder:

```
build.gradle
```

Example:

```gradle
plugins {
    id 'java'
}

group = 'com.calculator'
version = '1.0'
```

Run:

```
gradle build
```

---

### 8. Ensure Your Project Builds Successfully

Your project must:

- Compile successfully  
- Run your demo class  

---

### 9. Create Demo Program

```
CalculatorDemo_<Surname>.java
```

Must:
- Use packaged classes
- Trigger exceptions
- Show proper output

---

### 10. Add Code-Based Analysis (Comments)

Answer inside your code:

- How did you organize your packages?
- Why did you separate your classes this way?
- How do packages improve encapsulation?
- Where are your exceptions located?
- Why did you choose Maven or Gradle?

---

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

Think of at least **2 improvements**.

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

## 🔥 Why This Lab Works

This lab forces you to:

- Transition from **basic Java → real project structure**
- Use **packages as design boundaries**
- Understand **how build tools manage projects**
- Work in a **multi-developer environment**

---

## 💡 Key Insight

> “Writing code is not enough. Structuring it properly is what makes you a developer.”
