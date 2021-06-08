package services;

import exceptions.user.NoSuchUserException;
import models.User;

import java.util.Scanner;

public class LoginService {
    public static void logIn(Scanner s,String path){
        System.out.println("Enter your username");
        String username=s.next();
        System.out.println("Enter your password");
        String password=RegistrationService.MD5(s.next());

        if(User.usernamePassword.containsKey(username) && User.usernamePassword.get(username).equals(password)){
            System.out.println("Login success");
        }
        else
            throw new NoSuchUserException();
    }
}
