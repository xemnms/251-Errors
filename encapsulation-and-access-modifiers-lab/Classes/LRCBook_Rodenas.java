/*
 *Class created by Kyla Cassandra Rodenas
 *LRCBook class with validation for its attributes and actions for borrowing
 *and returning books from the LRC.
*/

public class LRCBook_Rodenas {
    //Attributes
    private int bookId = 0;
    private String title = "Unknown";
    private int pages = 0;
    private boolean isBorrowed = false;
    //Static Attributes
    private static int totalBooks = 0;
    private static int totalBorrowedBooks = 0;
    //Default Constructor
    public LRCBook_Rodenas() {
        totalBooks++;
    }
    //Second Constructor
    public LRCBook_Rodenas(int bookId, String title, int pages) {

        if (bookId > 0) {
            this.bookId = bookId;
        }

        if (title != null && !title.isEmpty()) {
            this.title = title;
        }

        if (pages > 0) {
            this.pages = pages;
        }

        totalBooks++;
    }

    public static void welcomeMessage(){
        System.out.println("\nWelcome to Rodenas BSCS251B LRC System");
        System.out.println("--------------------------------------");
    }

    //Borrow Method
    public void borrowBook() {
        if(bookId == 0 || title.equals("Unknown") || pages == 0){
            System.out.println("Book information is incomplete. Cannot borrow.");
            return;
        }
        if (!isBorrowed) {
            isBorrowed = true;
            totalBorrowedBooks++;
            System.out.println("The book \"" + title + "\" has been borrowed from the LRC.");
        } else {
            System.out.println("This book is already borrowed.");
        }
    }

    //Return Method
    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            totalBorrowedBooks--;
            System.out.println("The book \"" + title + "\" has been returned to the LRC.");
        } else {
            System.out.println("This book is already available.");
        }
    }

    //Setters with Validation
    public void setBookId(int bookId) {
        if (bookId > 0) {
            this.bookId = bookId;
            System.out.println("Book ID successfully set.");
        } else {
            System.out.println("Book ID must be greater than 0.");
        }
    }

    public void setTitle(String title) {
        if (title != null && !title.isEmpty()) {
            this.title = title;
            System.out.println("Title successfully set.");
        } else {
            System.out.println("Title cannot be empty.");
        }
    }

    public void setPages(int pages) {
        if (pages > 0) {
            this.pages = pages;
            System.out.println("Pages successfully set.");
        } else {
            System.out.println("Pages must be greater than 0.");
        }
    }

    //Getter for Borrow Status
    public boolean isBookBorrowed(){
        return isBorrowed;
    }

    //Getter for Book Details
    public void getBookDetails() {
        System.out.println("\nBook Details:");
        System.out.println("Title: " + title);
        System.out.println("Book ID: " + bookId);
        System.out.println("Pages: " + pages);
        System.out.println("Status: " + (isBorrowed ? "Borrowed" : "Available"));
    }

    //Static Getters
    public static void getTotalBooks() {
        System.out.println("\nTotal books in LRC: " + totalBooks);
    }

    public static void getTotalBorrowedBooks() {
        System.out.println("Total borrowed books: " + totalBorrowedBooks);
    }
}
