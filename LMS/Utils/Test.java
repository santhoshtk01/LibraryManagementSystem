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
        ib.createTransaction(3);

        ReturnBook rb = new ReturnBook(acc);
        rb.checkUserExist();
    }
}
