package exceptions;

public class GenderException extends RuntimeException {
    @Override
    public String toString() {
        return "Invalid gender.Gender should be male or female";
    }
}
