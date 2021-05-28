package models;

import exceptions.user.UserEmailFormatException;
import exceptions.user.UserFullNameException;
import exceptions.user.UserPasswordException;
import exceptions.user.UserUsernameException;
import services.RegistrationService;

import java.util.HashMap;

public class User {
    private String fullName;
    private String username;
    private String email;
    private String password;

   public static HashMap<String,String> usernamePassword=new HashMap<>();

    public User(String username, String password) {
        setUsername(username);
        setPassword(password);
        usernamePassword.put(getUsername(), getPassword());
    }

    public String getFullNameName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        String[] nameSurname = fullName.split(" ");
        if (!nameSurname[0].matches("[A-Z][a-z]+") || !nameSurname[1].matches("[A-Z][a-z]+"))
            throw new UserFullNameException(fullName);
        else
            this.fullName = fullName;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username.length() < 11 || usernamePassword.containsKey(username))
            throw new UserUsernameException(username);
        else
            this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        if (!email.trim().matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))
            throw new UserEmailFormatException();
        else
            this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        int upperCount = 0;
        int numberCount = 0;

        if (password.length() < 9)
            throw new UserPasswordException();

        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                numberCount++;
                continue;
            }
            if (Character.isUpperCase(password.charAt(i))) {
                upperCount++;
            }
        }

        if (numberCount <3 && upperCount <2)
            throw new UserPasswordException();
        else
            this.password = RegistrationService.MD5(password);
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(getFullNameName())
                .append(",")
                .append(getUsername())
                .append(",")
                .append(getEmail())
                .append(",")
                .append(getPassword())
                .append("\n");
        return sb.toString();
    }
}
