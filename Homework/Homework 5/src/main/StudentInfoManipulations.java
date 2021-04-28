package main;

import model.Student;
import service.FileService;
import service.StudentService;

import java.io.IOException;
import java.util.Scanner;

public class StudentInfoManipulations {
    public static void main(String[] args) {

        String readPath="C:\\Users\\Dell\\Documents\\input22.txt";
        String[] studentInfoTemp={""};
//        String[][] studentInfo=new String[studentInfoTemp.length][];
//        Student[] students=new Student[studentInfo.length];

        try {
           studentInfoTemp= FileService.read(readPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[][] studentInfo=new String[studentInfoTemp.length][];

        for(int i=0;i<studentInfo.length;i++)
                studentInfo[i]=studentInfoTemp[i].split(",");

        Student[] students=new Student[studentInfo.length];

        for (int i = 0; i < students.length; i++)
            students[i]=StudentService.createStudent(studentInfo[i]);

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter path of the folder");
        String filePath=scanner.next();
        System.out.println("Enter file name with extension");
        String fileName=scanner.next();
        String path=filePath+fileName;
        try {
            FileService.createFile(filePath,fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println("Enter command number");
            System.out.println("1. Print full names of students");
            System.out.println("2. Print all male students ");
            System.out.println("3. Print all female students who has mark greater then 50.4 ");
            System.out.println("4. Print student information having the minimal mark");
            System.out.println("5. Print biggest male student information");
            System.out.println("6. Print students sorted by mark");
            System.out.println("7. Print female students sorted by year");
            System.out.println("8. Exit");

            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    StudentService.printFullNames(path, students);
                    break;
                case 2:
                    StudentService.printMaleStudents(path, students);
                    break;
                case 3:
                    StudentService.printFemalesMarkGreater50point4(path, students);
                    break;
                case 4:
                    StudentService.printStudentInfoWithGivenMinMark(path, students, 47.89f);
                    break;
                case 5:
                    StudentService.printOldestMaleStudent(path, students);
                    break;
                case 6:
                    StudentService.printSortedByMark(path, students);
                    break;
                case 7:
                    StudentService.printFemalesSortedbyYear(path, students);
                    break;
                case 8:
                    isMenuActive = false;
                    System.out.println("Chao");
                    break;
                default:
                    System.out.println("Invalid command number");
            }
        }

    }
}
