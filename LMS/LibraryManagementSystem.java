package LMS;

import LMS.Utils.Account;
import LMS.Utils.IssueBook;
import LMS.Utils.ReturnBook;
import LMS.Utils.StudentData.*;
import LMS.LibraryExceptions.AuthenticationFailed;

import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Account currentUser = null;

        while (true) {
            System.out.println("Library Management System Menu:");
            System.out.println("1. Login");
            System.out.println("2. Create an Account");
            System.out.println("3. Enter the Book");
            System.out.println("4. Return the Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    try {
                        currentUser = login();
                    } catch (AuthenticationFailed e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    createAccount();
                    break;
                case 3:
                    if (currentUser != null) {
                        enterBook(currentUser);
                    } else {
                        System.out.println("Please login first.");
                    }
                    break;
                case 4:
                    if (currentUser != null) {
                        returnBook(currentUser);
                    } else {
                        System.out.println("Please login first.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting the Library Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static Account login() throws AuthenticationFailed {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Roll No: ");
        String rollNo = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        return new Account(rollNo, password);
    }

    private static void createAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Roll No: ");
        String rollNo = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        Account newAccount = new Account(rollNo, name, password);
        System.out.println("Account created successfully!");
    }

    private static void enterBook(Account currentUser) {

        Scanner scanner = new Scanner(System.in);

        try {
            IssueBook issueBook = new IssueBook(currentUser);
            issueBook.displayBooks();
            issueBook.checkUserExist();
            System.out.print("Enter the index of the book to issue: ");
            int bookIndexToIssue = scanner.nextInt();
            issueBook.createTransaction(bookIndexToIssue - 1); // Adjust index to 0-based
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void returnBook(Account currentUser) {
        try {
            ReturnBook returnBook = new ReturnBook(currentUser);
            returnBook.checkUserExist();
            returnBook.checkDue();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}