package exceptions;

public class AddressException extends RuntimeException{
    @Override
    public String toString() {
        return "Invalid address format. Address should be in country/city/Street format.";
    }
}
