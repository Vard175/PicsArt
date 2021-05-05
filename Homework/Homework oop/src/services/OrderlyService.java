package services;

import models.hospitalStaffModels.serviceStaffModels.Orderly;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderlyService {
    public static void workWithOrderlies(Scanner s,String path, ArrayList<Orderly> orderlies){
            boolean isMenuActive = true;
            while (isMenuActive) {
                System.out.println("Enter command number");
                System.out.println("1. Add orderly(manual)");
                System.out.println("2. Add orderly(automate generation)");
                //  System.out.println("3. Print names of all patients who are suffering from depression");
                //System.out.println("4. Print names of patients whose attending doctor is Ruben Adamyan");
                System.out.println("5. Work with specific orderly");
                System.out.println("6. Exit");

                int command = s.nextInt();
                switch (command) {
                    case 1:
                        getManualInput(s, path, orderlies);
                        break;
                    case 2: //TODO: create read from file
                        break;
                    //   case 3: printPatientsNamesWithDepression(path,labWorkers);
                  //  break;
                    //  case 4: printRubenAdamyansPatientsNames(path, labWorkers);
                 //   break;
                    case 5:
                        System.out.println("Enter name of the laboratory worker you want to work with");
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
                    case 6:
                        isMenuActive = false;
                        System.out.println("Chao");
                        break;
                    default:
                        System.out.println("Invalid command number");
                }
            }
        }

        public static void getManualInput(Scanner s, String path, ArrayList<Orderly> orderlies) {
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

            cretaeOrderly(sb.toString(), path, orderlies);
        }

        public static void cretaeOrderly(String information, String path, ArrayList<Orderly> orderlies) {
            String[] info = information.split(",");
            Orderly orderly = new Orderly(info[0], info[1], Integer.parseInt(info[2]), info[3].charAt(0));
            orderlies.add(orderly);

            orderly.printInfo(path);
        }

        public static void workWithOneOrderly(Scanner s, String path, Orderly orderly) {
//TODO: write body
        }

    }
