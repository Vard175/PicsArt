package models.hospitalStaffModels.doctorModels;

import interfaces.Psychiatrist;
import models.baseModels.Doctor;
import models.patientModels.Patient;
import services.FileService;

import static java.util.Objects.isNull;

public class ForensicPsychiatrist extends Doctor implements Psychiatrist {
    public ForensicPsychiatrist(String name, String surname, int age, char gender) {
        super(name, surname, age, gender);
    }
    public ForensicPsychiatrist(){}


    @Override
    public void observePatient(String path, Patient patient) {
        if (!isNull(patient))
            if (patient.getMedicalCard().getDisease().getSymptoms().contains("self harm"))
                FileService.write(path, "\nYou might have suicidal thoughts");
            else
                super.observePatient(path, patient);
    }

    @Override
    public void prescribeAntidepressants(String path) {
        FileService.write(path, "\nTake this twice a week");
        Doctor.fillLastTreatment(path, "antidepressants");
    }
}
