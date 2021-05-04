package models.hospitalStaffModels.serviceStaffModels;

import models.baseModels.Staff;

public class Orderly extends Staff {
    public Orderly(String name, String surname, int age,char gender) {
        super(name, surname, age,gender);
    }

    @Override
    public void complain() {
        //TODO:delete , keep just as local method
        System.out.println("Could this people be any dirtier? (Friends reference :D)");
    }

    @Override
    public void getPromoted() {
        //TODO
        System.out.println("Oh,yeah, we are getting promoted as any other specialist");
    }
}
