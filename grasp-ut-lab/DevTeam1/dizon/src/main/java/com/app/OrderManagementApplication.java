package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderManagementApplication.class, args);
    }
}

//Protected Variations was the most challenging. It required thinking
//  ahead about what parts of the system are likely to change 
// (payment methods, error handling strategies) and wrapping 
// them behind interfaces *before* those changes happen. Unlike the other 
// principles which describe how to assign responsibility to what already exists,
//  Protected Variations forces you to design for uncertainty — which is difficult without experience.

//My initial approach placed the `calculateTotal()` logic inside `OrderService`. I corrected this by moving it
//  into the `Order` entity itself, which properly follows the **Information Expert** principle — the class that owns 
// the data (`items` list) should be the one that knows how to calculate the total from it. The service now simply calls
//  `order.calculateTotal()` and delegates correctly.