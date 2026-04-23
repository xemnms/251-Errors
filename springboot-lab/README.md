# Spring Boot Application Guide for Beginners

## Introduction

Spring Boot is a powerful framework that makes it easy to create stand-alone, production-grade Spring-based applications. It simplifies the setup and development process by providing auto-configuration, embedded servers, and a wide range of starter dependencies. This guide will walk you through creating a Spring Boot application from scratch and exploring its core functionalities.

## Prerequisites

Before we begin, make sure you have the following installed on your system:

1. **Java Development Kit (JDK)**: Version 17 or higher
   - Download from [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) or use OpenJDK

2. **Build Tool**: Maven or Gradle
   - Maven: Download from [maven.apache.org](https://maven.apache.org/download.cgi)
   - Gradle: Download from [gradle.org](https://gradle.org/install/)

3. **Integrated Development Environment (IDE)**: IntelliJ IDEA, Eclipse, or VS Code
   - We recommend IntelliJ IDEA Community Edition for Spring Boot development

4. **Basic Knowledge**: Familiarity with Java programming language

## Step 1: Creating a Spring Boot Project

### Option 1: Using Spring Initializr (Recommended)

Spring Initializr is a web-based tool that generates a basic Spring Boot project structure.

1. Open your browser and go to [start.spring.io](https://start.spring.io)

2. Configure your project:
   - **Project**: Maven Project
   - **Language**: Java
   - **Spring Boot**: Latest stable version (e.g., 3.2.x)
   - **Project Metadata**:
     - Group: `com.example`
     - Artifact: `demo`
     - Name: `demo`
     - Description: `Demo project for Spring Boot`
     - Package name: `com.example.demo`
   - **Packaging**: Jar
   - **Java**: 17 or higher

3. Add dependencies:
   - Spring Web (for REST APIs)
   - Spring Data JPA (for database operations)
   - H2 Database (for in-memory database)
   - Spring Boot DevTools (for development)

4. Click "Generate" to download the project as a ZIP file

5. Extract the ZIP file to your desired location

### Option 2: Manual Setup

If you prefer to set up the project manually:

1. Create a new directory for your project
2. Create a `pom.xml` file (for Maven) or `build.gradle` file (for Gradle)
3. Set up the basic project structure

## Step 2: Understanding the Project Structure

After creating the project, you'll see the following structure:

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── demo/
│   │               └── DemoApplication.java
│   └── resources/
│       ├── application.properties
│       └── static/
└── test/
    └── java/
        └── com/
            └── example/
                └── demo/
                    └── DemoApplicationTests.java
```

- `DemoApplication.java`: The main application class with the `@SpringBootApplication` annotation
- `application.properties`: Configuration file for your application
- `DemoApplicationTests.java`: Basic test class

## Step 3: Running Your First Spring Boot Application

1. Open the project in your IDE
2. Navigate to `DemoApplication.java`
3. Right-click and select "Run" or use the run button in your IDE

You should see output similar to:
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.2.0)

2024-01-15 10:30:45.123  INFO 12345 --- [main] com.example.demo.DemoApplication : Starting DemoApplication using Java 17
2024-01-15 10:30:45.456  INFO 12345 --- [main] com.example.demo.DemoApplication : No active profile set, falling back to default profiles: default
2024-01-15 10:30:46.789  INFO 12345 --- [main] com.example.demo.DemoApplication : Started DemoApplication in 2.345 seconds
```

Your application is now running on `http://localhost:8080`

## Core Functionalities of Spring Boot

### 1. Dependency Injection and Inversion of Control (IoC)

Spring Boot uses dependency injection to manage object creation and dependencies.

**Example**: Create a simple service

```java
// GreetingService.java
package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getGreeting() {
        return "Hello, Spring Boot!";
    }
}
```

```java
// GreetingController.java
package com.example.demo.controller;

import com.example.demo.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greeting")
    public String greeting() {
        return greetingService.getGreeting();
    }
}
```

Test it: Visit `http://localhost:8080/greeting`

### 2. REST Controllers and Web Development

Spring Boot makes it easy to create RESTful web services.

**Example**: Create a REST API for managing users

```java
// User.java
package com.example.demo.model;

public class User {
    private Long id;
    private String name;
    private String email;

    // Constructors, getters, and setters
    public User() {}

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters and setters...
}
```

```java
// UserController.java
package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private List<User> users = new ArrayList<>();
    private Long nextId = 1L;

    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        user.setId(nextId++);
        users.add(user);
        return user;
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                updatedUser.setId(id);
                users.set(i, updatedUser);
                return updatedUser;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }
}
```

Test the API using curl or Postman:
- GET `/api/users` - Get all users
- GET `/api/users/1` - Get user with ID 1
- POST `/api/users` with JSON body `{"name":"John Doe","email":"john@example.com"}`
- PUT `/api/users/1` with JSON body `{"name":"Jane Doe","email":"jane@example.com"}`
- DELETE `/api/users/1`

### 3. Data Persistence with Spring Data JPA

Spring Boot integrates easily with databases using Spring Data JPA.

First, add JPA entities:

```java
// User.java (updated)
package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    // Constructors, getters, and setters
    public User() {}

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and setters...
}
```

Create a repository:

```java
// UserRepository.java
package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
```

Update the controller to use the repository:

```java
// UserController.java (updated)
package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        if (userRepository.existsById(id)) {
            updatedUser.setId(id);
            return userRepository.save(updatedUser);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
```

### 4. Configuration Management

Spring Boot allows flexible configuration through `application.properties` or `application.yml`.

**Example**: Configure database and server settings

```properties
# application.properties
# Server configuration
server.port=8080
server.servlet.context-path=/api

# Database configuration (H2 in-memory database)
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# JPA configuration
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true

# H2 Console (for development)
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Logging
logging.level.com.example.demo=DEBUG
```

### 5. Testing with Spring Boot

Spring Boot provides excellent testing support.

**Example**: Unit test for the GreetingService

```java
// GreetingServiceTest.java
package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class GreetingServiceTest {

    @Autowired
    private GreetingService greetingService;

    @Test
    public void testGetGreeting() {
        String greeting = greetingService.getGreeting();
        assertThat(greeting).isEqualTo("Hello, Spring Boot!");
    }
}
```

**Example**: Integration test for the UserController

```java
// UserControllerIntegrationTest.java
package com.example.demo.controller;

import com.example.demo.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@SpringBootTest
@AutoConfigureWebMvc
public class UserControllerIntegrationTest {

    @Autowired
    private UserController userController;

    private MockMvc mockMvc = standaloneSetup(userController).build();

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateUser() throws Exception {
        User user = new User("John Doe", "john@example.com");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john@example.com"));
    }
}
```

### 6. Spring Boot Actuator for Monitoring

Spring Boot Actuator provides production-ready features like health checks and metrics.

Add the dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

Configure actuator endpoints in `application.properties`:

```properties
# Actuator configuration
management.endpoints.web.exposure.include=health,info,metrics
management.endpoint.health.show-details=always
```

Test the endpoints:
- `http://localhost:8080/actuator/health` - Application health status
- `http://localhost:8080/actuator/info` - Application information
- `http://localhost:8080/actuator/metrics` - Application metrics

### 7. Basic Security with Spring Security

Add security to your application.

Add the dependency:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

Create a security configuration:

```java
// SecurityConfig.java
package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authz) -> authz
                .requestMatchers("/api/public/**").permitAll()
                .anyRequest().authenticated()
            )
            .httpBasic();
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("password")
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }
}
```

Now, most endpoints require authentication. Use username "user" and password "password" for basic auth.

## Step 4: Building and Packaging Your Application

### Building with Maven

```bash
mvn clean package
```

### Building with Gradle

```bash
gradle build
```

This creates a JAR file in the `target/` (Maven) or `build/libs/` (Gradle) directory.

### Running the packaged application

```bash
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

## Step 5: Deploying Your Spring Boot Application

Spring Boot applications can be deployed in various ways:

1. **Standalone JAR**: Run as shown above
2. **Docker**: Create a Dockerfile and containerize your application
3. **Cloud Platforms**: Deploy to AWS, Heroku, Azure, etc.
4. **Traditional Application Servers**: Although Spring Boot is designed to run standalone

## Best Practices

1. **Follow Naming Conventions**: Use proper package naming and class naming conventions
2. **Use Dependency Injection**: Avoid manual object creation; let Spring manage dependencies
3. **Write Tests**: Always write unit and integration tests for your code
4. **Use Profiles**: Separate configuration for different environments (dev, test, prod)
5. **Monitor Your Application**: Use Actuator endpoints to monitor application health
6. **Secure Your Application**: Implement proper authentication and authorization
7. **Document Your APIs**: Use Swagger/OpenAPI for API documentation

## Common Issues and Troubleshooting

1. **Port Already in Use**: Change the port in `application.properties`
2. **Database Connection Issues**: Check your database configuration
3. **Dependency Conflicts**: Use `mvn dependency:tree` to check for conflicts
4. **Application Won't Start**: Check the logs for error messages

## Next Steps

Now that you have a basic understanding of Spring Boot, you can explore:

- Advanced topics like microservices with Spring Cloud
- Reactive programming with Spring WebFlux
- Integration with message brokers like RabbitMQ or Kafka
- Building full-stack applications with Spring Boot and frontend frameworks

## Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Initializr](https://start.spring.io)
- [Spring Boot Guides](https://spring.io/guides)
- [Baeldung Spring Boot Tutorials](https://www.baeldung.com/spring-boot)

Happy coding with Spring Boot!