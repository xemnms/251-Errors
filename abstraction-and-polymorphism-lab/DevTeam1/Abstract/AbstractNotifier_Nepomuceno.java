public abstract class AbstractNotifier_Nepomuceno {

    private final String appName; // E.g., Gmail, WhatsApp, Twitter
    private final String date;
    private String message;
    private boolean readStatus;
    private static int notifCounter = 0;

    // Constructor
    public AbstractNotifier_Nepomuceno(String appName, String date, String message) {
        this.appName = appName;
        this.date = date;
        this.message = message;
        this.readStatus = false;
        notifCounter++;
    }

    //Overloaded constructor for default channel
    public AbstractNotifier_Nepomuceno(String appName, String date) {
    	this.appName = appName;
    	this.date = date;
    	this.message = "You have a notification from " + appName;
        notifCounter++;
    }

    // Abstract method (must be implemented)
    public abstract void sendNotification();

    // Concrete methods
    public void displayNotification() {
        System.out.println("[" + date + "] " + appName + " - " + message);
    }

    public void markAsRead() {
        this.readStatus = true;
        System.out.println("Notification marked as read.");
    }

    
    // Getters
    public String getReadStatus() {
        return readStatus ? "Seen" : "Delivered";
    }

    public String getAppName() {
        return appName;
    }

    public String getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }
    
    public static int getTotalNotif() {
    	return notifCounter;
    }
}