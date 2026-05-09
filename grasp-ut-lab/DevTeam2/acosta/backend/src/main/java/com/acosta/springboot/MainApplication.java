package com.acosta.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}

/*
What GRASP principle was hardest?
- The fabrication of the order service I didn't fully understand at first, I only knew little of what it was for and I didn't know how to implement it

What design mistake did you fix?
- I thought that the orderservice would also include the computation of the cost, but it is againts grasp principles.
*/