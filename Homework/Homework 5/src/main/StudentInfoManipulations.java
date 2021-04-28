package main;

import model.Student;
import services.FileService;
import services.StudentService;

import java.io.IOException;
import java.util.Scanner;

public class StudentInfoManipulations {
    public static void main(String[] args) {

        String readPath = "C:\\Users\\Dell\\Documents\\input22.txt";
        String[] studentInfoTemp = {""};

        try {
            studentInfoTemp = FileService.read(readPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

       String[][] studentInfo = new String[studentInfoTemp.length][];

        for (int i = 0; i < studentInfo.length; i++)
            studentInfo[i] = studentInfoTemp[i].split(",");

        Student[] students = new Student[studentInfo.length];

        for (int i = 0; i < students.length; i++)
            students[i] = StudentService.createStudent(studentInfo[i]);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter path of the folder (format: folder//..folder//)");
        String filePath = scanner.next();
        System.out.println("Enter file name with extension");
        String fileName = scanner.next();
        String path = filePath + fileName;
        try {
            FileService.createFile(filePath, fileName);
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
                    FileService.write(path, "\n1. Print full names of students");
                    StudentService.printFullNames(path, students);
                    break;
                case 2:
                    FileService.write(path, "\n2. Print all male students \"");
                    StudentService.printMaleStudents(path, students);
                    break;
                case 3:
                    FileService.write(path, "\n3. Print all female students who has mark greater then 50.4 ");
                    StudentService.printFemalesMarkGreater50point4(path, students);
                    break;
                case 4:
                    System.out.println("Enter minMark");
                    float minMark = scanner.nextFloat();
                    FileService.write(path, "\n4. Print student information having the minimal mark");
                    StudentService.printStudentInfoWithGivenMinMark(path, students, minMark);
                    break;
                case 5:
                    FileService.write(path, "\n5. Print oldest male student information");
                    StudentService.printOldestMaleStudent(path, students);
                    break;
                case 6:
                    FileService.write(path, "\n6. Print students sorted by mark");
                    StudentService.printSortedByMark(path, students);
                    break;
                case 7:
                    FileService.write(path, "\n7. Print female students sorted by year");
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
