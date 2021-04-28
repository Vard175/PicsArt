package exception;

public class YearException extends RuntimeException {
    private int year;

    public YearException(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Year can't be negative: " + year;
    }
}
