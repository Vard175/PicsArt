package services;

import models.hospitalStaffModels.doctorModels.Cardiologist;
import models.hospitalStaffModels.doctorModels.ChildPsychiatrist;
import models.hospitalStaffModels.doctorModels.ForensicPsychiatrist;
import models.hospitalStaffModels.doctorModels.Oncologist;
import models.patientModels.Disease;
import models.patientModels.MedicalCard;
import models.patientModels.Patient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PatientService {

    public static void workWithPatients(Scanner s, String path, ArrayList<Patient> patients) {
        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println("Enter command number");
            System.out.println("1. Add patient(manual input)");
            System.out.println("2. Add patient(automate input)");
            System.out.println("3. Print names of all patients who are suffering from depression");
            System.out.println("4. Print names of patients whose attending doctor is given doctor");
            System.out.println("5. Work with specific patient");
            System.out.println("6. Exit");

            int command = s.nextInt();
            switch (command) {
                case 1:
                    getManualInput(s, path, patients);
                    break;
                case 2:
                    getAutomateInput( path, patients);
                    break;
                case 3:
                    FileService.write(path, "\n\n3. Print names of all patients who are suffering from depression");
                    printPatientsNamesWithDepression(path, patients);
                    break;
                case 4:
                    FileService.write(path, "\n\n4. Print names of patients whose attending doctor is given doctor");
                    System.out.println("Enter name of a doctor");
                    printGivenDoctorsPatientsNames(path, patients, s.next());
                    break;
                case 5:
                    System.out.println("Enter name of the patient you want to work with");
                    for (Patient p : patients) {
                        System.out.printf("\t" + p.getName());
                    }
                    String name = s.next();
                    boolean isGivenNameExist = false;
                    for (Patient patient : patients) {
                        if (patient.getName().equals(name)) {
                            isGivenNameExist = true;
                            workWithOnePatient(s, path, patient);
                            break;
                        }
                    }
                    if (!isGivenNameExist)
                        FileService.write(path, "\nThere is no patient with given name.");
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

    public static void getManualInput(Scanner s, String path, ArrayList<Patient> patients) {
        StringBuilder sbPatient = new StringBuilder();
        System.out.println("Enter name of the patient");
        sbPatient.append(s.next());
        sbPatient.append(",");
        System.out.println("Enter surname of the patient");
        sbPatient.append(s.next());
        sbPatient.append(",");
        System.out.println("Enter patient's age");
        sbPatient.append(s.next());
        sbPatient.append(",");
        System.out.println("Enter patient's gender (m/f)");
        sbPatient.append(s.next().toLowerCase().charAt(0));
        sbPatient.append(",");
        System.out.println("Enter patient's attending doctor");

        StringBuilder sbMedCard = new StringBuilder();
        System.out.println("Fill in patient's medical card information");
        System.out.println("Enter last treatment patient got( - if you don't know)");
        sbMedCard.append(s.next());
        System.out.println("Is patient feeling good (yes/no)");
        sbMedCard.append(s.next());
        System.out.println("Fill in disease information");
        System.out.println("Enter disease name");
        sbMedCard.append(s.next().toLowerCase());
        System.out.println("Describe symptoms (format: symptom,symptom)");
        sbMedCard.append(s.next());

        createPatient(sbPatient.toString(), sbMedCard.toString(), path, patients);
    }

    public static void getAutomateInput(String path, ArrayList<Patient> patients) {
        String inputPath = "src//inputFiles//patientInput.txt//";
        List<String> pInput = null;
        try {
            pInput = FileService.read(inputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        inputPath="src//inputFiles//medCardInput.txt//";
        List<String> medInput=null;
        try {
            medInput=FileService.read(inputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < pInput.size(); i++) {
            createPatient(pInput.get(i),medInput.get(i),path,patients);
        }
    }

    public static void createPatient(String pInfo, String mInfo , String path, ArrayList<Patient> patients) {
        String[] info = pInfo.split(",");
        Patient patient = new Patient(info[0], info[1], Integer.parseInt(info[2]), info[3].charAt(0));
        patient.setAttendingDoctor(info[4]);
        patient.setMedicalCard(createMedCard(mInfo));
        patients.add(patient);

        patient.printInfo(path);
    }

    public static MedicalCard createMedCard(String medInfo) {
        String[] info = medInfo.split(",");
        return new MedicalCard(createDisease(medInfo), info[1].equals("yes"), info[0]);
    }

    public static Disease createDisease(String dInfo) {
        String[] info = dInfo.split(",");
        ArrayList<String> symptoms = new ArrayList<>(Arrays.asList(info));
        symptoms.remove(0);
        symptoms.remove(0);
        return new Disease(info[2], symptoms);
    }

    public static void printPatientsNamesWithDepression(String path, ArrayList<Patient> patients) {
        for (Patient patient : patients) {
            if (patient.getMedicalCard().getDisease().getName().equals("depression"))
                FileService.write(path, "\n" + patient.getName());
        }
    }

    public static void printGivenDoctorsPatientsNames(String path, ArrayList<Patient> patients, String doctorName) {
        for (Patient patient : patients) {
            if (patient.getAttendingDoctor().equals(doctorName))
                FileService.write(path, "\n" + patient.getName());
        }
    }

    public static void workWithOnePatient(Scanner s, String path, Patient patient) {
        FileService.write(path, "\n\nNow we are working with" + patient.getName());
        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println("Enter command number");
            System.out.println("1. Print patient's info");
            System.out.println("2. Find out how patient feels");
            System.out.println("3. Make an appointment");
            System.out.println("4. Go to cardiologist's observation");
            System.out.println("5. Go to child psychiatrist's observation");
            System.out.println("6. Go to oncologist's observation");
            System.out.println("7. Go to forensic psychiatrist's observation");
            System.out.println("8. Make patient interact with doctor");
            System.out.println("9. Exit");

            int command = s.nextInt();
            switch (command) {
                case 1:
                    patient.printInfo(path);
                    break;
                case 2:
                    patient.tellHowFeels(path);
                    break;
                case 3:
                    System.out.println("Enter day of the week for making an appointment");
                    patient.makeAppointment(path, s.next().toLowerCase());
                    break;
                case 4:
                    Cardiologist c = new Cardiologist();
                    c.observePatient(path, patient);
                    break;
                case 5:
                    ChildPsychiatrist cp = new ChildPsychiatrist();
                    cp.observePatient(path, patient);
                    break;
                case 6:
                    Oncologist o = new Oncologist();
                    o.observePatient(path, patient);
                    break;
                case 7:
                    ForensicPsychiatrist f = new ForensicPsychiatrist();
                    f.observePatient(path, patient);
                    break;
                case 8:
                    patient.interact(path, new Cardiologist());
                    break;
                case 9:
                    isMenuActive = false;
                    System.out.println("--------------------------------\n*Going back to the last menu*");
                    break;
                default:
                    System.out.println("Invalid command number");
            }
        }
    }
}
