package models.hospitalStaffModels.serviceStaffModels;

import models.baseModels.Doctor;
import models.baseModels.Human;
import models.baseModels.Staff;
import models.patientModels.Patient;

public class LaboratoryWorker extends Staff {

    public LaboratoryWorker(String name, String surname, int age,char gender) {
        super(name, surname, age,gender);
    }

    public String testBlood(){
        return "We will send your results by e-mail (Жиза :D )";
    }

    @Override
    public void interact(Human human) {
        if(human instanceof Doctor){
            System.out.println("Here are test results");
        }
        else if(human instanceof Patient){
            testBlood();
        }
        else if(human instanceof LaboratoryWorker){
            System.out.println("*tells lab worker's specific jokes *");
        }
        else if(human instanceof Orderly){
            System.out.println("Clean these flasks,please. ");
        }
    }

    @Override
    public void getPromoted() {
        //TODO:
        System.out.println("I've got promoted");
    }
}
