# Classes and Objects Lab

This activity will help you practice **Object-Oriented Programming
(OOP)** concepts including:

-   Classes
-   Objects
-   Attributes (fields)
-   Methods (behaviors)
-   Constructors
-   Static members
-   Collaboration using GitHub

------------------------------------------------------------------------

# How to Run This Code

``` bash
cd classes-and-objects-lab
javac *.java
java ObjectDetailsPrinter
```

------------------------------------------------------------------------

# Lab Tasks

## 1. Create Your Own Class

Create **one Java class** that represents a **real-world entity** needed
by your **term project**.

Examples:

-   `Student`
-   `Seller`
-   `Buyer`
-   `Admin`
-   `Product`
-   `Order`

Your class should demonstrate **good object-oriented structure**.

------------------------------------------------------------------------

## 2. Define Attributes

Your class must contain **at least 3 attributes (fields)**.

Example attributes:

-   `name`
-   `age`
-   `price`
-   `brand`
-   `status`

At least **one attribute must be declared as `static`.**

Example:

``` java
static int totalObjects;
```

------------------------------------------------------------------------

## 3. Define Behaviors (Methods)

Your class must implement **at least 2 methods**.

Requirements:

-   One method **without parameters**
-   One method **with at least one parameter**

Example:

``` java
turnOn()
setName(String name)
```

------------------------------------------------------------------------

## 4. Implement Constructors

Your class must include **multiple constructors**.

### Required

-   Default constructor (no parameters)
-   Parameterized constructor (accepts values)

### Optional Bonus

Create an **overloaded constructor** with different parameters.

Example:

``` java
Product()

Product(String name, double price)

Product(String name)
```

------------------------------------------------------------------------

## 5. Use Static Members

Your class must include **at least one static field or static method**.

Possible uses:

-   counting total objects created
-   utility method related to the class

Example:

``` java
static int totalObjects;

static void printTotalObjects() {
    System.out.println(totalObjects);
}
```

------------------------------------------------------------------------

## 6. Share Your Class

Commit and push your class to the **team GitHub repository** so your
teammates can use it.

Example:

``` bash
git add .
git commit -m "Added Product class"
git push
```

------------------------------------------------------------------------

## 7. Create an Object from a Teammate's Class

Update the file:

    ObjectDetailsPrinter.java

Choose **one class created by a teammate**.

### Rules

-   You **cannot use your own class**
-   A class can **only be used once** for this activity

------------------------------------------------------------------------

## 8. Create Objects Using Different Constructors

From your teammate's class, create **at least two objects** using
different constructors.

Example:

-   Object 1 → created using the **default constructor**
-   Object 2 → created using the **parameterized constructor**

Example:

``` java
Product p1 = new Product();
Product p2 = new Product("Laptop", 45000);
```

------------------------------------------------------------------------

## 9. Access and Display Attributes

Print the attributes of the objects you created.

Example:

``` java
System.out.println(p2.name);
System.out.println(p2.price);
```

------------------------------------------------------------------------

## 10. Trigger Behaviors

Call and demonstrate the behaviors (methods) of the object.

Requirements:

-   Call the method **without parameters**
-   Call the method **with parameters**

Example:

``` java
p1.turnOn();
p2.setName("Gaming Laptop");
```

------------------------------------------------------------------------

## 11. Demonstrate Static Usage

Access or print the static attribute or static method of the class.

Example:

``` java
ClassName.staticField;
ClassName.staticMethod();
```

Example:

``` java
Product.printTotalObjects();
```

------------------------------------------------------------------------

## 12. Submit Your Work

Commit and push the following to your repository:

-   Your **original class**
-   The program that **creates and uses a teammate's class objects**

Ensure your program **compiles and runs successfully**.

------------------------------------------------------------------------

## 13. Review and Retrospect

Think of **at least 2 things you could have done better** during this
lab.

------------------------------------------------------------------------

## 14. Update Your Changelog Files

### A. Team Changelog

Create an entry in your **Team changelog** using this format:

    <Name> <StudentNo/ID> <MM/DD/YYYY> <LabTopic> Completed!

Example:

    Juan Dela Cruz 20230001 03/08/2026 Classes and Objects Lab Completed!

------------------------------------------------------------------------

### B. Personal Journal Entry

Update your **personal `.md` file**.

Format:

    <MM/DD/YYYY> : I learned _____ and next time I will ____

Example:

    03/08/2026 : I learned how constructors work and next time I will test my code earlier.

------------------------------------------------------------------------

### C. Peer Feedback

Add a feedback entry in your **teammate's personal `.md` file**.

Format:

    <MM/DD/YYYY> : Comment by: <COMMENTER_NAME>; You did well in _____ and you can improve by _____

Example:

    03/08/2026 : Comment by: Maria Santos; You did well in explaining your class design and you can improve by adding more comments in your code.

------------------------------------------------------------------------

### D. Pull Request

Create a **Pull Request (PR)** and ask **2 teammates to approve**.

Each reviewer must comment:

    I confirm that <Your Name> completed this lab.

------------------------------------------------------------------------

# Goal of This Lab

By completing this lab, you should be able to:

-   Design a **Java class**
-   Create **objects**
-   Implement **constructors**
-   Use **methods**
-   Work with **static members**
-   Collaborate using **Git and GitHub**
