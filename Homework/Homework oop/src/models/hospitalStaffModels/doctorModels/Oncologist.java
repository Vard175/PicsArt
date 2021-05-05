package models.hospitalStaffModels.doctorModels;

import models.baseModels.Doctor;
import models.patientModels.Patient;
import services.FileService;

import static java.util.Objects.isNull;

public class Oncologist extends Doctor {
    public Oncologist(String name, String surname, int age, char gender) {
        super(name, surname, age, gender);
    }

    @Override
    public void observePatient(String path, Patient patient) {
        if (!isNull(patient))
            if (patient.getMedicalCard().getDisease().getSymptoms().contains("chest pain"))
                FileService.write(path, "\n" + "You might have cancer");
            else
                super.observePatient(path, patient);
    }
}
