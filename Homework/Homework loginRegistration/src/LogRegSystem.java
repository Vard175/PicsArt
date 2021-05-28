import services.LoginService;
import services.RegistrationService;

import java.util.Scanner;

public class LogRegSystem {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");

        String path="src//databases//UserInfo.txt";

        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println("Enter command number");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");

            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    LoginService.logIn(scanner,path);
                    break;
                case 2:
                    RegistrationService.register(scanner,path);
                    break;
                case 3:
                    isMenuActive = false;
                    System.out.println("Chao");
                    break;
                default:
                    System.out.println("Invalid command number");
            }
        }
    }
}
