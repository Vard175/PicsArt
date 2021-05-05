package models.hospitalStaffModels.doctorModels;

import interfaces.Operable;
import models.baseModels.Doctor;
import services.FileService;

public class GeneralSuregon extends Doctor implements Operable {

    public GeneralSuregon(String name, String surname, int age, char gender) {
        super(name, surname, age, gender);
    }

    @Override
    public void anesthetize(String path) {
        FileService.write(path, "\nWe can do general,regional or even local anaesthesia");
    }

    @Override
    public void operate(String path) {
        FileService.write(path, "\nAs you can see I operate,get out of here and stop distracting me");
        Doctor.fillLastTreatment(path, "general operation");
    }

    public void askingForLancet(String path) {
        FileService.write(path, "\nLancet. *serious face*");
    }
}
