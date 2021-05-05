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
    public void interact(Human human) {
        if(human instanceof Doctor){
            System.out.println("I'm not feeling good,I have " + getMedicalCard().getDisease().getSymptoms().get(0));
        }
        else if(human instanceof Patient){
            System.out.println("Hey,nice to meet you,I am " + human.getName());
        }
        else if(human instanceof LaboratoryWorker){
            System.out.println("I should take these tests");
        }
        else if(human instanceof Orderly){
            System.out.println("Please,help me to get prepared for observation.");
        }
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
