package services;

import models.hospitalStaffModels.doctorModels.Cardiologist;
import models.hospitalStaffModels.serviceStaffModels.LaboratoryWorker;
import models.hospitalStaffModels.serviceStaffModels.Orderly;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LaboratoryWorkerService {

    public static void workWithLabWorkers(Scanner s, String path, ArrayList<LaboratoryWorker> labWorkers) {
        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println("Enter command number");
            System.out.println("1. Add laboratory worker(manual input)");
            System.out.println("2. Add laboratory worker(automated input)");
            System.out.println("3. Print names of all male laboratory workers");
            System.out.println("4. Work with specific laboratory worker");
            System.out.println("5. Exit");

            int command = s.nextInt();
            switch (command) {
                case 1:
                    getManualInput(s, path, labWorkers);
                    break;
                case 2:
                    getAutomateInput(path, labWorkers);
                    break;
                case 3:
                    FileService.write(path, "\n\n3. Print names of all male laboratory workers");
                    printAllMaleLabWorkersNames(path, labWorkers);
                    break;
                case 4:
                    System.out.println("Enter name of the laboratory worker you want to work with");
                    for (LaboratoryWorker lb : labWorkers) {
                        System.out.printf("\t" + lb.getName());
                    }
                    String name = s.next();
                    boolean isGivenNameExist = false;
                    for (LaboratoryWorker lb : labWorkers) {
                        if (lb.getName().equals(name)) {
                            isGivenNameExist = true;
                            workWithOneLabWorker(s, path, lb);
                            break;
                        }
                    }
                    if (!isGivenNameExist)
                        FileService.write(path, "\n" + "There is no laboratory worker with given name.");
                    break;
                case 5:
                    isMenuActive = false;
                    System.out.println("--------------------------------\n*Going back to the last menu*");
                    break;
                default:
                    System.out.println("Invalid command number");
            }
        }
    }

    public static void getManualInput(Scanner s, String path, ArrayList<LaboratoryWorker> laboratoryWorkers) {
        StringBuilder sb = new StringBuilder();
        System.out.println("Enter name of the laboratory worker");
        sb.append(s.next());
        sb.append(",");
        System.out.println("Enter surname of the laboratory worker");
        sb.append(s.next());
        sb.append(",");
        System.out.println("Enter laboratory worker's age");
        sb.append(s.next());
        sb.append(",");
        System.out.println("Enter laboratory worker's gender (m/f)");
        sb.append(s.next().toLowerCase().charAt(0));
        sb.append(",");
        System.out.println("Enter laboratory worker's salary");
        sb.append(s.next());


        createLabWorker(sb.toString(), path, laboratoryWorkers);
    }

    public static void getAutomateInput(String path, ArrayList<LaboratoryWorker> laboratoryWorkers) {
        String inputPath = "src//inputFiles//labWorkerInput.txt//";
        List<String> input = null;
        try {
            input = FileService.read(inputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String labWorkerInfo : input) {
            createLabWorker(labWorkerInfo, path, laboratoryWorkers);
        }
    }

    public static void createLabWorker(String information, String path, ArrayList<LaboratoryWorker> laboratoryWorkers) {
        String[] info = information.split(",");
        LaboratoryWorker labWorker = new LaboratoryWorker(info[0], info[1], Integer.parseInt(info[2]), info[3].charAt(0));
        labWorker.setSalary(Integer.parseInt(info[4]));
        laboratoryWorkers.add(labWorker);

        labWorker.printInfo(path);
    }

    public static void workWithOneLabWorker(Scanner s, String path, LaboratoryWorker laboratoryWorker) {
        FileService.write(path, "\n\nNow we are working with" + laboratoryWorker.getName());

        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println("Enter command number");
            System.out.println("1. Print laboratory worker's info");
            System.out.println("2. Test blood");
            System.out.println("3. Give laboratory worker a promotion");
            System.out.println("4. Make laboratory worker interact with doctor");
            System.out.println("5. Make laboratory worker interact with orderly");
            System.out.println("6. Exit");

            int command = s.nextInt();
            switch (command) {
                case 1:
                    laboratoryWorker.printInfo(path);
                    break;
                case 2:
                    FileService.write(path, laboratoryWorker.testBlood());
                    break;
                case 3:
                    laboratoryWorker.getPromoted(path);
                    break;
                case 4:
                    laboratoryWorker.interact(path, new Cardiologist());
                    break;
                case 5:
                    laboratoryWorker.interact(path, new Orderly());
                    break;
                case 6:
                    isMenuActive = false;
                    System.out.println("--------------------------------\n*Going back to the last menu*");
                    break;
                default:
                    System.out.println("Invalid command number");
            }
        }
    }

    public static void printAllMaleLabWorkersNames(String path, ArrayList<LaboratoryWorker> labWorkers) {
        for (LaboratoryWorker lb : labWorkers) {
            if (lb.getGender() == 'm') {
                FileService.write(path, "\n" + lb.getName());
            }
        }
    }
}
