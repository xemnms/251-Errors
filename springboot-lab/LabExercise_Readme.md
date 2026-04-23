# Peer Lab Exercise: Spring Boot REST API (Java 2026)

## Objective

This lab introduces you to **Spring Boot**, a powerful framework for building web applications and REST APIs. You will create your first Spring Boot application with a REST controller that exposes a simple endpoint.

You will now:
- Set up a **Spring Boot project**
- Create a **REST Controller** with a GET endpoint
- Test your API using **curl**
- Work individually within a shared team repository

---

## Challenge Goal

By completing this exercise you should demonstrate:

- Ability to create a **Spring Boot project**
- Understanding of **REST controllers and endpoints**
- Knowledge of **HTTP methods (GET)**
- Ability to **test APIs with curl**
- Proper **project structure**
- Professional **Git workflow**

---

## Important Rule (NEW)

Each student must:

👉 Create their own **subfolder using their SURNAME**

Example:

```
springboot-lab/
 ├── delaCruz/
 ├── santos/
 ├── reyes/
```

Inside your folder, you will place your **own Spring Boot application**.

---

## Tasks

### 1. Create a New Branch (Required)

```
springboot-api-<your-name>
```

---

### 2. Create Your Personal Project Folder

Inside the `springboot-lab` directory:

```
<your-surname>/
```

All your work must be inside this folder.

---

### 3. Create a Spring Boot Project

Use **Spring Initializr** to generate your project:

1. Go to [start.spring.io](https://start.spring.io)
2. Configure:
   - **Project**: Maven Project
   - **Language**: Java
   - **Spring Boot**: Latest stable version (3.2.x or higher)
   - **Project Metadata**:
     - Group: `com.<surname>.springboot`
     - Artifact: `api-demo`
     - Name: `<Surname>ApiDemo`
     - Package name: `com.<surname>.springboot`
   - **Dependencies**: Add "Spring Web"

3. Download and extract the ZIP into your `<your-surname>/` folder

---

### 4. Implement the REST Controller

Create a new class `MeController.java` in the appropriate package:

```java
package com.<surname>.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeController {

    @GetMapping("/me")
    public String getMe() {
        return "Hello! I am <Your Full Name>, a student learning Spring Boot!";
    }
}
```

**Note**: Replace `<surname>` with your actual surname and `<Your Full Name>` with your complete name.

---

### 5. Test Your Endpoint

Start your Spring Boot application and test the endpoint:

1. Run the application (use your IDE or `mvn spring-boot:run`)
2. Open a terminal and use this curl command:

```bash
curl http://localhost:8080/me
```

Expected output:
```
Hello! I am <Your Full Name>, a student learning Spring Boot!
```

---

### 6. Customize Your Response

Modify the `getMe()` method to return a JSON response instead of plain text:

```java
package com.<surname>.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MeController {

    @GetMapping("/me")
    public Map<String, Object> getMe() {
        Map<String, Object> response = new HashMap<>();
        response.put("name", "<Your Full Name>");
        response.put("studentId", "<Your Student ID>");
        response.put("course", "Java Programming");
        response.put("message", "Learning Spring Boot REST APIs!");
        return response;
    }
}
```

Test again with curl:

```bash
curl http://localhost:8080/me
```

Expected JSON output:
```json
{
  "name": "<Your Full Name>",
  "studentId": "<Your Student ID>",
  "course": "Java Programming",
  "message": "Learning Spring Boot REST APIs!"
}
```

---

### 7. Configure Application Properties

Create or modify `src/main/resources/application.properties`:

```properties
# Server configuration
server.port=8080

# Application info
app.name=<Surname> Spring Boot API
app.version=1.0.0

# Logging
logging.level.com.<surname>.springboot=DEBUG
```

---

### 8. Ensure Your Application Builds and Runs Successfully

Your project must:

- Compile successfully
- Start without errors
- Respond to the `/me` endpoint

---

### 9. Create a Test Class

Create a simple test to verify your endpoint:

```java
package com.<surname>.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@SpringBootTest
@AutoConfigureWebMvc
public class MeControllerTest {

    @Autowired
    private MeController meController;

    private MockMvc mockMvc = standaloneSetup(meController).build();

    @Test
    public void testGetMe() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/me"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").exists());
    }
}
```

---

### 10. Add Code-Based Analysis (Comments)

Answer inside your code comments:

- How did you create your Spring Boot project?
- What is the purpose of the `@RestController` annotation?
- What does the `@GetMapping("/me")` annotation do?
- Why did you change from returning a String to a Map?
- How does Spring Boot handle JSON responses automatically?

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

## 🔥 Why This Lab Works

This lab forces you to:

- Transition from **basic Java → web development with Spring Boot**
- Understand **REST API concepts**
- Learn **HTTP communication**
- Work in a **multi-developer environment**

---

## 💡 Key Insight

> "APIs are the building blocks of modern applications. Learning to create and test them is essential for any developer."

---

## Testing Commands

Use these curl commands to test your endpoint:

```bash
# Test the basic endpoint
curl http://localhost:8080/me

# Test with verbose output
curl -v http://localhost:8080/me

# Test with formatted JSON output
curl http://localhost:8080/me | jq .
```

---

## Common Issues

- **Port 8080 already in use**: Change the port in `application.properties`
- **404 Not Found**: Check your controller package and annotations
- **Compilation errors**: Ensure your package declarations match your folder structure

---

## Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Initializr](https://start.spring.io)
- [REST API Tutorial](https://restfulapi.net/)