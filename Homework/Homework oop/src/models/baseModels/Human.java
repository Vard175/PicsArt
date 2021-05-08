package models.baseModels;

import exceptions.*;
import services.FileService;

public abstract class Human implements Comparable<Human> {
    private String name;
    private String surname;
    private int age;
    private char gender;

    public abstract void interact(String path, Human human);

    public void printInfo(String path) {
        FileService.write(path, "\n------------------");
        FileService.write(path, "\n Name: " + getName());
        FileService.write(path, "\n Surname: " + getSurname());
        FileService.write(path, "\n Age: " + getAge());
        String gen = getGender() == 'm' ? "male" : "female";
        FileService.write(path, "\n Gender: " + gen);
    }

    public Human(String name, String surname, int age, char gender) {
        setName(name);
        setSurname(surname);
        setAge(age);
        setGender(gender);
    }
    public Human(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.matches("[A-Z][a-z]+"))
            throw new HumanException("Name should start with uppercase and continue with lowers.");
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (!surname.matches("[A-Z][a-z]+"))
            throw new HumanException("Surname should start with uppercase and continue with lowers.");
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0)
            throw new HumanException("Age can't be negative.");
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        String g= String.valueOf(gender).toLowerCase();
        if (!(g.equals("m")  || g.equals("f")))
            throw new HumanException("Gender should be male or female.");
        this.gender = g.charAt(0);
    }

    @Override
    public int compareTo(Human o) {
        return this.getAge() - o.getAge();
    }
}
