package models.patientModels;

import models.baseModels.Doctor;
import models.baseModels.Human;
import models.hospitalStaffModels.serviceStaffModels.LaboratoryWorker;
import models.hospitalStaffModels.serviceStaffModels.Orderly;
import services.FileService;

public class Patient extends Human {

    private MedicalCard medicalCard;
    private String attendingDoctor;

    @Override
    public void printInfo(String path) {
        super.printInfo(path);
        FileService.write(path, "\n Attending doctor: " + getAttendingDoctor());
        getMedicalCard().printInfo(path);
    }

    @Override
    public void interact(String path, Human human) {
        if (human instanceof Doctor) {
            FileService.write(path, "\nI'm not feeling good,I have " + getMedicalCard().getDisease().getSymptoms().get(0));
        } else if (human instanceof Patient) {
            FileService.write(path, "\nHey,nice to meet you,I am " + human.getName());
        } else if (human instanceof LaboratoryWorker) {
            FileService.write(path, "\nI should take these tests");
        } else if (human instanceof Orderly) {
            FileService.write(path, "\nPlease,help me to get prepared for observation.");
        }
    }

    public void tellHowFeels(String path) {
        FileService.write(path, (getMedicalCard().isFeelingGood() ? "\n I feel better" : "\nI haven't been feeling very well lately."));
    }

    public void makeAppointment(String path,String dayOfWeek) {
        StringBuilder sb = new StringBuilder();
        sb.append("I would like to make an appointment. What times are available on ")
                .append(dayOfWeek)
                .append(" ?");
        FileService.write(path, "\n"+sb.toString());
    }

    public MedicalCard getMedicalCard() {
        return medicalCard;
    }

    public void setMedicalCard(MedicalCard medicalCard) {
        this.medicalCard = medicalCard;
    }

    public String getAttendingDoctor() {
        return attendingDoctor;
    }

    public void setAttendingDoctor(String attendingDoctor) {
        this.attendingDoctor = attendingDoctor;
    }

    public Patient(String name, String surname, int age, char gender) {
        super(name, surname, age, gender);
    }

    public Patient(){}

}
