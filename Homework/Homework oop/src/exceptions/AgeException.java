package exceptions;
//TODO: join all exceptions in one HospitalException class
public class AgeException extends RuntimeException {
    private int age;

    public AgeException(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Age can't be negative: " + age;
    }
}
