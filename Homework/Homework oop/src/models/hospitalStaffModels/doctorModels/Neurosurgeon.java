package models.hospitalStaffModels.doctorModels;

import interfaces.Operable;
import models.baseModels.Doctor;
import models.patientModels.Patient;

public class Neurosurgeon extends Doctor implements Operable {
    public Neurosurgeon(String name, String surname, int age,char gender) {
        super(name, surname, age,gender);
    }

    @Override
    public void anesthetize(Patient patient) {
        //TODO: maybe in file ?
        System.out.println("We are gonna do general anaesthesia");
    }

    @Override
    public void operate(Patient patient) {
        //TODO:
        System.out.println("I'm doing operation on central nervous system");
        Doctor.fillLastTreatment(patient,"central nervous system operation");
    }


}
