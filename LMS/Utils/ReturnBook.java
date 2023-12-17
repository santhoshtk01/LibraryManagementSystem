package LMS.Utils;

import java.util.Scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import LMS.LibraryExceptions.RollNoNotExistException;


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
    void checkDue(){
        if (userAuthenticated) {

            // Search for the book in the transactions file using the user's roll number
            String transactionFileName = "transactions.txt";

            // Finding the due date in the transaction
            String dueDateFromTransaction = null;
            try {
                dueDateFromTransaction = findDueDateInTransaction(this.currentUserAccount.rollNo, transactionFileName);
            } catch (Exception rnnee) {
                System.out.println(rnnee);
            }

            if (dueDateFromTransaction != null) {
                LocalDate currentDate = LocalDate.now();
                LocalDate dueDate = LocalDate.parse(dueDateFromTransaction, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

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

    private String findDueDateInTransaction(String userRollNo, String transactionFileName) throws Exception{
        try (BufferedReader reader = new BufferedReader(new FileReader(transactionFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Check if the line contains "rollNo"
                if (line.contains("22Z433")) {
                    // Extract date using regex
                    String date = extractDate(line);

                    return date;
                } else {
                        throw new RollNoNotExistException("Roll number doesn't exist.");
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

    // Method to extract date using regex
    private static String extractDate(String line) {
        // Define a regex pattern for extracting date
        String regex = "\\b\\d{2}-\\d{2}-\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        // Find the date in the line
        if (matcher.find()) {
            return matcher.group();
        } else {
            return "Date not found";
        }
    }
}
