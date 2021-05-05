package models.baseModels;

import models.hospitalStaffModels.serviceStaffModels.LaboratoryWorker;
import models.hospitalStaffModels.serviceStaffModels.Orderly;
import models.patientModels.Patient;
import services.FileService;

public abstract class Doctor extends Staff {
    //TODO: check doctors methods

    private String departmentName;
    private boolean isHeadDoctor;

    @Override
    public void getPromoted(String path) {
        //TODO: write in file
        if (isHeadDoctor)
            FileService.write(path, "\nThank you for promotion");
        else
            setHeadDoctor(true);
        FileService.write(path, "\nThank you,now I'm a head of my department");
    }

    @Override
    public void interact(String path, Human human) {
        if (human instanceof Doctor) {
            FileService.write(path, "\n*tells doctor specific jokes *");
        } else if (human instanceof Patient) {
            observePatient(path, (Patient) human);
        } else if (human instanceof LaboratoryWorker) {
            FileService.write(path, "\nSend me analyze results as soon as possible");
        } else if (human instanceof Orderly) {
            FileService.write(path, "\nGet prepared for monitoring the patient");
        }
    }

    @Override
    public void printInfo(String path) {
        super.printInfo(path);
        FileService.write(path, "\n Department: " + getDepartmentName());
        FileService.write(path, "\n Is Head Doctor: " + (isHeadDoctor() ? "Yes" : "No"));
    }

    public void observePatient(String path, Patient patient) {
        FileService.write(path, "\nLet's see what complains you've got");
    }

    public static void fillLastTreatment(String path, String treatment) {
        FileService.write(path, "\nLast treatment" + treatment);
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

    public Doctor(String name, String surname, int age, char gender) {
        super(name, surname, age, gender);
    }
    public Doctor(){}

}
