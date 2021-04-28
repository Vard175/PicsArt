package services;

import exceptions.MarkException;
import model.Student;

public class StudentService {

    public static Student createStudent(String[] info) {
        Student student = new Student(info[0], info[1]);
        student.setYear(Integer.parseInt(info[2]));
        student.setGender(info[3].charAt(0));
        try {
            student.setMark(Float.parseFloat(info[4]));
        } catch (MarkException e) {
            e.printStackTrace();
        }
        return student;
    }

    public static void printFullNames(String path, Student[] students) {
        for (Student s : students) {
            FileService.write(path, "\n" + s.getFirstName() + " " + s.getLastName());
        }
    }

    public static void printMaleStudents(String path, Student[] students) {
        for (Student s : students) {
            if (s.getGender() == 'm') {
                s.printInfo(path);
            }
        }
    }

    public static void printFemalesMarkGreater50point4(String path, Student[] students) {
        for (Student s : students) {
            if (s.getGender() == 'f' && s.getMark() > 50.4) {
                s.printInfo(path);
            }
        }
    }

    public static void printStudentInfoWithGivenMinMark(String path, Student[] students, float minMark) {
        for (Student s : students) {
            if (s.getMark() == minMark) {
                s.printInfo(path);
            }
        }
    }

    public static void printOldestMaleStudent(String path, Student[] students) {
        Student oldest = null;
        for (Student s : students) {
            if (s.getGender() == 'm') {
                if (oldest == null) {
                    oldest = s;
                } else if (oldest.getYear() > s.getYear()) {
                    oldest = s;
                }
            }
        }
        if (oldest == null)
            FileService.write(path, "there are no males");
        else
            oldest.printInfo(path);
    }

    public static void printSortedByMark(String path, Student[] students) {

        boolean isActive = true;
        int count = 0;

        while (isActive) {
            isActive = false;
            for (int i = 0; i < students.length - 1 - count; i++) {
                if (students[i].getMark() > students[i + 1].getMark()) {
                    Student temp = students[i];
                    students[i] = students[i + 1];
                    students[i + 1] = temp;
                    isActive = true;
                }
            }
            count++;
        }
        for (Student s : students) {
            s.printInfo(path);
        }
    }

    public static void printFemalesSortedbyYear(String path, Student[] students) {
        boolean isActive = true;
        int count = 0;

        while (isActive) {
            isActive = false;
            for (int i = 0; i < students.length - 1 - count; i++) {
                if (students[i].getYear() > students[i + 1].getYear()) {
                    Student temp = students[i];
                    students[i] = students[i + 1];
                    students[i + 1] = temp;
                    isActive = true;
                }
            }
            count++;
        }
        for (Student s : students) {
            if (s.getGender() == 'f')
                s.printInfo(path);
        }
    }
}


