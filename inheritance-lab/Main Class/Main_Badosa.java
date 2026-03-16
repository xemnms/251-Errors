
public class Main_Badosa {
    public static void main(String[] args) {
        Boeing_Badosa boeing = new Boeing_Badosa("Boeing 747", 41000, "Blue", 400, 35000);
        boeing.fly();
        boeing.land();
        boeing.fly();
        boeing.emergencyLand();
        boeing.displayType();

        // Boeing IS-A Aeroplane
        // The displayType method is overridden
        // in dynamic binding. the method 
        // When boeing.displayType() is called in the main method, Java uses dynamic binding to determine at runtime that boeing is a Boeing_Badosa object
        // the methods inherited were fly and land behaviors
        // The subclass introduced a new method called emergancyLand()


    }
    
}
