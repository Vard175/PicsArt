package models.patientModels;

import models.baseModels.Human;
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

    //TODO: delete this / change to interact
    @Override
    public void complain() {
        //TODO: write in file
        System.out.println("I'm not feeling good,I have " + getMedicalCard().getDisease().getSymptoms().get(0));
    }

    public void tellHowFeels() {
        //TODO:
        System.out.println(getMedicalCard().isFeelingGood() ? " I feel better" : "I haven't been feeling very well lately.");
    }

    public void makeAppointment(String dayOfWeek) {
        //TODO:write in file
        StringBuilder sb = new StringBuilder();
        sb.append("I would like to make an appointment. What times are available on ")
                .append(dayOfWeek)
                .append(" ?");
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

    public Patient(String name, String surname, int age,char gender) {
        super(name, surname, age,gender);
    }


}
