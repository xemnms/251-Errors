/* Demo Class created by Alvarez
* for Abstract and Interface Classes Created by Bautista
and Concrete Abstract and Interface Classes created by Alvarez */


public class AbstractionPolyDemo_Alvarez {
    public static void main(String[] args) {

         // abstraction + dynamic binding
    Athlete_Bautista athlete = new Runner_Alvarez();

    athlete.introduce("Usain Bolt");
    athlete.sport();

    // interface + dynamic binding
    Training_Bautista trainer = new Trainer_Alvarez();

    trainer.train();
    trainer.schedule();

    // overloading
    Trainer_Alvarez realTrainer = new Trainer_Alvarez();

    realTrainer.train();
    realTrainer.train(5);

    // polymorphism Demo
    Athlete_Bautista athlete2 = new Runner_Alvarez();
    athlete2.sport();
    
    }
}

/*
========== CODE-BASED ANALYSIS =========
1. What abstract class did you create?
   - Runnner_Alvarez

2. What interface did you create?
   - Trainer_Alvarez

3. What methods did you override?
   - sport() in Runner_Alvarez
   - train() in Trainer_Alvarez

4. What methods did you overload?
   - train(int athletes) in Trainer_Alvarez

5. Where does dynamic binding occur in your code?
   - athlete.sport();
   - trainer.train();
   - athlete2.sport();
   (These use reference types but actual object methods are called at runtime)

6. Which part shows polymorphism?
   - Athlete_Bautista athlete = new Runner_Alvarez();
   - Training_Bautista trainer = new Trainer_Alvarez();
   (Same interface, different implementations)

7. How does your design achieve low coupling?
   - Main uses abstract class and interface references instead of concrete classes
   - Changes in implementation won’t affect Main

8. How does your design achieve high cohesion?
   - Each class has a single responsibility:
     - Athlete_Bautista = athlete behavior
     - Training_Bautista = training behavior
     - Runner_Alvarez = specific sport
     - Trainer_Alvarez = training implementation
*/