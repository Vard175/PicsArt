package exceptions.user;

public class NoSuchUserException extends RuntimeException{
    @Override
    public String toString() {
        return "Incorrect username or password.";
    }
}
