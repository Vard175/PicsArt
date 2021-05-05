package services;

import exceptions.DoctorException;
import models.baseModels.Doctor;
import models.hospitalStaffModels.doctorModels.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DoctorService {

    public void workWithDoctors(Scanner s, String path, ArrayList<Doctor> doctors) {
        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println("Enter command number");
            System.out.println("1. Add doctor(manual)");
            System.out.println("2. Add doctor(automate generation)");
            System.out.println("3. Print names of all cardiologists");
            System.out.println("4. Print all doctor's surnames  who are head of department");
            System.out.println("5. Print oldest doctor");
            System.out.println("6. Work with specific doctor");
            System.out.println("7. Exit");

            int command = s.nextInt();
            switch (command) {
                case 1: getManualInput(s,path,doctors);
                    break;
                case 2: //TODO: create read from file
                    break;
                case 3: printCardiologistsNames(path,doctors);
                    break;
                case 4: printHeadDoctorsSurnames(path,doctors);
                    break;
                case 5: printOldestDoctor(path, doctors);
                    break;
                case 6:
                    System.out.println("Enter name of the doctor you want to work with");
                    String name=s.next();
                    boolean isGivenNameExist=false;
                    for (Doctor doctor:doctors) {
                        if(doctor.getName().equals(name)){
                            isGivenNameExist=true;
                            workWithOneDoctor(s,path,doctor);
                            break;
                        }
                    }
                    if(!isGivenNameExist)
                        FileService.write(path, "\n"+"There is no doctor with given name.");
                    break;
                case 7:
                    isMenuActive = false;
                    System.out.println("Chao");
                    break;
                default:
                    System.out.println("Invalid command number");
            }
        }
    }

    public void getManualInput(Scanner s,String path, ArrayList<Doctor> doctors){
        StringBuilder sb=new StringBuilder();
        System.out.println("Enter name of the doctor");
        sb.append(s.next());
        sb.append(",");
        System.out.println("Enter surname of the doctor");
        sb.append(s.next());
        sb.append(",");
        System.out.println("Enter doctor's age");
        sb.append(s.next());
        sb.append(",");
        System.out.println("Enter doctor's gender (m/f)");
        sb.append(s.next().toLowerCase().charAt(0));
        sb.append(",");
        System.out.println("Choose doctor's speciality: \n 1. Cardiologist \n 2. Child Psychiatrist " +
                "\n 3. Forensic Psychiatrist \n4. General Surgeon \n5. Neurosurgeon \n6. Oncologist");
        sb.append(s.next());
        sb.append(",");
        System.out.println("Enter doctor's department");
        sb.append(s.next());
        sb.append(",");
        System.out.println("Enter doctor's salary");
        sb.append(s.next());
        sb.append(",");
        System.out.println("Is doctor a head of department (y/n)");
        sb.append(s.next()=="y");

        createDoctor(sb.toString(),path, doctors);
    }

    public void createDoctor(String information,String path,ArrayList<Doctor> doctors){
        String[] info=information.split(",");

        switch (info[4]){
            case "1":
                doctors.add(new Cardiologist(info[0],info[1],Integer.parseInt(info[2]),info[3].charAt(0)));
                break;
            case "2":
                doctors.add(new ChildPsychiatrist(info[0],info[1],Integer.parseInt(info[2]),info[3].charAt(0)));
                break;
            case "3":
                doctors.add(new ForensicPsychiatrist(info[0],info[1],Integer.parseInt(info[2]),info[3].charAt(0)));
                break;
            case "4":
                doctors.add(new GeneralSuregon(info[0],info[1],Integer.parseInt(info[2]),info[3].charAt(0)));
                break;
            case "5":
                doctors.add(new Neurosurgeon(info[0],info[1],Integer.parseInt(info[2]),info[3].charAt(0)));
                break;
            case "6":
                doctors.add(new Oncologist(info[0],info[1],Integer.parseInt(info[2]),info[3].charAt(0)));
                break;
            default: throw new DoctorException();
        }
        doctors.get(doctors.size()-1).setDepartmentName(info[5]);
        doctors.get(doctors.size()-1).setSalary(Integer.parseInt(info[6]));
        doctors.get(doctors.size()-1).setHeadDoctor(info[7]=="true");

        doctors.get(doctors.size()-1).printInfo(path);
    }

    public static void printCardiologistsNames(String path, ArrayList<Doctor> doctors){
        for (Doctor doctor:doctors) {
            if(doctor instanceof Cardiologist)
                FileService.write(path, "\n" + doctor.getName());
        }
    }

    public static void printHeadDoctorsSurnames(String path, ArrayList<Doctor> doctors){
        for (Doctor doctor:doctors) {
            if(doctor.isHeadDoctor())
                FileService.write(path, "\n" + doctor.getSurname());

        }
    }

    public static void printOldestDoctor(String path,ArrayList<Doctor> doctors){
        Collections.max(doctors).printInfo(path);
    }

    public static void workWithOneDoctor(Scanner s,String path,Doctor doctor){
        /*
        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println("Enter command number");
            System.out.println("1. Print doctor's info");
            System.out.println("2. Make doctor observe patient");
            System.out.println("3. Give doctor promotion");
            System.out.println("4. Make doctor interact with patient");
            System.out.println("5. Make doctor interact with other doctor");
            System.out.println("6. Make doctor interact with other laboratory worker");
            System.out.println("7. Make doctor interact with orderly");
            System.out.println("8. Fill patient's last treatment");
            System.out.println("7. Exit");

            int command = s.nextInt();
            switch (command) {
                case 1: doctor.printInfo(path);
                    break;
                case 2: doctor.observePatient(new Patient)
                    break;
                case 3: printCardiologistsNames(path,doctors);
                    break;
                case 4: printHeadDoctorsSurnames(path,doctors);
                    break;
                case 5: printOldestDoctor(path, doctors);
                    break;
                case 6:
                    System.out.println("Enter name of the doctor you want to work with");
                    String name=s.next();
                    boolean isGivenNameExist=false;
                    for (Doctor doctor:doctors) {
                        if(doctor.getName().equals(name)){
                            isGivenNameExist=true;
                            workWithOneDoctor(path,doctor);
                            break;
                        }
                    }
                    if(!isGivenNameExist)
                        FileService.write(path, "\n"+"There is no doctor with given name.");
                    //TODO: choose doctor's name ,in function print fucntionaly of object in while
                    break;
                case 7:
                    isMenuActive = false;
                    System.out.println("Chao");
                    break;
                default:
                    System.out.println("Invalid command number");
            }
        } */
    }

}

