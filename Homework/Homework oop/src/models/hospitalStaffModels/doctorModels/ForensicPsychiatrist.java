package models.hospitalStaffModels.doctorModels;

import interfaces.Psychiatrist;
import models.baseModels.Doctor;
import models.patientModels.Patient;

public class ForensicPsychiatrist extends Doctor implements Psychiatrist {
    public ForensicPsychiatrist(String name, String surname, int age,char gender) {
        super(name, surname, age,gender);
    }

    @Override
    public void prescribeAntidepressants(Patient patient) {
        //TODO:
        System.out.println("Take this twice a week");
        Doctor.fillLastTreatment(patient,"antidepressants");
    }
}
