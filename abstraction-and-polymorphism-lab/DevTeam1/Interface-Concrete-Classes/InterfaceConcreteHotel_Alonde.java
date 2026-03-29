public class InterfaceConcreteHotel_Alonde implements InterfaceHotel_Dizon {
    private String currentGuest; 

    public InterfaceConcreteHotel_Alonde(String guestName) {
        this.currentGuest = guestName; 
    }

    @Override 
    public void checkIn(String guestName) { 
        this.currentGuest = guestName; 
        System.out.println("Check-in successful for: " + guestName); 
    }

    @Override 
    public void checkOut(String guestName) { 
        this.currentGuest = null;
        System.out.println(guestName + " has checked out safely."); 
    }

    @Override 
    public boolean processPayment(double amount) { 
        System.out.println("Payment of PHP " + amount + " processed.");
        return true; 
    }

    public void checkIn(String guestName, int roomNumber) {
        this.currentGuest = guestName;
        System.out.println(guestName + " checked into Room #" + roomNumber);
    }
}