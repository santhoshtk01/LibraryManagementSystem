package LMS.Utils;

import java.util.Scanner;
import LMS.Utils.StudentsData;
import LMS.Utils.UserAuthentication;

import LMS.Books.Book;   //  added

public class ReturnBook extends Librarian implements UserAuthentication{

    Account currentUserAccount;
    Scanner scan;
    boolean userAuthenticated;
    // added
    private boolean isBookOverdue;
    private double fine;
    private int daysOverdue;
    /*private String dueDate;*/


    ReturnBook(Account account){
        this.currentUserAccount = account;
        this.scan = new Scanner(System.in);
        this.isBookOverdue = false;           // Initialize to false 
    }

    // Check if the person already registered.
    @Override
    public void checkUserExist(){

        StudentsData sd = new StudentsData();

        try{
            sd.checkRollNoExist(this.currentUserAccount.rollNo);
            this.userAuthenticated = true;
        }
        catch(Exception e){
            this.userAuthenticated = false;
            System.out.println("The entered roll no doesn't exist. Kindly make a registration.");
        }
    }

    int calculateFine(int overdueDays) {
        return overdueDays + 1;
    }

    void checkDue(String issueDate, Book[] books) {
        if (userAuthenticated) {
            System.out.print("Enter the book ISBN to check for due date: ");
            String isbn = scan.nextLine();

            // Search for the book in the book array
            Book selectedBook = null;
            for (Book b : books) {
                if (b.getIsbn().equals(isbn)) {
                    selectedBook = b;
                    break;
                }
            }

            if (selectedBook != null) {
                LocalDate currentDate = LocalDate.now();
                LocalDate dueDate = LocalDate.parse(issueDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                        .plusDays(15); // Assuming a 15-day borrowing period

                // Check if the book is overdue
                if (currentDate.isAfter(dueDate)) {
                    daysOverdue = (int) ChronoUnit.DAYS.between(dueDate, currentDate);
                    fine = calculateFine(daysOverdue);

                    System.out.println("The book is overdue by " + daysOverdue + " days.");
                    System.out.println("Fine to be paid: $" + fine);

                    isBookOverdue = true; // Set the variable to true
                } else {
                    System.out.println("The book is not overdue.");
                    isBookOverdue = false; // Set the variable to false
                }
            } else {
                System.out.println("Book not found in the library records.");
                isBookOverdue = false; // Set the variable to false
            }
        } else {
            System.out.println("User authentication failed.");
            isBookOverdue = false; // Set the variable to false
        }
    }

    boolean getIsBookOverdue() {
        return isBookOverdue;
    }
}
