public interface InterfaceNotifier_Nepomuceno {

	String channel();
	void sendNotification();
	void displayNotification();
	void markAsRead();
	String getReadStatus();
	
	
	default void defaultNotification() {
		System.out.println("You have notifications you haven't read.\n");
	}
}
