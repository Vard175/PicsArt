package exceptions;

public class LastNameException extends RuntimeException{
    @Override
    public String toString() {
        return "Last name should start with uppercase and continue with lowers.";
    }
}
