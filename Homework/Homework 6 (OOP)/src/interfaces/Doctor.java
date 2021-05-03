package interfaces;

import models.humanModels.Patient;

public interface Doctor {
     String  diagnose(Patient patient);
     void  treat(Patient patient);
     void  writeInMedicalCard(Patient patient);
     String askToPatient();
     void answerToIntern();
}
