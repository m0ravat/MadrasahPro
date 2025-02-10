package com.mosque.management;
import com.mosque.management.education.Course;
import com.mosque.management.education.Subject;
import com.mosque.management.users.Student;
import com.mosque.management.users.Teacher;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static com.mosque.management.Menu.studentMenu;
import static com.mosque.management.Menu.teacherMenu;
import static com.mosque.management.database.CourseQueries.generateSubjects;
import static com.mosque.management.database.CourseQueries.returnCourse;
import static com.mosque.management.database.AccountQueries.insertNewStudentToDB;


public class Main {
    public static void main(String[] args) {

        boolean menu1 = true;
        while (menu1) {
            System.out.println("Welcome to MadrasahPro! Would you like to: ");
            System.out.println("1 - Create a student account");
            System.out.println("2 - Log in to your account");
            System.out.println("4 - Find information about our courses");
            System.out.println("5 - Quit");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    Student newStudent = InputHandler.promptSignup();
                    insertNewStudentToDB(newStudent);
                    break;
                case 2:
                    System.out.println("Type 1 to log into student, 2 for teacher");
                    int option2 = sc.nextInt();
                    switch (option2) {
                        case 1:
                            Optional<Student> stuL = InputHandler.loginStudent();
                            if (stuL.isPresent()) {
                                stuL.toString();
                                studentMenu(stuL.get());
                            } else {
                                System.out.println("Login failed. Exiting...");
                            }
                            break;
                        case 2:
                            Optional<Teacher> teachL = InputHandler.loginTeacher();
                            if (teachL.isPresent()) {
                                teachL.toString();
                                teacherMenu(teachL.get());
                            } else {
                                System.out.println("Login failed. Exiting...");
                            }
                            break;
                    }
                    break;
                case 4:
                    findInfo();
                    break;
                case 5:
                    menu1 = false;
                    break;
                case 958355:
                    loginAdmin();
                    break;
                default:
                    System.out.println("Invalid option");
            }

        }
    }

    private static void loginAdmin() {

    }

    private static void findInfo() {
        System.out.println("Would you like to find out about our:");
        System.out.println("1 - Islamic Studies Diploma");
        System.out.println("2 - Maktab Classes");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch (option) {
            case 1:
                Course courseInfo = returnCourse("Islamic Studies Diploma");
                System.out.println(courseInfo.toString());
                subjectInfo("Islamic Studies Diploma");
                break;
            case 2:
                Course courseInfo2 = returnCourse("Maktab Classes");
                System.out.println(courseInfo2.toString());
                subjectInfo("Maktab Classes");
        }
    }

    private static void subjectInfo(String courseTitle) {
        System.out.println("Would you like to find out about the subjects this course has" +
                "to offer? If so press 1");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        if (option == 1) {
            List<Subject> subjectList = generateSubjects(courseTitle);
            subjectList.forEach(subject -> System.out.println(subject.toString()));
        }
    }
}
