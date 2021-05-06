package models.hospitalStaffModels.serviceStaffModels;

import models.baseModels.Doctor;
import models.baseModels.Human;
import models.baseModels.Staff;
import models.patientModels.Patient;
import services.FileService;

public class Orderly extends Staff {
    public Orderly(String name, String surname, int age, char gender) {
        super(name, surname, age, gender);
    }
    public Orderly(){}

    @Override
    public void interact(String path, Human human) {
        if (human instanceof Doctor) {
            FileService.write(path, "\nShould I prepare patient now or later ?");
        } else if (human instanceof Patient) {
            FileService.write(path, "\nI would help you to prepare for monitoring");
        } else if (human instanceof LaboratoryWorker) {
            FileService.write(path, "\nDo you have any flasks to be cleaned?");
        } else if (human instanceof Orderly) {
            FileService.write(path, "\n*tells orderly specific jokes *");
        }
    }

    @Override
    public void getPromoted(String path) {
        FileService.write(path, "\nOh,yeah, we are getting promoted as any other specialist");
    }
}
