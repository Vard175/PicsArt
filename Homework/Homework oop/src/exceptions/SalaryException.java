package exceptions;

public class SalaryException extends RuntimeException{

    private int salary;

    public SalaryException(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Salary can't be negative: "+salary;
    }
}
