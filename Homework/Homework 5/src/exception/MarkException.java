package exception;

public class MarkException extends Exception{
    private float mark;

    public MarkException(float mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Mark can't be negative: " + mark;
    }
}
