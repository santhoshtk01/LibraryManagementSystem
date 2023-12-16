package LMS.Utils;

import LMS.Books.Book;
import LMS.Utils.UserAuthentication;
import LMS.Utils.Librarian;
import LMS.Utils.StudentsData;
import LMS.LibraryExceptions.AuthenticationFailed;

import java.util.Scanner;
import java.io.*;  //this is added

public class IssueBook extends Librarian implements UserAuthentication{

    //constructor added
    public Book[] getBooks() {
        return this.book;
    }
    
    // Indicate the current user account who is using the system. 
    Account currentUserAccount;
    Scanner scan = new Scanner(System.in);
    boolean userAuthenticated;
//this is the change 
    IssueBook(Account account){
        this.currentUserAccount = account;
        this.addBookItem();
    }

    // Display the available books to the user.
    void displayBooks(){
        for(int i = 0; i < 15; i++){
            if(bookCounts[i] != 0) {
                System.out.println((i + 1) + " : " + this.book[i].getTitle());
            }
        }
    }

    void createTransaction(int index) throws Exception{
        /*
        * param: index - indicates which book is chosen by the user.
        * */
        if(this.userAuthenticated){
            Book chosen = this.book[index];
            //  Added the transaction to a text file.
            String transaction = "Book title: " + chosen.getTitle() + "\n" + "Due date : " + this.dueDate + "\n" + "User : " + currentUserAccount.rollNo;
            System.out.println(transaction);
             writeTransactionToFile(transaction);
        }
        else{
            throw new AuthenticationFailed("Authentication failed.");
        }

    }
     private void writeTransactionToFile(String transaction) {
        String fileName = "transactions.txt";

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(transaction + "\n\n");
            System.out.println("Transaction recorded in " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
    @Override
    public void checkUserExist() {

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
}
