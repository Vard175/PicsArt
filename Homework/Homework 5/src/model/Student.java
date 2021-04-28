package model;

import exception.*;
import service.FileService;

public class Student {
    private String firstName;
    private String lastName;
    private int year;
    private char gender;
    private float mark;

    public Student(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(!firstName.matches("[A-Z][a-z]+"))
            throw new FirstNameException();
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(!lastName.matches("[A-Z][a-z]+"))
            throw new LastNameException();
        this.lastName = lastName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year<0){
            throw new YearException(year);
        }
        this.year = year;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        if(gender!='m' && gender!='f')
            throw new GenderException();
        this.gender = gender;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) throws MarkException{
        if(mark<0)
            throw new MarkException(mark);
        this.mark = mark;
    }

    public void printInfo(String path){
        FileService.write(path,"------------------");
        FileService.write(path,"\n First name: "+ getFirstName());
        FileService.write(path,"\nLast name: "+ getLastName());
        FileService.write(path,"\nYear: "+ getYear());
        String gen=getGender()=='m'?"male":"female";
        FileService.write(path,"\nGender: "+ gen);
        FileService.write(path,"\nMark: "+ getMark());
        FileService.write(path,"\n------------------");
    }
}
