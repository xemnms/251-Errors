// A hotel and bank management simulation
// Classes used: BankAccount_Alvarez [created by Alvarez] and Room_Badosa [created by Badosa]
// Main class created by Lei Bautista

public class Main_Bautista {

    public static void main(String[] args) {

        // ---------- System Header ----------
        System.out.println("===========================================");
        System.out.println("       Hotel and Bank Management System     ");
        System.out.println("===========================================\n");

        // ---------- Create bank accounts ----------
        BankAccount_Alvarez customer1 = new BankAccount_Alvarez("1207", "Abcde", 15000, "Savings");
        BankAccount_Alvarez customer2 = new BankAccount_Alvarez("0315", "Eyefgi", 3000, "Checking");

        // ---------- Create rooms ----------
        Room_Badosa room101 = new Room_Badosa();
        room101.setRoomNumber(101);
        room101.setRoomPrice(5000);
        room101.setRoomType("Single");

        Room_Badosa room202 = new Room_Badosa();
        room202.setRoomNumber(202);
        room202.setRoomPrice(8000);
        room202.setRoomType("Double");

        // ---------- Display initial info ----------
        System.out.println("→ INITIAL BANK ACCOUNTS");
        displayAccountInfo(customer1);
        displayAccountInfo(customer2);

        System.out.println("→ INITIAL ROOM INFO");
        displayRoomInfo(room101);
        displayRoomInfo(room202);

        // ---------- Customer booking simulation ----------
        System.out.println("\n→ ROOM BOOKING SIMULATION");
        attemptBooking(customer1, room101);
        attemptBooking(customer2, room202);
	System.out.println("\n-------------------------------");

        // ---------- Test invalid inputs ----------
        System.out.println("→ TESTING INVALID INPUTS");
        System.out.println("Your account holder must not be empty"); 
	customer1.setAccountHolder(""); 	 // Invalid
        System.out.println("Account type must be either Savings or Checking"); 
	customer2.setAccountType("Investment");  // Invalid
        room101.setRoomNumber(-10);              // Invalid
        room202.setRoomType("Triple");           // Invalid
        System.out.println("Invalid changes prevented.\n");

        // ---------- Display final info ----------
        System.out.println("→ TESTING INVALID INPUTS FINAL BANK ACCOUNTS");
        displayAccountInfo(customer1);
        displayAccountInfo(customer2);

        System.out.println("→ FINAL ROOM INFO");
        displayRoomInfo(room101);
        displayRoomInfo(room202);

        // ---------- Static info ----------
        System.out.println("\n===========================================");
        System.out.println("Total bank accounts created: " + BankAccount_Alvarez.getTotalAccounts());
        System.out.print("Total rooms created        : "); room101.getTotalRoom();
        System.out.println("\n===========================================\n");
    }

    // ---------- Helper method: display bank info ----------
    public static void displayAccountInfo(BankAccount_Alvarez account) {
        System.out.println("-------------------------------");
        System.out.println("Account number : " + account.getAccountNumber());
        System.out.println("Account holder : " + account.getAccountHolder());
        System.out.println("Account type   : " + account.getAccountType());
        System.out.println("Balance        : " + account.getBalance());
        System.out.println("-------------------------------");
    }

    // ---------- Helper method: display room info ----------
    public static void displayRoomInfo(Room_Badosa room) {
        // Simply calls the class's method
        room.getRoomDetails();
    }

    // ---------- Helper method: attempt booking ----------
    public static void attemptBooking(BankAccount_Alvarez customer, Room_Badosa room) {
        System.out.println(customer.getAccountHolder() + " attempts to book Room " 
                + room.getRoomNumber() + " ($" + room.getRoomPrice() + ")");
        if (customer.getBalance() >= room.getRoomPrice()) {
            customer.withdraw(room.getRoomPrice());
            room.checkIn();
            System.out.println("Booking successful.\n");
        } else {
            System.out.println("Insufficient funds. Booking failed.\n");
        }
    }
}