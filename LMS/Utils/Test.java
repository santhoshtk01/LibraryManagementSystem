package LMS.Utils;

import LMS.Utils.StudentsData;
import LMS.Utils.IssueBook;
import LMS.Utils.Account;

public class Test{
    public static void main(String[] args) throws Exception {
        Account acc = new Account("22Z433", "22Z433");

        IssueBook ib = new IssueBook(acc);
        ib.displayBooks();
        ib.checkUserExist();
       // Assuming you want to issue the book at index 3
        int bookIndexToIssue = 3;
        ib.createTransaction(bookIndexToIssue);

        // Now let's create an instance of ReturnBook
        ReturnBook rb = new ReturnBook(acc);
        rb.checkUserExist();

        // Check due date and print book information
        rb.checkDue(); // Pass the user roll number only
    }
}
