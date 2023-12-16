package LMS.Utils;

import java.util.Scanner;

public class ReturnBook{

    Account currentUserAccount;
    Scanner scan;

    ReturnBook(Account account){
        this.currentUserAccount = account;
        this.scan = new Scanner(System.in);
    }

    // Check if the person already registered.
    void checkUserExist(){

    }
}
