package exceptions;

public class FirstNameException extends RuntimeException {
    @Override
    public String toString() {
        return "First name should start with uppercase and continue with lowers.";
    }
}
