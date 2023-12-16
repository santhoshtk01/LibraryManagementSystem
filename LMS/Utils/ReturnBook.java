package LMS.Utils;

import java.util.Scanner;
import LMS.Utils.StudentsData;
import LMS.Utils.UserAuthentication;

public class ReturnBook extends Librarian implements UserAuthentication{

    Account currentUserAccount;
    Scanner scan;
    boolean userAuthenticated;

    ReturnBook(Account account){
        this.currentUserAccount = account;
        this.scan = new Scanner(System.in);
    }

    // Check if the person already registered.
    @Override
    public void checkUserExist(){
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
