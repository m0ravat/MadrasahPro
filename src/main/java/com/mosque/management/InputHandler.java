package com.mosque.management;

import com.mosque.management.database.LoginSignUpQueries;
import com.mosque.management.users.EmergencyContact;
import com.mosque.management.users.Student;
import com.mosque.management.users.Teacher;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

public class InputHandler {
    public static Student promptSignup() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the following credentials: ");
        System.out.println("Email (username) : ");
        String email = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();
        System.out.println("First name: ");
        String firstName = sc.nextLine();
        System.out.println("Last name: ");
        String lastName = sc.nextLine();


        System.out.println("Day born: ");
        int day = sc.nextInt();
        sc.nextLine(); // Consume leftover newline

        System.out.println("Month born (1-12): ");
        int month = sc.nextInt();
        sc.nextLine(); // Consume leftover newline

        System.out.println("Year born: ");
        int year = sc.nextInt();
        sc.nextLine(); // Consume leftover newline

        System.out.println("Address: ");
        String address = sc.nextLine();

        System.out.println("Telephone Number: ");
        String telephone = sc.nextLine();

        System.out.println("Allergies: ");
        String allergies = sc.nextLine();

        // Assuming addEmergency() returns an EmergencyContact object
        EmergencyContact emergencyContact2 = addEmergency();

        // Convert to java.sql.Date
        Date doB = parseSqlDate(day, month, year);

        return new Student(firstName, lastName, (java.sql.Date) doB, email, address, telephone,
                password, allergies, emergencyContact2);
    }

    private static EmergencyContact addEmergency() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the following credentials for an emergency contact: ");
        System.out.println("First name: ");
        String firstName = sc.nextLine();
        System.out.println("Last name: ");
        String lastName = sc.nextLine();
        System.out.println("Email: ");
        String email = sc.nextLine();

        System.out.println("Day born: ");
        int day = sc.nextInt();
        sc.nextLine(); // Consume leftover newline

        System.out.println("Month born (1-12): ");
        int month = sc.nextInt();
        sc.nextLine(); // Consume leftover newline

        System.out.println("Year born: ");
        int year = sc.nextInt();
        sc.nextLine(); // Consume leftover newline

        // Convert to java.sql.Date
        Date doB = parseSqlDate(day, month, year);

        System.out.println("Address: ");
        String address = sc.nextLine();

        System.out.println("Telephone Number: ");
        String telephone = sc.nextLine();

        return new EmergencyContact(firstName, lastName, (java.sql.Date) doB, email, address, telephone);
    }

    private static Date parseSqlDate(int day, int month, int year) {
        String dateString = day + "/" + month + "/" + year;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            java.util.Date utilDate = sdf.parse(dateString); // Get util.Date
            return new java.sql.Date(utilDate.getTime());    // Convert to sql.Date
        } catch (ParseException e) {
            System.out.println("Invalid date format.");
            e.printStackTrace();
            return null;
        }
    }
    public static Optional<Student> loginStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = sc.nextLine();
        System.out.println("Enter your password: ");
        String password = sc.nextLine();

        Optional<Student> student = LoginSignUpQueries.getStudentFromDB(username, password);
        if (student.isPresent()) {
            System.out.println("Login successful! Welcome, " + student.get().getFirstName());
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
        return student;
    }

    public static Optional<Teacher> loginTeacher() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = sc.nextLine();
        System.out.println("Enter your password: ");
        String password = sc.nextLine();

        Optional<Teacher> teacher = LoginSignUpQueries.getTeacherFromDB(username, password);
        if (teacher.isPresent()) {
            System.out.println("Login successful! Welcome, " + teacher.get().getFirstName());
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
        return teacher;
    }

}
