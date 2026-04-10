public class CalculatorDemo_Alonde_Dizon_Nepomuceno {
    
}

/*
1. What exceptions did you create?


2. Which are checked vs unchecked?


3. Where are exceptions thrown?


4. Where are they handled?


5. Where does propagation occur?
- Exceptions propagate from the Calculator class methods to the main() method
  in the demo class when they are not handled inside the methods.

6. How did you apply OOP concepts?

Encapsulation:
- The field allowNegativeResults is private and controlled via the constructor.

Abstraction:
- Users interact with the calculator through methods like add(), subtract(),
  multiply(), and divide(), without needing to know the internal logic.

Inheritance:
- Custom exceptions extend Exception and RuntimeException.

Polymorphism:
- Method overloading is used for add, subtract, multiply, and divide methods
  (int and double versions).
*/