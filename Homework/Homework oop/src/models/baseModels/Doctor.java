package models.baseModels;

import models.patientModels.Patient;
import services.FileService;

public abstract class Doctor extends Staff {
    //TODO: check doctors methods

    private String departmentName;
    private boolean isHeadDoctor;

    @Override
    public void getPromoted() {
        //TODO: write in file
        if (isHeadDoctor)
            System.out.println("Thank you for promotion");
        else
            setHeadDoctor(true);
            System.out.println("Thank you,now I'm a head of my department");
    }

    //TODO: delete this ?
    @Override
    public void complain() {
        //TODO: write in fie
        System.out.println("Oh,this is ridiculous...I'm gonna make a report");
    }

    @Override
    public void printInfo(String path) {
        super.printInfo(path);
        FileService.write(path, "\n Department: " + getDepartmentName());
        FileService.write(path, "\n Is Head Doctor: " + (isHeadDoctor() ? "Yes" : "No"));
    }

    public String diagnosePatient(Patient patient) {
        //TODO: write in file
        return "Let's see...hmm..with this symptoms for further information you should see " + patient.getAttendingDoctor();
    }

    public static void fillLastTreatment(Patient patient, String treatment) {
        patient.getMedicalCard().setLastTreatment(treatment);
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public boolean isHeadDoctor() {
        return isHeadDoctor;
    }

    public void setHeadDoctor(boolean headDoctor) {
        isHeadDoctor = headDoctor;
    }

    public Doctor(String name, String surname, int age,char gender) {
        super(name, surname, age,gender);
    }

}
