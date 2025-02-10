package com.mosque.management;

import com.mosque.management.database.AccountQueries;
import com.mosque.management.users.EmergencyContact;
import com.mosque.management.users.Student;
import com.mosque.management.users.Teacher;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

import static com.mosque.management.database.AccountQueries.updateStudentDB;
import static com.mosque.management.database.AccountQueries.updateTeacherDB;

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

        Optional<Student> student = AccountQueries.getStudentFromDB(username, password);
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

        Optional<Teacher> teacher = AccountQueries.getTeacherFromDB(username, password);
        if (teacher.isPresent()) {
            System.out.println("Login successful! Welcome, " + teacher.get().getFirstName());
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
        return teacher;
    }
    public static void editDetails(Student student) {
        Scanner in = new Scanner(System.in);

        System.out.println("Editing details for student: " + student.getEmail());
        System.out.println("Leave blank to keep the current value.");

        // Prompt for new values
        System.out.print("Enter new first name (" + student.getFirstName() + "): ");
        String newFirstName = in.nextLine().trim();
        if (!newFirstName.isEmpty()) {
            student.setFirstName(newFirstName);
        }

        System.out.print("Enter new last name (" + student.getLastName() + "): ");
        String newLastName = in.nextLine().trim();
        if (!newLastName.isEmpty()) {
            student.setLastName(newLastName);
        }

        System.out.print("Enter new date of birth (" + student.getDoB() + ") (format yyyy/mm/dd): ");
        String newDoB = in.nextLine().trim();
        if (!newDoB.isEmpty()) {
            student.setDoB(java.sql.Date.valueOf(newDoB));
        }

        System.out.print("Enter new address (" + student.getAddress() + "): ");
        String newAddress = in.nextLine().trim();
        if (!newAddress.isEmpty()) {
            student.setAddress(newAddress);
        }

        System.out.print("Enter new telephone number (" + student.getTelNo() + "): ");
        String newTelNo = in.nextLine().trim();
        if (!newTelNo.isEmpty()) {
            student.setTelNo(newTelNo);
        }

        System.out.print("Enter new allergies (" + student.getAllergies() + "): ");
        String newAllergies = in.nextLine().trim();
        if (!newAllergies.isEmpty()) {
            student.setAllergies(newAllergies);
        }

        System.out.print("Enter new password: ");
        String newPassword = in.nextLine().trim();
        System.out.println("Confirm password: ");
        String confirmPassword = in.nextLine().trim();
        if (!newPassword.isEmpty() && confirmPassword.equals(newPassword)) {
            student.setPassword(newPassword);
        }

        // Update the database
        updateStudentDB(student);
    }
    public static void editDetails(Teacher teacher) {
        Scanner in = new Scanner(System.in);

        System.out.println("Editing details for teacher: " + teacher.getEmail());
        System.out.println("Leave blank to keep the current value.");

        // Prompt for new values
        System.out.print("Enter new first name (" + teacher.getFirstName() + "): ");
        String newFirstName = in.nextLine().trim();
        if (!newFirstName.isEmpty()) {
            teacher.setFirstName(newFirstName);
        }

        System.out.print("Enter new last name (" + teacher.getLastName() + "): ");
        String newLastName = in.nextLine().trim();
        if (!newLastName.isEmpty()) {
            teacher.setLastName(newLastName);
        }

        System.out.print("Enter new date of birth (" + teacher.getDoB() + ") (format yyyy/mm/dd): ");
        String newDoB = in.nextLine().trim();
        if (!newDoB.isEmpty()) {
            teacher.setDoB(java.sql.Date.valueOf(newDoB));
        }

        System.out.print("Enter new address (" + teacher.getAddress() + "): ");
        String newAddress = in.nextLine().trim();
        if (!newAddress.isEmpty()) {
            teacher.setAddress(newAddress);
        }

        System.out.print("Enter new telephone number (" + teacher.getTelNo() + "): ");
        String newTelNo = in.nextLine().trim();
        if (!newTelNo.isEmpty()) {
            teacher.setTelNo(newTelNo);
        }

        System.out.print("Enter new allergies (" + teacher.getAllergies() + "): ");
        String newAllergies = in.nextLine().trim();
        if (!newAllergies.isEmpty()) {
            teacher.setAllergies(newAllergies);
        }

        System.out.print("Enter new password: ");
        String newPassword = in.nextLine().trim();
        System.out.println("Confirm password: ");
        String confirmPassword = in.nextLine().trim();
        if (!newPassword.isEmpty() && confirmPassword.equals(newPassword)) {
            teacher.setPassword(newPassword);
        }

        // Update the database
        updateTeacherDB(teacher);
    }

}
