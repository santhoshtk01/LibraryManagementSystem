package LMS.Utils;

import LMS.LibraryExceptions.WrongOldPasswordException;
import java.util.Objects;

public class Account {

    String rollNo;
    String password;
    String name;
    boolean AccountStatus;

    // Constructor for login into the account.
    public Account(String rollNo, String password){
        this.rollNo = rollNo;
        this.password = password;
        this.AccountStatus = true;
    }

    // Constructor for new user registration
    public Account(String rollNo, String name, String password){
        this.rollNo = rollNo;
        this.name = name;
        this.password = password;
        this.AccountStatus = true;
    }

    void resetPassword(String oldPassword, String newPassword) throws Exception{
        /*
        * Receives the old password and new password. Check the old password against the
        * password and update accordingly. Otherwise, throws and `WrongOldPasswordException`.
        * */
        if(Objects.equals(oldPassword, this.password)) {
            this.password = newPassword;
        }
        else{
            throw new WrongOldPasswordException("Wrong old password");
        }
    }

    // Add the new user data into the file.
    private void addUserData(){
        String newUser = this.rollNo + "," + this.name + "," + this.password + "," + this.AccountStatus;
    }

    // Fetch the login user details.
    private void fetchData(){}
}
