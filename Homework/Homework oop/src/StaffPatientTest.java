import models.baseModels.Doctor;
import models.hospitalStaffModels.serviceStaffModels.LaboratoryWorker;
import models.hospitalStaffModels.serviceStaffModels.Orderly;
import models.patientModels.Patient;
import services.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StaffPatientTest {

    public static void main(String[] args) {
//TODO: create exception
        Scanner s = new Scanner(System.in);
        s.useDelimiter("\n");

        ArrayList<Doctor> doctors=new ArrayList<>();
        ArrayList<Patient> patients=new ArrayList<>();
        ArrayList<LaboratoryWorker> labWorkers=new ArrayList<>();
        ArrayList<Orderly> orderlies=new ArrayList<>();

        String path = "src//files//";
        String doctorFileName = "doctors.txt";
        String labWorkerFileName = "labWorkers.txt";
        String orderlyFileName = "orderlies.txt";
        String patientFileName = "patients.txt";
        String doctorFilePath = path + doctorFileName;
        String labWorkerFilePath = path + labWorkerFileName;
        String orderlyFilePath = path + orderlyFileName;
        String patientFilePath = path + patientFileName;

        try {
            FileService.createFile(path, doctorFileName);
            FileService.createFile(path, labWorkerFileName);
            FileService.createFile(path, orderlyFileName);
            FileService.createFile(path, patientFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println("Enter command number");
            System.out.println("1. Work with doctors");
            System.out.println("2. Work with laboratory workers");
            System.out.println("3. Work with orderlies");
            System.out.println("4. Work with patients");
            System.out.println("5. Exit");

            int command = s.nextInt();
            switch (command) {
                case 1:
                    DoctorService.workWithDoctors(s,doctorFilePath,doctors);
                    break;
                case 2:
                    LaboratoryWorkerService.workWithLabWorkers(s,labWorkerFilePath,labWorkers);
                    break;
                case 3:
                    OrderlyService.workWithOrderlies(s,orderlyFilePath,orderlies);
                    break;
                case 4:
                    PatientService.workWithPatients(s,patientFilePath,patients);
                    break;
                case 5:
                    isMenuActive = false;
                    System.out.println("Chao");
                    break;
                default:
                    System.out.println("Invalid command number");
            }
        }
    }

}
