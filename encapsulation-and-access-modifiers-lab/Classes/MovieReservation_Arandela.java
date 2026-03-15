// classes created by Arandela, jherrymei

public class MovieReservation_Arandela {
    private String movieTitle;
    private String customerName;
    private int numberOfTickets;
    private String reservationDate;
    private static int totalReservations = 0;

    public MovieReservation_Arandela() {
        this.movieTitle = "Default Movie";
        this.customerName = "Anonymous";
        this.numberOfTickets = 1;
        this.reservationDate = "2026-03-16";
        totalReservations++;
    }

    public MovieReservation_Arandela(String movieTitle, String customerName, int numberOfTickets, String reservationDate) {
        this.movieTitle = (movieTitle == null || movieTitle.trim().isEmpty()) ? "Unknown Movie" : movieTitle;
        this.customerName = (customerName == null || customerName.trim().isEmpty()) ? "Anonymous" : customerName;
        this.numberOfTickets = (numberOfTickets <= 0) ? 1 : (numberOfTickets > 10) ? 10 : numberOfTickets;
        this.reservationDate = (reservationDate == null || !isValidDateFormat(reservationDate)) ? "2026-03-16" : reservationDate; totalReservations++; } public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = (movieTitle == null || movieTitle.trim().isEmpty()) ? "Unknown Movie" : movieTitle;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = (customerName == null || customerName.trim().isEmpty()) ? "Anonymous" : customerName;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = (numberOfTickets <= 0) ? 1 : (numberOfTickets > 10) ? 10 : numberOfTickets;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = (reservationDate == null || !isValidDateFormat(reservationDate)) ? "2026-03-16" : reservationDate;
    }

    public static int getTotalReservations() {
        return totalReservations;
    }

    private static boolean isValidDateFormat(String date) {
        if (date == null) return false;
        return date.matches("\\d{4}-\\d{2}-\\d{2}");
    }

}
