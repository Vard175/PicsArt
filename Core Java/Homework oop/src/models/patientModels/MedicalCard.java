package models.patientModels;

import services.FileService;

public class MedicalCard {
    private Disease disease;
    private boolean isFeelingGood;
    private String lastTreatment;

    public void printInfo(String path) {
        FileService.write(path, "\n Is patient getting better: " + (isFeelingGood() ? "Yes" : "No"));
        FileService.write(path, "\n Last treatment: " + getLastTreatment());
        getDisease().printInfo(path);
    }

    public MedicalCard( Disease disease, boolean isFeelingGood, String lastTreatment) {
        setDisease(disease);
        setFeelingGood(isFeelingGood);
        setLastTreatment(lastTreatment);
    }

    public String getLastTreatment() {
        return lastTreatment;
    }

    public void setLastTreatment(String lastTreatment) {
        this.lastTreatment = lastTreatment;
    }

    public boolean isFeelingGood() {
        return isFeelingGood;
    }

    public void setFeelingGood(boolean feelingGood) {
        isFeelingGood = feelingGood;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

}

