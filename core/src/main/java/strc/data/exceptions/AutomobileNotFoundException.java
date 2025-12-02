package strc.data.exceptions;

public class AutomobileNotFoundException extends RuntimeException{
    public AutomobileNotFoundException(String msg){
        System.out.println("Error: " + msg);
    }
}
