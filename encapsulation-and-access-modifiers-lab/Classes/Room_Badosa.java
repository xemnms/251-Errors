/*
 *Class created by Bien Manuel Badosa
 *Room class with validation to its attributes (room number, price, type) and actions with setters and getter
 */

public class Room_Badosa {
    // Attributes
    private int roomNumber = 0;
    private int roomPrice = 0;
    private String roomType = "Unknown";
    private boolean isOccupied = false;

    // Static Attribute
    private static int totalRooms = 0;

    // Default parameter
    public Room_Badosa() {
        totalRooms++;
    }

    // Check in and check out methods
    public void checkIn() {
        isOccupied = true;
        System.out.println("This room is now Occupied");
    }

    public void checkOut() {
        isOccupied = false;
        System.out.println("This room is now Unoccupied");
    }

    // Setters
    public void setRoomNumber(int roomNumber) {
        if (roomNumber > 0) {
            this.roomNumber = roomNumber;
            System.out.println("You have successfully set the RoomNumber");
        } else {
            System.out.println("Your room number must be greater than 0");
        }
    }

    public void setRoomPrice(int roomPrice) {
        if (roomPrice > 0) {
            this.roomPrice = roomPrice;
            System.out.println("You have successfully set the Room Price");
        } else {
            System.out.println("Your room price must be greater than 0");
        }
    }

    public void setRoomType(String roomType) {
        if (roomType.equalsIgnoreCase("Single") ||
                roomType.equalsIgnoreCase("Double") ||
                roomType.equalsIgnoreCase("Luxury")) {
            this.roomType = roomType;
            System.out.println("Successfully set room type");
        } else {
            System.out.println("Please enter one of the following (Single, Double, Luxury)");
        }
    }

    // Getters
    public void getRoomDetails() {
        System.out.println("Your room is a " + roomType + " type numbered as " + roomNumber + " priced at $" + roomPrice
                + " and is " + (isOccupied ? "Occupied" : "Unoccupied"));
    }

    public void getTotalRoom() {
        System.out.println(totalRooms);
    }
}
