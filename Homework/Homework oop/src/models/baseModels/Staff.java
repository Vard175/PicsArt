package models.baseModels;

import exceptions.SalaryException;
import models.baseModels.Human;
import services.FileService;

public abstract class Staff extends Human {

    private int salary;

    @Override
    public void printInfo(String path) {
        super.printInfo(path);
        FileService.write(path, "\n Salary: " + getSalary());
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if(salary<0)
            throw  new SalaryException(salary);
        this.salary = salary;
    }

    public Staff(String name, String surname, int age,char gender) {
        super(name, surname, age,gender);
    }

    //TODO: check modifier after packaging
    public abstract void getPromoted();
}
