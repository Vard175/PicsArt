package exceptions.user;

public class UserPasswordException extends RuntimeException{
    @Override
    public String toString() {
        return "Password should consist of at least 9 symbols including 2 uppercase letters and 3 numbers";
    }
}
