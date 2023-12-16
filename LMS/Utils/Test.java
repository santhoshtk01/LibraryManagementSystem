package LMS.Utils;

import LMS.Utils.StudentsData;

public class Test{
    public static void main(String[] args) throws Exception {
        StudentsData sd = new StudentsData();
        System.out.println(sd.checkRollNoExist("22Z433"));
        Account account = new Account("22z433", "22z433");
        IssueBook ib = new IssueBook(account);
        ib.displayBooks();
        ib.createTransaction(5);
    }
}
