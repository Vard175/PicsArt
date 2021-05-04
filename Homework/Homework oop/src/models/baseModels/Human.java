package models.baseModels;

import exceptions.*;
import services.FileService;
//TODO: question: where to write constructors getters setters functions..any better practices ?
public abstract class Human {
    private String name;
    private String surname;
    private int age;
    private char gender;

    //TODO: delete this method
    public abstract void complain();

    //TODO: doctor to doctor ... adn so on (with overloads)
 //   public abstract void interact(Human human);

    public void printInfo(String path) {
           FileService.write(path, "\n------------------");
            FileService.write(path, "\n Name: " + getName());
            FileService.write(path, "\n Surname: " + getSurname());
            FileService.write(path, "\n Age: " + getAge());
            String gen = getGender() == 'm' ? "male" : "female";
            FileService.write(path, "\n Gender: " + gen);
            FileService.write(path, "\n------------------");
    }

    public Human(String name, String surname, int age,char gender) {
        setName(name);
        setSurname(surname);
        setAge(age);
        setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.matches("[A-Z][a-z]+"))
            throw new NameException();
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (!surname.matches("[A-Z][a-z]+"))
            throw new SurnameException();
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0)
            throw new AgeException(age);
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        if (gender != 'm' && gender != 'f')
            throw new GenderException();
        this.gender = gender;
    }
}
