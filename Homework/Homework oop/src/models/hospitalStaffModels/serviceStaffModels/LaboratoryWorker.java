package models.hospitalStaffModels.serviceStaffModels;

import models.baseModels.Staff;

public class LaboratoryWorker extends Staff {

    public LaboratoryWorker(String name, String surname, int age,char gender) {
        super(name, surname, age,gender);
    }

    public String testBlood(){
        return "We will send your results by e-mail (Жиза :D )";
    }

    @Override
    public void complain() {
//TODO: delete this
        System.out.println("Oh,man,I have so much work to do...");
    }

    @Override
    public void getPromoted() {
        //TODO:
        System.out.println("I've got promoted");
    }
}
