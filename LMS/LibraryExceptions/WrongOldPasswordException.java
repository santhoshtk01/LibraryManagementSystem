package LMS.LibraryExceptions;

public class WrongOldPasswordException extends Exception{

    public WrongOldPasswordException(String message){
        super(message);
    }
}
