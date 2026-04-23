package com.batangan.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiDemoApplication.class, args);
	}

}
/*
1. How did you create your Spring Boot project?
- I used Spring Initializr to generate the project. It gave me a ready Spring Boot setup that I opened in my IDE and started coding.

2. What is the purpose of @RestController?
- It tells Spring that this class will handle web requests and return data like JSON. It also means I don’t need to manually convert responses to text or JSON.

3. What does @GetMapping("/me") do?
- It connects the /me URL to a method. When someone visits /me, that method runs and sends back a response.

4. Why did you change from returning a String to a Map?
- Because a Map lets me return multiple pieces of data like name, studentId, course instead of just one text value.

5. How does Spring Boot handle JSON responses automatically?
- Spring Boot automatically changes Java objects like Map or class objects into JSON before sending them to the browser or client.
*/
