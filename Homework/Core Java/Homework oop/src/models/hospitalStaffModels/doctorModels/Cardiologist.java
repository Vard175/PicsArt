package models.hospitalStaffModels.doctorModels;

import models.baseModels.Doctor;
import models.patientModels.Patient;
import services.FileService;

import static java.util.Objects.isNull;

public class Cardiologist extends Doctor {

    public Cardiologist(String name, String surname, int age, char gender) {
        super(name, surname, age, gender);
    }

    public Cardiologist() {
    }

    @Override
    public void observePatient(String path, Patient patient) {
        if (!isNull(patient))
            if (patient.getMedicalCard().getDisease().getSymptoms().contains("chest pain"))
                FileService.write(path, "\nYou might have heart problem");
            else
                super.observePatient(path, patient);
    }
}
