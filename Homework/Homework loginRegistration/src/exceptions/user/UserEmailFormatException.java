package exceptions.user;

public class UserEmailFormatException extends RuntimeException {
    @Override
    public String toString() {
        return "The format of an email address is local-part@domain.";
    }
}
