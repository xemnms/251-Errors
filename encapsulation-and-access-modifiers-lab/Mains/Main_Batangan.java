/*
 * Objects created by Clisha Rae Batangan
 */
public class Main_Batangan {

    public static void main(String[] args) {

        // Create objects from the Rodenas class
        // Display welcome message
        LRCBookRodenas.welcomeMessage();

        // Create two book objects
        LRCBookRodenas book1 = new LRCBookRodenas(); // default constructor
        LRCBookRodenas book2 = new LRCBookRodenas(101, "Java Programming", 350); // parameterized

        System.out.println("---- Setting Book Information ----");

        // Using setters with validation
        book1.setBookId(-5);       // invalid
        book1.setBookId(102);      // valid

        book1.setTitle("");        // invalid
        book1.setTitle("Data Structures"); // valid

        book1.setPages(0);         // invalid
        book1.setPages(250);       // valid

        System.out.println("\n---- Book Details Before Borrowing ----");
        book1.getBookDetails();
        book2.getBookDetails();

        System.out.println("\n---- Borrowing Books ----");

        // Behavior: borrow books
        book1.borrowBook();  // valid
        book1.borrowBook();  // already borrowed, shows validation
        book2.borrowBook();  // valid

        System.out.println("\n---- Returning Books ----");

        // Behavior: return books
        book1.returnBook();  // valid
        book1.returnBook();  // already returned, shows validation
        book2.returnBook();  // valid

        System.out.println("\n---- Final Book Status ----");
        book1.getBookDetails();
        book2.getBookDetails();

        System.out.println("\n---- Library Statistics ----");
        // Static methods
        LRCBookRodenas.getTotalBooks();
        LRCBookRodenas.getTotalBorrowedBooks();
        
//--------------------------------------------------------------------------
//Create objects from Isles class
        Isles_Reservations r1 = new Isles_Reservations();
        Isles_Reservations r2 = new Isles_Reservations("Clisha", false, 3, 1500);

        System.out.println("\n---- Setting Reservation Details ----");

        // Using setters with validation
        r1.setBookerName("");        // invalid
        r1.setBookerName("Marco");   // valid

        r1.setTimeBooked(-2);        // invalid
        r1.setTimeBooked(4);         // valid

        r1.setAmountBooked(-500);    // invalid
        r1.setAmountBooked(2000);    // valid


        System.out.println("\n---- Reservation Information ----");

        // Using getters
        System.out.println("Booker Name: " + r1.getBookerName());
        System.out.println("Time Booked: " + r1.getTimeBooked() + " hours");
        System.out.println("Amount Paid: " + r1.getAmountBooked() + " pesos");

        System.out.println("\n---- Confirming Reservations ----");

        // Behavior: confirm booking
        r1.confirmBooking();
        r2.confirmBooking();

        System.out.println("\n---- Reservation Status ----");

        System.out.println("Reservation 1 confirmed: " + r1.isConfirmedBook());
        System.out.println("Reservation 2 confirmed: " + r2.isConfirmedBook());

        System.out.println("\n---- Total Confirmed Reservations ----");

        // Static attribute demonstration
        System.out.println("Total confirmed bookers: " + Isles_Reservations.getTotalBookers());
    }
}
