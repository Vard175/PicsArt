package models.humanModels;

import exceptions.*;

public abstract class Human {
    private String name;
    private String surname;
    private int age;
    private char gender;
    private String address;
    private boolean isWorking;

    public abstract void talk();

    public Human(String name, String surname, int age) {
        setName(name);
        setSurname(surname);
        setAge(age);
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
        if(age<0)
            throw new AgeException(age);
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        if(gender!='m' || gender!='f')
            throw new GenderException();
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) { //armenia yerevan street
        String[] adr=address.split(",");
        if(adr.length!=3){
            throw new AddressException();
        }
        for (int i = 0; i < adr.length-1; i++) {
            if(!(adr[i].matches("[A-Z][a-z]+") || adr[i].matches("[a-z]+")))
                throw new AddressException();
        }
        this.address = address;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }
}
