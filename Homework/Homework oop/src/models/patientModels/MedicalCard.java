package models.patientModels;

import services.FileService;

import java.util.Scanner;

public class MedicalCard {

    private Disease disease;
    private boolean isFeelingGood;
    private String lastTreatment;

    public void printInfo(String path){
        FileService.write(path, "\n Is patient getting better: " + (isFeelingGood()?"Yes":"No"));
        FileService.write(path, "\n Last treatment: " + getLastTreatment());
            getDisease().printInfo(path);
    }

    public MedicalCard() {
        Scanner s = new Scanner(System.in);
        s.useDelimiter("\n");

        System.out.println("Enter last treatment patient got( - if you don't know)");
        setLastTreatment(s.next());
        System.out.println("Is patient feeling good (yes/no)");
        setFeelingGood(s.next().equals("yes"));
        //TODO: with constructor
        setDisease(new Disease());
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

