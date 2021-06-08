package exceptions;

public class HumanException extends RuntimeException {
    //private final String message;

    public HumanException(String message) {
        super(message);
        //  this.message = message; You can do this if you need to do additional operations with message
    }
}