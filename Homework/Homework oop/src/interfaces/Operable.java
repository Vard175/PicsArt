package interfaces;

import models.patientModels.Patient;

public interface Operable {

    void anesthetize(Patient patient);
    void operate(Patient patient);
}
