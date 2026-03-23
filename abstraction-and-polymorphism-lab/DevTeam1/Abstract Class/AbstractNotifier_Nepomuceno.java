public class AbstractNotifier_Nepomuceno {
    private String notifTitle;
    private String date;
    private String message;
    private boolean readStatus;

    public String getNotifTitle() {
        return notifTitle;
    }

    public String getDate(){
        return date;
    }

    public String getMessage(){
        return message;
    }

    public boolean getReadStatus(){
        return readStatus;
    }

    AbstractNotifier_Nepomuceno(String notifTitle, String date, String message){
        this.notifTitle = notifTitle;
        this.date = date;
        this.message = message;
        this.readStatus = false;
    }

    void notify(){
        System.out.println("");
    }
}