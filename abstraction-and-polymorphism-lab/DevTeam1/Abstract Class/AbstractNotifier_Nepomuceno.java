public abstract class AbstractNotifier_Nepomuceno implements InterfaceNotifier_Nepomuceno {

    private final String channel; // E.g., SMS, Email, Push Notification
    private final String appName; // E.g., Gmail, WhatsApp, Twitter
    private final String date;
    private final String message;
    private boolean readStatus;

    public AbstractNotifier_Nepomuceno(String channel, String appName, String date, String message) {
        this.channel = channel;
        this.appName = appName;
        this.date = date;
        this.message = message;
        this.readStatus = false;
    }

    @Override
    public String channel() {
        return channel;
    }

    // Abstract method (must be implemented)
    @Override
    public abstract void sendNotification();

    // Concrete methods
    @Override
    public void displayNotification() {
        System.out.println("[" + date + "] " + appName + " - " + message);
    }

    @Override
    public void markAsRead() {
        this.readStatus = true;
        System.out.println("Notification marked as read.");
    }

    @Override
    public String getReadStatus() {
        return readStatus ? "Seen" : "Delivered";
    }

    // Getters
    public String getAppName() {
        return appName;
    }

    public String getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }
}