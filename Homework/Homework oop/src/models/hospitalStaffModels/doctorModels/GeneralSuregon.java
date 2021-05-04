package models.hospitalStaffModels.doctorModels;

import interfaces.Operable;
import models.baseModels.Doctor;
import models.patientModels.Patient;

public class GeneralSuregon extends Doctor implements Operable {

    public GeneralSuregon(String name, String surname, int age, char gender) {
        super(name, surname, age,gender);
    }

    @Override
    public void anesthetize(Patient patient) {
        //TODO:
        System.out.println("We can do general,regional or even local anaesthesia");
    }

    @Override
    public void operate(Patient patient) {
        //TODO:
        System.out.println("As you can see I operate,get out of here and stop distracting me");
        Doctor.fillLastTreatment(patient,"general operation");
    }

    public void askingForLancet() {
//TODO:
        System.out.println("Lancet. *serious face*");
    }
}
