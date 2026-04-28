package com.rodenas.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

}
/*
 * ====== REFLECTION ======
 *
 * 1. What changed from previous lab?
 *    In the previous lab, I created a basic Spring Boot REST API that returned
 *    hardcoded data from a Map inside the controller. The data disappeared every
 *    time the app restarted. In this lab, I upgraded to a full CRUD API with real
 *    database persistence using Spring Data JPA. I also added proper project structure
 *    with separate packages for controller, service, repository, entity, dto, and exception,
 *    plus bonus features like validation and global exception handling.
 *
 * 2. Why is a database better?
 *    A database is better because data persists even after the app restarts.
 *    I proved this when I switched from H2 to PostgreSQL — the data stayed in
 *    PostgreSQL even after restarting the app, unlike the hardcoded Map in the
 *    previous lab which lost everything on restart. A real backend needs
 *    real persistence to be useful.
 *
 * 3. How did JPA help?
 *    JPA made database work much easier. Instead of writing raw SQL, I just
 *    annotated my Java classes with @Entity, @Id, and @GeneratedValue, and
 *    Spring Data JPA automatically created the tables and gave me CRUD methods
 *    like findAll(), findById(), save(), and deleteById() through JpaRepository
 *    without writing a single SQL query manually.
 *
 * 4. What changed when switching from H2 to PostgreSQL?
 *    The Java code did not change at all — only the application.properties changed.
 *    I commented out the H2 configuration and uncommented the PostgreSQL configuration.
 *    The main challenge was setting up PostgreSQL in Codespaces — I had to start the
 *    PostgreSQL service, create the database, create a user, and grant schema permissions
 *    before the app could connect and create tables successfully.
 */