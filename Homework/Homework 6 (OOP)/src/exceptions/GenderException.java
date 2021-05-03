package exceptions;

public class GenderException extends RuntimeException {
    @Override
    public String toString() {
        return "Gender should be either male or female.";
    }
}
