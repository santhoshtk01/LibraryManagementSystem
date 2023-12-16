package LMS.LibraryExceptions;

public class AuthenticationFailed extends Exception{
    public AuthenticationFailed(String message){
        super(message);
    }
}
