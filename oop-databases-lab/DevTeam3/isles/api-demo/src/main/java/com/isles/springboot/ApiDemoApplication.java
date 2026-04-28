package com.isles.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiDemoApplication {

	public static void main(String[] args) {
		//starts the spring boot application
		SpringApplication.run(ApiDemoApplication.class, args);

		/*
		1 The previous lab used hardcoded data, while this lab uses JPA and a real database for storing and managing data
		2 A database is better because it allows data to be saved, updated, deleted, and retrieved more reliably
		3 JPA helped by making it easier to map Java objects to database tables and perform CRUD operations without writing much SQL
		4 When switching databases, mostly the datasource configuration and database driver changed while most of the Java code stayed the same
		*/
	}
}
