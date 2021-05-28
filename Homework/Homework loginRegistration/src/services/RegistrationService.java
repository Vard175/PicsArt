package services;

import models.User;

import java.io.IOException;
import java.util.Scanner;

public class RegistrationService {

    public static void register(Scanner s, String path) {

        System.out.println("Enter full name(format: Name Surname)");
        String fullName=s.next();
        System.out.println("Enter username (at least 11 symbols)");
        String username=s.next();
        System.out.println("Enter email (format: local-part@domain)");
        String email=s.next();
        System.out.println("Enter password (at least 9 symbols including 2 uppercase letters and 3 numbers)");
        String password=s.next();

        try {
            User.usernamePassword.putAll(FileService.read(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        User user=new User(username,password);
        user.setFullName(fullName);
        user.setEmail(email);
        FileService.write(path,user.toString());
    }

    public static String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
}
