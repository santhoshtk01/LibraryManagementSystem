package LMS.Utils;

import LMS.Books.Book;

public class IssueBook extends Librarian{

    // Indicate the current user account who is using the system.
    Account currentUserAccount;

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

    void createTransaction(int index){
        /*
        * param: index - indicates which book is chosen by the user.
        * */
        Book chosen = this.book[index];
        String transaction = "Book title: " + chosen.getTitle() + "\n" + "Due date : " + this.dueDate + "\n" + "User : " + currentUserAccount.rollNo;
        System.out.println(transaction);
    }
}
