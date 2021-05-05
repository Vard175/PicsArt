package main;

import java.util.Scanner;

public class StaffPatientTest {

    public static void main(String[] args) {
        //TODO: if you want to work with doctors ...es kgna service wum ksharunaki

        Scanner s = new Scanner(System.in);
        s.useDelimiter("\n");

        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println("Enter command number");
            System.out.println("1. Work with doctors");
            System.out.println("2. Work with laboratory workers");
            System.out.println("3. Work with orderlies");
            System.out.println("4. Work with patients");
            System.out.println("5. Exit");

            int command = s.nextInt();
            switch (command) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    isMenuActive = false;
                    System.out.println("Chao");
                    break;
                default:
                    System.out.println("Invalid command number");
            }
        }
    }

}
