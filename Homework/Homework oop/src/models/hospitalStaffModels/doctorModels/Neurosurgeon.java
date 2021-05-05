package models.hospitalStaffModels.doctorModels;

import interfaces.Operable;
import models.baseModels.Doctor;
import services.FileService;

public class Neurosurgeon extends Doctor implements Operable {
    public Neurosurgeon(String name, String surname, int age, char gender) {
        super(name, surname, age, gender);
    }

    @Override
    public void anesthetize(String path) {
        FileService.write(path, "\nWe are gonna do general anaesthesia");
    }

    @Override
    public void operate(String path) {
        FileService.write(path, "\nI'm doing operation on central nervous system");
        Doctor.fillLastTreatment(path, "central nervous system operation");
    }


}
