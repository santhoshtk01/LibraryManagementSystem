package LMS.Utils;

import LMS.Books.Book;
import LMS.Utils.UserAuthentication;
import LMS.Utils.Librarian;
import LMS.Utils.StudentsData;
import LMS.LibraryExceptions.AuthenticationFailed;

import java.util.Scanner;

public class IssueBook extends Librarian implements UserAuthentication{

    // Indicate the current user account who is using the system.
    Account currentUserAccount;
    Scanner scan;
    boolean userAuthenticated;

    IssueBook(Account account){
        this.currentUserAccount = account;
        this.addBookItem();
    }

    // Display the available books to the user.
    void displayBooks(){
        for(int i = 0; i < 15; i++){
            if(bookCounts[i] == 0) {
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
            String transaction = "Book title: " + chosen.getTitle() + "\n" + "Due date : " + this.dueDate + "\n" + "User : " + currentUserAccount.rollNo;
            System.out.println(transaction);
        }
        else{
            throw new AuthenticationFailed("Authentication failed.");
        }

    }

    @Override
    public void checkUserExist() {
        System.out.println("Enter your Roll No: ");
        String rollNo = this.scan.nextLine();
        StudentsData sd = new StudentsData();

        try{
            sd.checkRollNoExist(rollNo);
            this.userAuthenticated = true;
        }
        catch(Exception e){
            this.userAuthenticated = false;
            System.out.println("The entered roll no doesn't exist. Kindly make a registration.");
        }
    }
}
