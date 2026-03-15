// Main Class Created by Alvarez

// Product Class by Bautista

public class Main_Alvarez {
    public static void main(String[] args) {

        // Create products
        ProductBautista laptop = new ProductBautista("Laptop", 1, 50000, 10);
        ProductBautista mouse  = new ProductBautista("Mouse", 2, 1500, 5);

        // Product initial info
        System.out.println("------ INITIAL PRODUCT DETAILS ------");
        laptop.displayProductInfo();
        System.out.println();
        mouse.displayProductInfo();
        System.out.println();

        // Perform transactions ( sell & restock )
        System.out.println("-------- TRANSACTIONS --------");
        laptop.sell(3);    // Selling some units
        mouse.sell(6);     // Attempt to sell more than stock
        laptop.restock(2); // Restock
        mouse.restock(4);
        System.out.println();

        // Display updated info
        System.out.println("------ UPDATED PRODUCT DETAILS ------");
        laptop.displayProductInfo();
        System.out.println();
        mouse.displayProductInfo();
        System.out.println();

        // Invalid inputs ( validation )
        System.out.println("------ TESTING INVALID INPUTS ------");
        laptop.setPrice(-1000); // Invalid
        mouse.setStock(-5);     // Invalid
        laptop.setName("");     // Invalid
        System.out.println("Invalid changes were prevented.\n");

        // Display final product info
        System.out.println("------ FINAL PRODUCT DETAILS ------");
        laptop.displayProductInfo();
        System.out.println();
        mouse.displayProductInfo();
        System.out.println();

        // Show total number of Product objects created ( static count )
        System.out.println("Total Products Created: " + ProductBautista.getTotalProducts());


        // Room Class by Badosa
         // Create a room object
        Room_Badosa room1 = new Room_Badosa();

        // Set room details
        room1.setRoomNumber(101);
        room1.setRoomPrice(150);
        room1.setRoomType("Single");

        // Show room details
        room1.getRoomDetails();

        // Check in
        room1.checkIn();

        // Show room details again
        room1.getRoomDetails();

        // Check out
        room1.checkOut();

        // Show room details again
        room1.getRoomDetails();

        // Create another room
        Room_Badosa room2 = new Room_Badosa();
        room2.setRoomNumber(102);
        room2.setRoomPrice(250);
        room2.setRoomType("Luxury");

        // Show room details
        room2.getRoomDetails();

        // Show total rooms created
        room1.getTotalRoom();
        
    }
    
}


