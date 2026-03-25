public class InterfaceConcreteNotifier_Arandela implements InterfaceNotifier_Nepomuceno {

    private String message;
    private boolean isRead;

    public InterfaceConcreteNotifier_Arandela(String message) {
        this.message = message;
        this.isRead = false;
    }

    // IMPLEMENTING INTERFACE METHODS
    @Override
    public void sendNotification() {
        System.out.println("Sending notification: " + message);
    }

    @Override
    public void displayNotification() {
        System.out.println("Notification: " + message);
    }

    @Override
    public void markAsRead() {
        isRead = true;
        System.out.println("Notification marked as read.");
    }

    @Override
    public String getReadStatus() {
        return isRead ? "Seen" : "Delivered";
    }
}