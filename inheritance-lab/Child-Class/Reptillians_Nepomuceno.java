//Child class created by Nepomuceno
//Extends Aliens_Galindon to represent Reptilian aliens
//This class demonstrates hierarchical inheritance and dynamic binding

class Reptilians_Nepomuceno extends Aliens_Galindon {
    
    // Constructor
    Reptilians_Nepomuceno(String name, int age, String planetOrigin) {
        super(name, age, planetOrigin);
    }
    
    // New behavior specific to Reptilians
    void shapeshifts() {
        System.out.println(name + " (Reptilian) is shapeshifting into a human form.");
    }
    
    // Override the communicate method from parent class
    @Override
    void communicate() {
        System.out.println(name + " (Reptilian) is communicating through hissing sounds from " + planetOrigin + ".");
    }
}