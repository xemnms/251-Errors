public class ReservationCostiniano {

    private String guestName;
    private int reservationId;
    private int numberOfGuests;
    private int nights;

    private static int totalReservations = 0;

    // default constructor
    public ReservationCostiniano() {
        guestName = "Unknown";
        reservationId = 0;
        numberOfGuests = 1;
        nights = 1;
        totalReservations++;
    }

    // parameterized constructor
    public ReservationCostiniano(String guestName, int reservationId, int numberOfGuests, int nights) {
        setGuestName(guestName);
        setReservationId(reservationId);
        setNumberOfGuests(numberOfGuests);
        setNights(nights);
        totalReservations++;
    }

    // getters
    public String getGuestName() {
        return guestName;
    }

    public int getReservationId() {
        return reservationId;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public int getNights() {
        return nights;
    }

    public static int getTotalReservations() {
        return totalReservations;
    }

    // setters with validation
    public void setGuestName(String guestName) {
        if (guestName != null && !guestName.isEmpty()) {
            this.guestName = guestName;
        } else {
            System.out.println("Guest name cannot be empty.");
        }
    }

    public void setReservationId(int reservationId) {
        if (reservationId > 0) {
            this.reservationId = reservationId;
        } else {
            System.out.println("Reservation ID must be positive.");
        }
    }

    public void setNumberOfGuests(int numberOfGuests) {
        if (numberOfGuests > 0) {
            this.numberOfGuests = numberOfGuests;
        } else {
            System.out.println("Number of guests must be at least 1.");
        }
    }

    public void setNights(int nights) {
        if (nights > 0) {
            this.nights = nights;
        } else {
            System.out.println("Nights must be at least 1.");
        }
    }

    // behavior1
    public void extendStay(int extraNights) {
        if (extraNights > 0) {
            nights += extraNights;
        }
    }

    // behavior2
    public void cancelReservation() {
        System.out.println("Reservation cancelled for " + guestName);
    }
}