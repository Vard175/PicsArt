package models.hospitalStaffModels.serviceStaffModels;

import models.baseModels.Doctor;
import models.baseModels.Human;
import models.baseModels.Staff;
import models.patientModels.Patient;
import services.FileService;

public class LaboratoryWorker extends Staff {

    public LaboratoryWorker(String name, String surname, int age, char gender) {
        super(name, surname, age, gender);
    }

    public LaboratoryWorker(){}

    public String testBlood() {
        return "We will send your results by e-mail (Жиза :D )";
    }

    @Override
    public void interact(String path, Human human) {
        if (human instanceof Doctor) {
            FileService.write(path, "\nHere are test results");
        } else if (human instanceof Patient) {
            testBlood();
        } else if (human instanceof LaboratoryWorker) {
            FileService.write(path, "\n*tells lab worker's specific jokes *");
        } else if (human instanceof Orderly) {
            FileService.write(path, "\nClean these flasks,please. ");
        }
    }

    @Override
    public void getPromoted(String path) {
        //TODO:
        FileService.write(path, "\nI've got promoted");
    }
}
