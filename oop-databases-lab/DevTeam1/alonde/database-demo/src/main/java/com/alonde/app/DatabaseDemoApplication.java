package com.alonde.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabaseDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseDemoApplication.class, args);
    }
}

/*
   What changed from the previous lab?
   - We replaced hardcoded/in-memory data with a real database. The app now persists data between restarts.

   Why database is better?
   - Databases store data permanently, support multiple users, and handle large amounts of data efficiently.

   How did JPA help?
   - JPA mapped Java objects to database tables automatically. No manual SQL needed for basic CRUD.

   What changed when switching DB?
   - Only the application.properties file changed. The Java code stayed exactly the same. JPA handled the database difference.
 */



