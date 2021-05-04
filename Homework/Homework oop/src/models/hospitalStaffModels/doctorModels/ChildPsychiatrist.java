package models.hospitalStaffModels.doctorModels;

import interfaces.Psychiatrist;
import models.baseModels.Doctor;
import models.patientModels.Patient;

public class ChildPsychiatrist extends Doctor implements Psychiatrist {

    public ChildPsychiatrist(String name, String surname, int age,char gender) {
        super(name, surname, age,gender);
    }

    @Override
    public void prescribeAntidepressants(Patient patient) {
        //TODO:
        System.out.println("Take this one time a week, that is children dose" );
        Doctor.fillLastTreatment(patient,"antidepressants");
    }
}
