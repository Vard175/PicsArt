package models.patientModels;

import services.FileService;

import java.util.ArrayList;

public class Disease {
    private String name;
    private ArrayList symptoms;

    public Disease(String name, ArrayList symptoms) {
        setName(name);
        setSymptoms(symptoms);
    }

    public void printInfo(String path) {
        FileService.write(path, "\n Name: " + getName());
        FileService.write(path, "\n " + getSymptoms().toString());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(ArrayList symptoms) {
        this.symptoms = symptoms;
    }

}
