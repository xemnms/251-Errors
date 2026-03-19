//Child class created by Nepomuceno
//Extends Aliens_Galindon to represent Grey aliens
//This class demonstrates inheritance, method overriding, and new behavior

class Greys_Nepomuceno extends Aliens_Galindon {
    
    // Constructor
    Greys_Nepomuceno(String name, int age, String planetOrigin) {
        super(name, age, planetOrigin);
    }
    
    // New behavior specific to Greys
    void scans() {
        System.out.println(name + " (Grey) is conducting advanced scans of the area.");
    }
    
    // Override the powers method from parent class
    @Override
    void powers() {
        System.out.println(name + " (Grey) has the ability to manipulate technology telepathically.");
    }
}