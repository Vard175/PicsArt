package services;

import models.hospitalStaffModels.doctorModels.Cardiologist;
import models.hospitalStaffModels.serviceStaffModels.Orderly;
import models.patientModels.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderlyService {
    public static void workWithOrderlies(Scanner s, String path, ArrayList<Orderly> orderlies) {
        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println("Enter command number");
            System.out.println("1. Add orderly");
            System.out.println("2. Print names of all female orderlies");
            System.out.println("3. Work with specific orderly");
            System.out.println("4. Exit");

            int command = s.nextInt();
            switch (command) {
                case 1:
                    getManualInput(s, path, orderlies);
                    break;
                case 2:
                    FileService.write(path, "\n\n3. Print names of all female orderlies");
                    printAllFemaleOrderliesNames(path, orderlies);
                    break;
                case 3:
                    System.out.println("Enter name of the orderly you want to work with");
                    for (Orderly o:orderlies) {
                        System.out.printf("\t"+o.getName());
                    }
                    String name = s.next();
                    boolean isGivenNameExist = false;
                    for (Orderly orderly : orderlies) {
                        if (orderly.getName().equals(name)) {
                            isGivenNameExist = true;
                            workWithOneOrderly(s, path, orderly);
                            break;
                        }
                    }
                    if (!isGivenNameExist)
                        FileService.write(path, "\n" + "There is no orderly with given name.");
                    break;
                case 4:
                    isMenuActive = false;
                    System.out.println("--------------------------------\n*Going back to the last menu*");
                    break;
                default:
                    System.out.println("Invalid command number");
            }
        }
    }

    public static void getManualInput(Scanner s, String path, ArrayList<Orderly> orderlies) {
        StringBuilder sb = new StringBuilder();
        System.out.println("Enter name of the orderly");
        sb.append(s.next());
        sb.append(",");
        System.out.println("Enter surname of the orderly");
        sb.append(s.next());
        sb.append(",");
        System.out.println("Enter orderly's age");
        sb.append(s.next());
        sb.append(",");
        System.out.println("Enter orderly's gender (m/f)");
        sb.append(s.next().toLowerCase().charAt(0));
        sb.append(",");
        System.out.println("Enter orderly's salary");
        sb.append(s.next());

        createOrderly(sb.toString(), path, orderlies);
    }

    public static void createOrderly(String information, String path, ArrayList<Orderly> orderlies) {
        String[] info = information.split(",");
        Orderly orderly = new Orderly(info[0], info[1], Integer.parseInt(info[2]), info[3].charAt(0));
        orderly.setSalary(Integer.parseInt(info[4]));
        orderlies.add(orderly);

        orderly.printInfo(path);
    }

    public static void workWithOneOrderly(Scanner s, String path, Orderly orderly) {
        FileService.write(path, "\n\nNow we are working with" + orderly.getName());

        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println("Enter command number");
            System.out.println("1. Print orderly's info");
            System.out.println("2. Make orderly interact with doctor");
            System.out.println("3. Make orderly interact with patient");
            System.out.println("4. Exit");

            int command = s.nextInt();
            switch (command) {
                case 1:
                    orderly.printInfo(path);
                    break;
                case 2:
                    orderly.interact(path, new Cardiologist());
                    break;
                case 3:
                    orderly.interact(path, new Patient());
                    break;
                case 4:
                    isMenuActive = false;
                    System.out.println("--------------------------------\n*Going back to the last menu*");
                    break;
                default:
                    System.out.println("Invalid command number");
            }
        }
    }

    public static void printAllFemaleOrderliesNames(String path, ArrayList<Orderly> orderlies) {
        for (Orderly o : orderlies) {
            if (o.getGender() == 'f')
                FileService.write(path, "\n" + o.getName());
        }
    }
}
