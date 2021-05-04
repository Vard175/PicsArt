package models.patientModels;

import services.FileService;

import java.util.ArrayList;
import java.util.Scanner;

public class Disease {
    private String name;
    private ArrayList symptoms;

    public void printInfo(String path) {
        FileService.write(path, "\n Name: " + getName());
        FileService.write(path, "\n " + getSymptoms().toString());
    }

    public Disease() {
        Scanner s = new Scanner(System.in);
        s.useDelimiter("\n");

        System.out.println("Enter diseases patient have already got");
        setName(s.next());
        System.out.println("Give short symptoms in symptom,symptom format (like unusual bleeding, chest pain)");
        String[] temp=s.next().split(",");

        ArrayList<String> symptoms=new ArrayList<>();
        for (String symptom:temp)
            symptoms.add(symptom);

        setSymptoms(symptoms);
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
