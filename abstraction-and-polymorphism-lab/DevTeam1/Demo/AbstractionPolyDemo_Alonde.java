public class AbstractionPolyDemo_Alonde {
    public static void main(String[] args) {
        
        // dynamic binding
        AbstractHotel_Dizon myHotel = new AbstractConcreteHotel_Alonde("Crivan Suites", "Laguna", 13);
        InterfaceHotel_Dizon myService = new InterfaceConcreteHotel_Alonde();

        System.out.println("--- Hotel Information ---");
        myHotel.displayDetails();
        
        // overloading
        AbstractConcreteHotel_Alonde specificHotel = (AbstractConcreteHotel_Alonde) myHotel;
        specificHotel.addService();
        specificHotel.addService("Late Check-out");

        System.out.println("\n--- Polymorphism & Dynamic Binding ---");
        myHotel.reserveRoom(3);
        
        myService.printServicePolicy(); // default method
        myService.checkIn("Charlie");
        myService.processPayment(myHotel.getPricePerNight());

        /* CODE-BASED ANALYSIS

        1. Abstract class 
            AbstractHotel_Dizon

        2. Interface created 
            InterfaceHotel_Dizon

        3. Methods overridden 
            reserveRoom() and getPricePerNight() from AbstractHotel_Dizon; 
            checkIn(), checkOut(), and processPayment() from InterfaceHotel_Dizon

        4. Methods overloaded 
            addService() and addService(String specialRequest)

        5. Dynamic binding 
            occurs at: 'myHotel.reserveRoom(3)' and 'myService.checkIn()'
        
        6. Polymorphism 
            shown when AbstractHotel_Dizon (Parent type) is used to refer to AbstractConcreteHotel_Alonde

        7. Low Coupling 
            the code interacts with 'myService' using the interface type, 
           
        8. High Cohesion
            Each class has a clear job and related methods together;
            AbstractConcreteHotel_Alonde focuses only on room/price management, 
            while InterfaceConcreteHotel_Alonde focuses only on guest workflow.
        */
    }
}