package models.hospitalStaffModels.doctorModels;

import interfaces.Psychiatrist;
import models.baseModels.Doctor;
import models.patientModels.Patient;
import services.FileService;

import static java.util.Objects.isNull;

public class ChildPsychiatrist extends Doctor implements Psychiatrist {

    public ChildPsychiatrist(String name, String surname, int age, char gender) {
        super(name, surname, age, gender);
    }
    public ChildPsychiatrist(){}

    @Override
    public void observePatient(String path, Patient patient) {
        if (!isNull(patient))
            if (patient.getMedicalCard().getDisease().getSymptoms().contains("sleep problems"))
                FileService.write(path, "\nYou might have an anxiety");
            else
                super.observePatient(path, patient);
    }

    @Override
    public void prescribeAntidepressants(String path) {
        FileService.write(path, "\nTake this one time a week, that is children dose");
        Doctor.fillLastTreatment(path, "antidepressants");
    }
}
