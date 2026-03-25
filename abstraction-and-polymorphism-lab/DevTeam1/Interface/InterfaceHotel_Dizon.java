public interface InterfaceHotel_Dizon {

    // Constants 
   
    String INDUSTRY_TYPE = "Hospitality";

    // Abstract Methods 

    void checkIn(String guestName);
    
    void checkOut(String guestName);

    boolean processPayment(double amount);

    // Default Method
    default void printServicePolicy() {
        System.out.println("Standard Policy: Check-in is at 2:00 PM, Check-out is at 12:00 PM.");
    }

    // Static Method 
    static String getIndustry() {
        return INDUSTRY_TYPE;
    }
}