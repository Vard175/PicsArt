package services;

import models.hospitalStaffModels.doctorModels.Cardiologist;
import models.hospitalStaffModels.doctorModels.ChildPsychiatrist;
import models.hospitalStaffModels.doctorModels.ForensicPsychiatrist;
import models.hospitalStaffModels.doctorModels.Oncologist;
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
            System.out.println("1. Add patient");
            System.out.println("2. Print names of all patients who are suffering from depression");
            System.out.println("3. Print names of patients whose attending doctor is given doctor");
            System.out.println("4. Work with specific patient");
            System.out.println("5. Exit");

            int command = s.nextInt();
            switch (command) {
                case 1:
                    getManualInput(s, path, patients);
                    break;
                case 2:
                    FileService.write(path, "\n\n3. Print names of all patients who are suffering from depression");
                    printPatientsNamesWithDepression(path, patients);
                    break;
                case 3:
                    FileService.write(path, "\n\n4. Print names of patients whose attending doctor is given doctor");
                    System.out.println("Enter name of a doctor");
                    printGivenDoctorsPatientsNames(path, patients, s.next());
                    break;
                case 4:
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
                case 5:
                    isMenuActive = false;
                    System.out.println("--------------------------------\n*Going back to the last menu*");
                    break;
                default:
                    System.out.println("Invalid command number");
            }
        }
    }

    public static void getManualInput(Scanner s, String path, ArrayList<Patient> patients) {
        StringBuilder sb = new StringBuilder();
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

        createPatient(sb.toString(), createMedCard(s), path, patients);
    }

    public static void createPatient(String information, MedicalCard medCard, String path, ArrayList<Patient> patients) {
        String[] info = information.split(",");
        Patient patient = new Patient(info[0], info[1], Integer.parseInt(info[2]), info[3].charAt(0));
        patient.setAttendingDoctor(info[4]);
        patient.setMedicalCard(medCard);
        patients.add(patient);

        patient.printInfo(path);
    }

    public static MedicalCard createMedCard(Scanner s) {

        System.out.println("Enter last treatment patient got( - if you don't know)");
        String lastTreatment = s.next();
        System.out.println("Is patient feeling good (yes/no)");
        boolean isFeelingGood = s.next().equals("yes");
        System.out.println("Fill in disease information");
        Disease disease = createDisease(s);
        return new MedicalCard(disease, isFeelingGood, lastTreatment);
    }

    public static Disease createDisease(Scanner s) {
        System.out.println("Enter disease name");
        String name = s.next().toLowerCase();
        System.out.println("Describe symptoms (format: symptom,symptom)");
        String[] temp = s.next().split(",");
        ArrayList<String> symptoms = new ArrayList<>();
        for (String str : temp) {
            symptoms.add(str);
        }
        return new Disease(name, symptoms);
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
