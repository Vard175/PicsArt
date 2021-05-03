package exceptions;

public class NameException extends RuntimeException{
    @Override
    public String toString() {
        return "Name should start with uppercase and continue with lowers.";
    }
}
