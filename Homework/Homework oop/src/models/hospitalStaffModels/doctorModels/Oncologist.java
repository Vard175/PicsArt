package models.hospitalStaffModels.doctorModels;

import models.baseModels.Doctor;
import models.patientModels.Patient;

public class Oncologist extends Doctor {
    public Oncologist(String name, String surname, int age,char gender) {
        super(name, surname, age,gender);
    }

    @Override
    public String diagnosePatient(Patient patient) {
        //TODO:
        if(patient.getMedicalCard().getDisease().getSymptoms().contains("chest pain"))
            return  "You might have cancer";
        else
            return super.diagnosePatient(patient);
    }
}
