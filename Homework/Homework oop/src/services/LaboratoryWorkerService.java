package services;

import models.hospitalStaffModels.serviceStaffModels.LaboratoryWorker;
import models.patientModels.MedicalCard;
import models.patientModels.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class LaboratoryWorkerService {

    public void workWithLabWorkers(Scanner s, String path, ArrayList<LaboratoryWorker> labWorkers) {
        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println("Enter command number");
            System.out.println("1. Add laboratory worker(manual)");
            System.out.println("2. Add laboratory worker(automate generation)");
            //  System.out.println("3. Print names of all patients who are suffering from depression");
            //System.out.println("4. Print names of patients whose attending doctor is Ruben Adamyan");
            System.out.println("5. Work with specific laboratory worker");
            System.out.println("6. Exit");

            int command = s.nextInt();
            switch (command) {
                case 1:
                    getManualInput(s, path, labWorkers);
                    break;
                case 2: //TODO: create read from file
                    break;
                //   case 3: printPatientsNamesWithDepression(path,labWorkers);
              //  break;
                //  case 4: printRubenAdamyansPatientsNames(path, labWorkers);
              //  break;
                case 5:
                    System.out.println("Enter name of the laboratory worker you want to work with");
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
                case 6:
                    isMenuActive = false;
                    System.out.println("Chao");
                    break;
                default:
                    System.out.println("Invalid command number");
            }
        }
    }

    public void getManualInput(Scanner s, String path, ArrayList<LaboratoryWorker> laboratoryWorkers) {
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

        createLabWorker(sb.toString(), path, laboratoryWorkers);
    }

    public void createLabWorker(String information, String path, ArrayList<LaboratoryWorker> laboratoryWorkers) {
        String[] info = information.split(",");
        LaboratoryWorker labWorker = new LaboratoryWorker(info[0], info[1], Integer.parseInt(info[2]), info[3].charAt(0));
        laboratoryWorkers.add(labWorker);

        labWorker.printInfo(path);
    }

    public void workWithOneLabWorker(Scanner s, String path, LaboratoryWorker laboratoryWorker) {
//TODO: write body
    }

}
