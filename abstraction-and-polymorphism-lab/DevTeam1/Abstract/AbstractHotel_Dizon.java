public abstract class AbstractHotel_Dizon {

   
    protected String hotelName;
    protected String location;
    protected int availableRooms;

    // Constructor
    public AbstractHotel_Dizon(String hotelName, String location, int availableRooms) {
        this.hotelName = hotelName;
        this.location = location;
        this.availableRooms = availableRooms;
    }

    // Abstract method: Forces subclasses to define their own booking logic
    public abstract boolean reserveRoom(int count);

    // Abstract method: Forces subclasses to define their own pricing logic
    public abstract double getPricePerNight();

    // Concrete method
    public void displayDetails() {
        System.out.println("Hotel: " + hotelName);
        System.out.println("Location: " + location);
        System.out.println("Rooms Available: " + availableRooms);
    }

    // Getters
    public String getHotelName() {
        return hotelName;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }
}