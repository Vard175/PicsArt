package exceptions;

public class DoctorException extends RuntimeException {
    @Override
    public String toString() {
        return "There is no doctor with chosen speciality.";
    }
}
