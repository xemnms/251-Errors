public class Isles_Reservations{ 
	//This class represents a reservation system where a person can book a reservation.
	//It stores the booker's name, reservation time, payment amount, and confirmation status.
	
    //private attributes
    private String bookName; //name of the person making the reservation
    private boolean confirmedBook; //indicates whether the reservation has been confirmed
    private int timeBooked; //number of hours reserved
    private int amountBooked; //payment amount for the reservation in pesos

    //static attribute (tracks confirmed reservations)
    private static int totalBookers = 0;

    //default constructor 
    //initializes reservations details with default values
    public Isles_Reservations() { 
        this.bookName = "";
        this.confirmedBook = false;
        this.timeBooked = 0;
        this.amountBooked = 0;
    }

    //parameterized constructor
    public Isles_Reservations(String bookName, boolean confirmedBook, int timeBooked, int amountBooked) {
        this.bookName = bookName;
        this.confirmedBook = confirmedBook;
        this.timeBooked = timeBooked;
        this.amountBooked = amountBooked;
    }

    //getter for booker's name
    public String getBookerName() {
        if (bookName.isBlank()) {
            return "Please provide a name";
        }
        return bookName;
    }

    //getter for confirmation status
    public boolean getConfirmedBook() {
        return confirmedBook;
    }

    //getter for booked time
    public int getBookTime() {
        if (timeBooked < 0) {
            System.out.println("Please input a valid amount of time in hours");
            return 0;
        }
        return timeBooked;
    }

    //getter for payment amount
    public int getAmountBook() {
        if (amountBooked < 0) {
            System.out.println("Please enter a valid amount of payment in pesos"); 
            return 0;
        }
        return amountBooked;
    }

    //static getter for total confirmed bookers
    public static int getTotalBookers() {
        return totalBookers;
    }

    //setter for booker's name
    public void setBookerName(String name) {
        if (name.isBlank()) {
            System.out.println("Please provide a name");
        } else {
            this.bookName = name;
        }
    }

    //setter for payment
    public void setBookerAmount(int amount) {
        if (amount < 0) {
            System.out.println("Please enter a valid amount of payment in pesos");
        } else {
            this.amountBooked = amount;
        }
    }

    //setter for booking time
    public void setBookerTime(int time) {
        if (time < 0) {
            System.out.println("Please input a valid amount of time in hours");
        } else {
            this.timeBooked = time;
        }
    }

    //confirmation logic
    public void confirmBooking() {
        if (amountBooked < 0 || timeBooked < 0 || bookName.isBlank()) {
            confirmedBook = false;
            System.out.println("Reservation cannot be confirmed due to invalid details.");
        } else {
            confirmedBook = true;
            totalBookers++;
        }
    }
}
