public class AbstractionPolyDemo_Bagay {
    public static void main(String[] args) {

        // SmartPet_Bagay uses abstract class `petAnimal_Acosta` created by Acosta.
        SmartPet_Bagay pet = new SmartPet_Bagay();
        pet.move();
        pet.makeNoise("beep-beep");

        // Overloading on a concrete class.
        pet.move("left side");

        // TimedFeeder_Bagay uses interface `Feed_Acosta` created by Acosta.
        TimedFeeder_Bagay feeder = new TimedFeeder_Bagay();
        feeder.feedAnimal();
        feeder.selectTreat("dry biscuit");

        // Overloading on interface implementer.
        feeder.feedAnimal("salmon meal");
    }
}

/*Code-based analysis:
1) Abstract class created: LearningModule_Bagay.
2) Interface created: Trackable_Bagay.
3) Overridden methods: move() in SmartPet_Bagay, feedAnimal() in TimedFeeder_Bagay.
4) Overloaded methods: move(String) in SmartPet_Bagay, feedAnimal(String) in TimedFeeder_Bagay.

5) Dynamic binding: when move() and feedAnimal() are called, Java dispatches to the overriding 
    implementations at runtime.

6) Polymorphism: SmartPet_Bagay behaves as a petAnimal_Acosta type via inherited behavior, 
    and TimedFeeder_Bagay behaves as a Feed_Acosta type through implemented contract.

7) Low coupling: the design depends on abstract contracts (abstract class/interface) rather than 
    tightly binding all logic to one concrete type.
    
8) High cohesion: each class has one focused responsibility (pet movement/feeding behavior, module behavior, progress tracking).
*/