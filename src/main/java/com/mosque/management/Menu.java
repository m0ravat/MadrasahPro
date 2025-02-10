package com.mosque.management;

import com.mosque.management.users.EmergencyContact;
import com.mosque.management.users.Student;
import com.mosque.management.users.Teacher;

import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import static com.mosque.management.InputHandler.editDetails;
import static com.mosque.management.database.AccountQueries.deleteStudent;
import static com.mosque.management.database.AccountQueries.getStudentFromDB;
import static com.mosque.management.database.BookQueries.buyBook;
import static com.mosque.management.database.BookQueries.viewBooks;
import static com.mosque.management.database.CourseQueries.makePayment;
import static com.mosque.management.database.EmergencyContactQueries.getEmergencyContact;
import static com.mosque.management.database.StudentCourseAllocQueries.deleteEnrollment;
import static com.mosque.management.database.StudentCourseAllocQueries.enrollStudent;

public class Menu {
    static boolean menu = true;
    public static void studentMenu(Student student1){
        while (menu){
            System.out.println("Do you want to: \n" +
                    "1. View your student details\n" +
                    "2. Edit your student details\n" +
                    "3. Delete your student details\n" +
                    "4. Leave a course\n" +
                    "5. View/order books\n" +
                    "6. Enroll on a course\n" +
                    "7. Make a course payment\n" +
                    "8. View emergency contact details");
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();
            in.nextLine();
            switch(choice){
                case 1:
                    System.out.println(student1.toString());
                    break;
                case 2:
                    editDetails(student1);
                    break;
                case 3:
                    System.out.println("Do you understand that deleting your student details" +
                            "means your account won't be on our system? y/n");
                    in.nextLine();
                    if (in.nextLine().equals("y")){
                        deleteStudent(student1.getEmail());
                        menu=false;
                    }
                    break;
                case 4:
                    if (Objects.equals(student1.getCourse(), null)){
                        System.out.println("You arent enrolled in a course");
                    }else{
                        deleteEnrollment(student1.getEmail(),student1.getCourse(), student1.getYearJoined());
                        menu = false;
                    }
                    break;
                case 5:
                    System.out.println("The books on your course are: ");
                    viewBooks(student1.getCourse());
                    System.out.println("Would you like to buy any? y/n");
                    String answer = in.nextLine();
                    if(answer.equals("y")){
                        System.out.println("Enter the book name correctly");
                        String bookName = in.nextLine();
                        student1.setMoneyOwed(buyBook(bookName,student1.getEmail()) + student1.getMoneyOwed());
                    }
                    break;
                case 6:
                    if (Objects.equals(student1.getCourse(), null)){
                        System.out.println("Choose a course to enroll in: Maktab Classes \n" +
                                "or Islamic Studies Diploma");
                        String course = in.nextLine();
                        enrollStudent(student1.getEmail(), course);
                        menu = false;
                    }else{
                        System.out.println("You are already enrolled in a class");
                    }
                    break;
                case 7:
                    if (student1.getMoneyOwed()>0.00){
                        System.out.println("How much do you want to pay?");
                        double pay = in.nextDouble();
                        if (pay>student1.getMoneyOwed()){
                            System.out.println("Payment is too high, max is: " + student1.getMoneyOwed());
                        }else{
                            student1.setMoneyOwed(makePayment(student1.getEmail(), student1.getCourse(), pay, student1.getMoneyOwed()));
                        }
                    }else{
                        System.out.println("You have no need to make a payment");
                    }
                    break;
                case 8:
                    Optional<EmergencyContact> emerg = getEmergencyContact(student1.getEmail());
                    if (emerg.isPresent()){
                        System.out.println(emerg.toString());
                    }else{
                        System.out.println("You have no emergency contact");
                    }
            }
        }
    }


    public static void teacherMenu(Teacher teacher1){
        while(menu){
            System.out.println("Do you want to: " +
                    "1. View your teacher details" +
                    "2. Edit your teacher details" +
                    "3. Mark attendance for a class" +
                    "4. Enter student marks for an exam");
        }
    }
}
