package services;

import models.hospitalStaffModels.doctorModels.Cardiologist;
import models.hospitalStaffModels.serviceStaffModels.LaboratoryWorker;
import models.hospitalStaffModels.serviceStaffModels.Orderly;
import models.patientModels.Disease;
import models.patientModels.MedicalCard;
import models.patientModels.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class PatientService {

    public static void workWithPatients(Scanner s, String path, ArrayList<Patient> patients) {
        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println("Enter command number");
            System.out.println("1. Add patient(manual)");
            System.out.println("2. Add patient(automate generation)");
            System.out.println("3. Print names of all patients who are suffering from depression");
            System.out.println("4. Print names of patients whose attending doctor is Ruben Adamyan");
            System.out.println("5. Work with specific patient");
            System.out.println("6. Exit");

            int command = s.nextInt();
            switch (command) {
                case 1: getManualInput(s,path,patients);
                    break;
                case 2: //TODO: create read from file
                    break;
                case 3: printPatientsNamesWithDepression(path,patients);
                    break;
                case 4: printRubenAdamyansPatientsNames(path, patients);
                    break;
                case 5:
                    System.out.println("Enter name of the patient you want to work with");
                    String name=s.next();
                    boolean isGivenNameExist=false;
                    for (Patient patient:patients) {
                        if(patient.getName().equals(name)){
                            isGivenNameExist=true;
                            workWithOnePatient(s,path,patient);
                            break;
                        }
                    }
                    if(!isGivenNameExist)
                        FileService.write(path, "\n"+"There is no patient with given name.");
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
    public static void getManualInput(Scanner s,String path, ArrayList<Patient> patients){
        StringBuilder sb=new StringBuilder();
        System.out.println("Enter name of the patient");
        sb.append(s.next());
        sb.append(",");
        System.out.println("Enter surname of the patient");
        sb.append(s.next());
        sb.append(",");
        System.out.println("Enter patient's age");
        sb.append(s.next());
        sb.append(",");
        System.out.println("Enter patient's gender (m/f)");
        sb.append(s.next().toLowerCase().charAt(0));
        sb.append(",");
        System.out.println("Enter patient's attending doctor");
        sb.append(s.next());
        System.out.println("Fill in patient's medical card information");

        createPatient(sb.toString(),createMedCard(s),path, patients);
    }

    public static void createPatient(String information,MedicalCard medCard,String path,ArrayList<Patient> patients){
        String[] info=information.split(",");
        Patient patient=new Patient(info[0],info[1],Integer.parseInt(info[2]),info[3].charAt(0));
        patient.setAttendingDoctor(info[4]);
        patient.setMedicalCard(medCard);
        patients.add(patient);

        patient.printInfo(path);
    }

    public static MedicalCard createMedCard(Scanner s){

        System.out.println("Enter last treatment patient got( - if you don't know)");
        String lastTreatment=s.next();
        System.out.println("Is patient feeling good (yes/no)");
        boolean isFeelingGood=s.next().equals("yes");
        System.out.println("Fill in disease information");
        Disease disease=createDisease(s);
        return new MedicalCard(disease,isFeelingGood,lastTreatment);
    }

    public static Disease createDisease(Scanner s){
        System.out.println("Enter disease name");
        String name=s.next().toLowerCase();
        System.out.println("Describe symptoms (format: symptom,symptom)");
        String[] temp=s.next().split(",");
        ArrayList<String> symptoms = new ArrayList<>();
        for (String str:temp) {
            symptoms.add(str);
        }
        return new Disease(name,symptoms);
    }

    public static void printPatientsNamesWithDepression(String path,ArrayList<Patient> patients){
        for (Patient patient:patients) {
            if(patient.getMedicalCard().getDisease().getName().equals("depression"))
                FileService.write(path, "\n" + patient.getName());
        }
    }

    public static void printRubenAdamyansPatientsNames(String path,ArrayList<Patient> patients){
        for (Patient patient:patients) {
            if(patient.getAttendingDoctor().equals("Ruben Adamyan"))
                FileService.write(path, "\n" + patient.getName());
        }
    }

    public static void workWithOnePatient(Scanner s,String path,Patient patient){
        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println("Enter command number");
            System.out.println("1. Print doctor's info");
            System.out.println("2. Give doctor promotion");
            System.out.println("3. Make doctor interact with patient");
            System.out.println("4. Make doctor interact with other doctor");
            System.out.println("5. Make doctor interact with other laboratory worker");
            System.out.println("6. Make doctor interact with orderly");
            System.out.println("7. Exit");

            int command = s.nextInt();
            switch (command) {
                case 1:
                    doctor.printInfo(path);
                    break;
                case 2:
                    doctor.getPromoted(path);
                    break;
                case 3:
                    doctor.interact(path, new Patient());
                    break;
                case 4:
                    doctor.interact(path, new Cardiologist());
                    break;
                case 5:
                    doctor.interact(path, new LaboratoryWorker());
                    break;
                case 6:
                    doctor.interact(path, new Orderly());
                    break;
                case 7:
                    isMenuActive = false;
                    System.out.println("Chao");
                    break;
                default:
                    System.out.println("Invalid command number");
                    //TODO: գրել պատիենտի էս զիբիլիկնները ,ֆունկցիաներ գրել լաբի համար ու սանիտարի ու էս զիբիլիկը մեկ էլ
            }
        }
    }
}
