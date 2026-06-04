package com.app.batangan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BatanganApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatanganApplication.class, args);
	}

}
/*
What GRASP principle was hardest?
The hardest principle to apply was Protected Variations. 
While building the Task system, it was tempting to directly implement features without thinking about future changes. 
However, designing interfaces such as for task actions or behaviors required anticipating possible extensions, 
like different task types or status handling. This made the design more flexible but also more challenging to plan.

What design mistake did you fix?
One design mistake I initially made was placing too much logic inside the controller, such as handling task processing and validation. 
This violated the Controller and High Cohesion principles. I fixed this by transferring the business logic into the service layer, 
allowing the controller to only manage HTTP requests while the service handled the logic. This improved the structure, readability, 
and testability of the system.
*/
