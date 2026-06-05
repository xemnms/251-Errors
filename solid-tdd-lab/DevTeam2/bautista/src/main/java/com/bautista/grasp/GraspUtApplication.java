package com.bautista.grasp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * GRASP: Controller entry point (system bootstrap)
 */
@SpringBootApplication
public class GraspUtApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraspUtApplication.class, args);
    }
}

/*  
--- Review and Retrospect ---
1. What GRASP principle was hardest?
    - Protected Variations was probably the hardest for me. I kept putting logic inside the service layer 
    because it was the easiest way to make things work, especially for different order cases. It was fine 
    at first, but later on I noticed I kept going back to the same code whenever something changed, so it 
    wasn’t really flexible. Eventually, it made more sense to split responsibilities instead of forcing 
    everything into one place.

2. What design mistake did you fix?
    - I fixed the issue of not properly separating responsibilities in the system. At first, I focused more 
    on making features work quickly, which led to putting too much logic in one place, especially in the service 
    layer. Over time, this made the code harder to adjust when changes or tests were introduced. Cleaning this 
    up helped improve the overall structure and made the flow of the application clearer and more manageable.

*/