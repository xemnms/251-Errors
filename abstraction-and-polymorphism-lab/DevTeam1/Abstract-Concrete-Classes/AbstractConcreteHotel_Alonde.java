class AbstractConcreteHotel_Alonde extends AbstractHotel_Dizon {
    
    public AbstractConcreteHotel_Alonde(String name, String loc, int rooms) {
        super(name, loc, rooms);
    }

    // overriding
    @Override
    public boolean reserveRoom(int count) {
        if (this.availableRooms >= count) {
            this.availableRooms -= count;
            System.out.println("Success: " + count + " rooms reserved at " + getHotelName());
            return true;
        }
        System.out.println("Failed: Not enough rooms available.");
        return false;
    }

    @Override
    public double getPricePerNight() {
        return 5000.00;
    }

    // overloading
    public void addService() {
        System.out.println("Standard room cleaning service added.");
    }

    public void addService(String specialRequest) {
        System.out.println("Special service added: " + specialRequest);
    }
}
