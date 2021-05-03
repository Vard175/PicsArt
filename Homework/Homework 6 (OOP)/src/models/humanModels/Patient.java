package models.humanModels;

import models.diseaseModels.Disease;
import models.otherModels.MedicalCard;

public class Patient extends Human{
    Disease[] diseases;
    MedicalCard medicalCard;

    @Override
    public void talk() {
        //TODO ֆայլի մեջ գրի "Oh,doctor, I haven't been feeling very well lately. "
    }

    public Patient(String name, String surname, int age) {
        super(name, surname, age);
    }
}
