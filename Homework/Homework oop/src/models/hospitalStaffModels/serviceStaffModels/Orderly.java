package models.hospitalStaffModels.serviceStaffModels;

import models.baseModels.Doctor;
import models.baseModels.Human;
import models.baseModels.Staff;
import models.patientModels.Patient;

public class Orderly extends Staff {
    public Orderly(String name, String surname, int age,char gender) {
        super(name, surname, age,gender);
    }

    @Override
    public void interact(Human human) {
        if(human instanceof Doctor){
            System.out.println("Should I prepare patient now or later ?");
        }
        else if(human instanceof Patient){
            System.out.println("I would help you to prepare fpr monitoring");
        }
        else if(human instanceof LaboratoryWorker){
            System.out.println("Do you have any flasks to be cleaned?");
        }
        else if(human instanceof Orderly){
            System.out.println("*tells orderly specific jokes *");
        }
    }

    @Override
    public void getPromoted() {
        //TODO
        System.out.println("Oh,yeah, we are getting promoted as any other specialist");
    }
}
