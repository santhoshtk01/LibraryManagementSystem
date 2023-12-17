package LMS.Utils;

import java.util.Scanner;
import LMS.Utils.StudentsData;
import LMS.Utils.UserAuthentication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class ReturnBook extends Librarian implements UserAuthentication{

    private Scanner scan;
    private boolean userAuthenticated;
    private boolean isBookOverdue;
    private Account currentUserAccount;


    ReturnBook(Account account){
        super();
        this.currentUserAccount = account;
        this.scan = new Scanner(System.in);
        this.isBookOverdue = false; // Initialize to false
    }

    // Check if the person already registered.
    @Override
    void checkDue(String userRollNo) {
        if (userAuthenticated) {
            System.out.print("Enter the book ISBN to check for due date: ");
            String isbn = scan.nextLine();

            // Search for the book in the transactions file using the user's roll number
            String transactionFileName = "transactions.txt";
            String dueDateFromTransaction = findDueDateInTransaction(isbn, userRollNo, transactionFileName);

            if (dueDateFromTransaction != null) {
                LocalDate currentDate = LocalDate.now();
                LocalDate dueDate = LocalDate.parse(dueDateFromTransaction, DateTimeFormatter.ofPattern("Due date : dd-MM-yyyy"));

                // Check if the book is overdue
                if (currentDate.isAfter(dueDate)) {
                    int daysOverdue = (int) ChronoUnit.DAYS.between(dueDate, currentDate);
                    double fine = calculateFine(daysOverdue);

                    System.out.println("The book is overdue by " + daysOverdue + " days.");
                    System.out.println("Fine to be paid: $" + fine);

                    isBookOverdue = true; // Set the variable to true
                } else {
                    System.out.println("The book is not overdue.");
                    isBookOverdue = false; // Set the variable to false
                }
            } else {
                System.out.println("Book not found in the transactions records.");
                isBookOverdue = false; // Set the variable to false
            }
        } else {
            System.out.println("User authentication failed.");
            isBookOverdue = false; // Set the variable to false
        }
    }

    private String findDueDateInTransaction(String isbn, String userRollNo, String transactionFileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(transactionFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Book title: " + isbn) && line.contains("User : " + userRollNo)) {
                    // Extract due date from the line
                    int startIndex = line.indexOf("Due date : ") + 12;
                    int endIndex = line.indexOf("\n", startIndex);
                    return line.substring(startIndex, endIndex);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the transactions file: " + e.getMessage());
        }
        return null;
    }

    boolean getIsBookOverdue() {
        return isBookOverdue;
    }

    @Override
    public void checkUserExist() {
        // Implement the checkUserExist method as needed
        // This method is required by the UserAuthentication interface
        StudentsData sd = new StudentsData();

        try {
            sd.checkRollNoExist(this.currentUserAccount.rollNo);
            this.userAuthenticated = true;
        } catch (Exception e) {
            this.userAuthenticated = false;
            System.out.println("The entered roll no doesn't exist. Kindly make a registration.");
        }
    }

    // Implement the calculateFine method
    private double calculateFine(int daysOverdue) {
        // Assuming a flat fine rate for overdue books (you can adjust this as needed)
        double fineRate = 2.0; // $2 per day
        return fineRate * daysOverdue;
    }
}
