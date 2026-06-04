package com.alonde.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlondeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlondeApplication.class, args);
    }

}

/*
   REFLECTION:

   What GRASP principle was hardest?
   - Polymorphism + Protected Variations. Designing a flexible architecture using the PaymentProcessor
     interface took the most effort. It was tricky to ensure OrderService remained loosely coupled while
     allowing distinct payment strategies (Card, Cash, GCash) to scale independently.

   What design mistake did you fix?
   - I fixed a data coupling error in entity interactions. Originally, I tried to pass raw data types
     directly into Order.addItem() (like strings and numbers). I corrected this by instantiating a
     dedicated OrderItem object first and then passing that complete object dependency into the Order
     class.
*/