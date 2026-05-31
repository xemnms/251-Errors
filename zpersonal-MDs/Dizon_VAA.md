# Vic Andrew Dizon
---

## 📊 Scores

| Date       | Activity Type | Title       | Score | Total Points |
|------------|----------------|-------------|--------|--------------|
| 03/05/2026 | Quiz           | Quiz 1      | 5      | 5            |
| 04/20/2026 | Ice Breaker  Host         | Make a word      | 10      | 15            |
| 03/19/2026 - 04/21/2026  | PR Approvals              | Github Submissions           | 18      | 33a            |

---

## 📘 Journals

**\<03/05/2026\>** : I learned the importance of team work in making a system in our lab and to impove, next time I will participate better in every team-discussion.


**\<03/16/2026\>** : todays, I learned how to properly protect object data using private attributes and how to integrate external classes into a single Main program.   

**\<03/19/2026\>** : Developing the F1 Inheritance Management System helped me visualize how real-world entities share common traits while maintaining unique behaviors. By creating the F1Prodigy_Dizon and F1PitCrew_Dizon subclasses, I practiced the 'is-a' relationship in OOP. The most challenging yet rewarding part was ensuring that the unique methods like toggleDRS()—were called correctly while still leveraging inherited attributes from the parent class. This exercise solidified my understanding of code reusability.  

**\<03/20/2026\>**: I learned how to implement composition by integrating teammate-designed classes (Payment_Arandela and Weapon_Nepomuceno) into my own ValorantLoadout_Dizon class. I specifically practiced Low Coupling by ensuring my class only interacts with public methods, allowing me to swap weapons (like the ElderflameVandal) without breaking the system. Next time, I will try to implement Interface-based composition to make the system even more flexible for different types of payment methods.  

**\<03/25/2026\>** : Today, I deepened my understanding of Dynamic Binding by implementing concrete classes based on my teammate Alonde's abstract class and interface. I learned that while a reference variable can be of an abstract type (like AbstractDevice_Alonde), the Java Virtual Machine (JVM) determines which method to call at runtime based on the actual object (the "Concrete" version). This allows for much more flexible and scalable code. I also practiced Method Overloading to provide multiple ways to sync and send data within my device classes.

**\<04/10/2026\>** : I learned how to implement custom exceptions and use method overloading in a shared codebase and next time I will work on more efficient exception propagation strategies.

**\<04/21/2026\>** : I learned how to transform a simple Java application into a professionally structured project using Maven and Layered Architecture. I realized that organizing code into packages like .service and .exception isn't just about making the folder look clean; it's about controlling how different parts of the program interact through access modifiers. For instance, keeping validation logic private within the service layer ensures the integrity of the calculator. Next time, I will explore JUnit to add automated unit tests to my Maven lifecycle so I can verify my logic without manually running the demo class every time.

**\<04/24/2026\>** :  I learned how to build a Spring Boot REST API using @RestController and @GetMapping, and next time I will add more endpoints and try connecting to a real database using Spring Data JPA.

**\<04/28/2026\>** : I learned how to refactor package structures to resolve compilation errors and how to map Java objects to database tables using JPA. Next time, I will ensure my folder structure matches my package declarations from the very beginning.

**\<04/28/2026\>** : I learned how to build a full-stack CRUD application using React, TypeScript, Spring Boot, JPA, and PostgreSQL. I also learned how the frontend communicates with the backend through API endpoints, and how data is stored permanently in a PostgreSQL database.

During this lab, I practiced OOP concepts such as encapsulation through React component state and private Java entity fields, abstraction through service and repository layers, polymorphism through JpaRepository, and separation of concerns between frontend, backend, and database.

I also learned how to set up pgAdmin, create a PostgreSQL database, run a Spring Boot backend, run a Vite React frontend, and connect both systems together.

Next time, I will improve by testing the backend earlier before connecting it to the frontend. I will also organize my setup steps better so I can avoid configuration errors with Maven, JDK, npm, and PostgreSQL.

**\<05/31/2026\>** : I learned how to properly apply the GRASP principles — especially the difference between Pure Fabrication (the Service class) and Indirection (the Repository) — and improved my ability to write meaningful Mockito unit tests that verify behavior without hitting a real database.
  
  

---
## ✉️ Peer Feedbacks 

**\<03/19/2026\>**: Comment by: Arandela; You did well in creating a clear parent class and properly using inheritance, especially with method overriding to show different behaviors.   

**\<03/20/2026\>**: Comment by: Arandela; You did well in applying validation for upgrade levels and adding unique sound effects per skin, and you can improve by expanding behaviors such as equipping or upgrading skins dynamically.  

**\<03/20/2026\>**: Comment by : Nepomuceno; Excellent work in designing the composite and component classes. Your implementation reflects strong understanding of the concept.  

**<03/25/2026>**: Comment by: Alonde; You did well in defining a clear and logical hierarchy for your abstract class. It was very easy to extend. 

**<04/10/2026>**: Comment by: Nepomuceno; You did well implementing the addition and subtraction behaviors of our calculator class, ensuring they were functional and consistent with the overall design. You can improve by adding more validation or edge case handling to further strengthen the reliability of these operations.

**<04/10/2026>**: Comment by: Alonde; You did well implementing both int and double versions of add. The program is smart and simple enough to choose the right logic based on the input. You can improve the InvaliedInputException and store the actual invalid value that was passed, which would allow the handling block to print a more specific message.