package services;

import models.patientModels.MedicalCard;
import models.patientModels.Patient;

import java.util.ArrayList;
import java.util.Scanner;

//TODO: QUESTION: may I use scanner here ? I think yes
public class PatientService {
    public static Patient createPatient() {
        Scanner s = new Scanner(System.in);
        s.useDelimiter("\n");

        System.out.println("Enter name of the patient");
        String name = s.next();
        System.out.println("Enter surname of the patient");
        String surname = s.next();
        System.out.println("Enter patient's age");
        int age = s.nextInt();
        System.out.println("Enter patient's gender (m/f)");
        char gender = s.next().toLowerCase().charAt(0);
        Patient patient = new Patient(name, surname, age, gender);
        System.out.println("Enter patient's attending doctor (name/surname/specialization)");
        patient.setAttendingDoctor(s.next());
        //TODO: QUESTION: constructor with scanner is okay?
        patient.setMedicalCard(new MedicalCard());

        return patient;
    }
}
