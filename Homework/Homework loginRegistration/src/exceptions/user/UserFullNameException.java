package exceptions.user;

public class UserFullNameException extends RuntimeException{

    private String nameOrSurname;

    public UserFullNameException(String nameOrSurname) {
        this.nameOrSurname = nameOrSurname;
    }

    @Override
    public String toString() {
        return "Both name and surname should start with uppercase and continue with lowers: "+nameOrSurname ;
    }
}
