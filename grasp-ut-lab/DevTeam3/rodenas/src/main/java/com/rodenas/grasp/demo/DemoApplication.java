package com.rodenas.grasp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

/* REVIEW AND REFLECTION
     What GRASP principle was hardest?
       - Protected Variations was probably the hardest. I initially put all the order processing and payment logic directly 
         in the service layer because it was the quickest way to handle multiple payment types and order cases. It worked 
         at first, but when I started writing tests, I realized I kept going back to mock the same service logic over and 
         over. The inline mocks eventually failed on Java 25 because the service had become too tightly coupled to its 
         dependencies. It became clear that I should have isolated the payment handling and utility logic earlier to 
         protect the core service from changes.
     
     What design mistake did you fix?
       - I fixed the issue of coupling my service layer too tightly to specific implementations. Instead of abstracting 
         away the payment processor variations and the price calculation utility, I had embedded them directly in the 
         service logic. This made testing difficult because I then had to create complex inline mocks. The real fix was 
         removing the unnecessary inline mock of PriceCalculatorUtil and using a real instance instead, which exposed 
         that the service didn't actually need to be mocked in that way. This taught me to build with testability in mind 
         from the start and to separate concerns so that dependencies are either real or clearly abstracted, not forced 
         into mocks.

*/