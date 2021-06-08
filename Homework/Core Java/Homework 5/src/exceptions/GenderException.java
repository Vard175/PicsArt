package exceptions;

public class GenderException extends RuntimeException{
    @Override
    public String toString() {
        return "Gender should be male or female ,cause we are in Armenia :D ";
    }
}
