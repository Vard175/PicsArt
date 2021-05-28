package exceptions.user;

public class UserUsernameException extends RuntimeException{
    private String username;

    public UserUsernameException(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Username should be unique and have at least 11 symbols: " + username;
    }
}
