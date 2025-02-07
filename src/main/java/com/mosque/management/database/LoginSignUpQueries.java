package com.mosque.management.database;

import java.sql.*;
import java.util.Optional;

import com.mosque.management.users.Student;
import com.mosque.management.users.EmergencyContact;
import com.mosque.management.users.Teacher;

public class LoginSignUpQueries {

    private static final String URL = "jdbc:mysql://localhost:3306/madrasah";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void insertNewStudentToDB(Student student) {
        String studentSql = "INSERT INTO Student (email, firstName, lastName, doB, address, telNo, allergies, password, punctuality, moneyOwed, attendance) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(studentSql)) {

            if (conn != null) {
                System.out.println("Connected to MySQL database!");
            }

            // Set student details
            pstmt.setString(1, student.getEmail());
            pstmt.setString(2, student.getFirstName());
            pstmt.setString(3, student.getLastName());
            pstmt.setDate(4, student.getDoB());
            pstmt.setString(5, student.getAddress());
            pstmt.setString(6, student.getTelNo());
            pstmt.setString(7, student.getAllergies());
            pstmt.setString(8, student.getPassword());

            // Default values for punctuality, moneyOwed, and attendance
            pstmt.setDouble(9, 0.0);  // Default punctuality
            pstmt.setDouble(10, 0.0); // Default moneyOwed
            pstmt.setDouble(11, 100.0); // Default attendance (100% initially)

            // Execute the query
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Student inserted successfully!");

                // Insert Emergency Contact after student
                insertEmergencyContact(student.getEmergencyContact(), student.getEmail());
            }

        } catch (SQLException e) {
            System.out.println("Student insertion failed: " + e.getMessage());
        }
    }

    private static void insertEmergencyContact(EmergencyContact contact, String studentEmail) {
        String emergencySql = "INSERT INTO EmergencyContact (firstName, lastName, doB, email, address, telNo, studentEmail) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(emergencySql)) {

            // Set emergency contact details
            pstmt.setString(1, contact.getFirstName());
            pstmt.setString(2, contact.getLastName());
            pstmt.setDate(3, contact.getDoB());
            pstmt.setString(4, contact.getEmail());
            pstmt.setString(5, contact.getAddress());
            pstmt.setString(6, contact.getTelNo());
            pstmt.setString(7, studentEmail); // Foreign key linking to student

            // Execute the query
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Emergency contact inserted successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Emergency contact insertion failed: " + e.getMessage());
        }
    }
    public static Optional<Student> getStudentFromDB(String username, String password) {
        String loginSQL = "SELECT * FROM Student WHERE email = ? AND password = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(loginSQL)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return Optional.of(new Student(
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getDate("doB"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("telNo"),
                        rs.getString("password"),
                        rs.getString("allergies"),
                        null // Emergency contact retrieval can be added later
                ));
            }
        } catch (SQLException e) {
            System.out.println("Student login failed: " + e.getMessage());
        }
        return Optional.empty();
    }

    public static Optional<Teacher> getTeacherFromDB(String username, String password) {
        String loginSQL = "SELECT * FROM Teacher WHERE email = ? AND password = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(loginSQL)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return Optional.of(new Teacher(
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getDate("doB"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("telNo"),
                        rs.getString("Allergies"),
                        rs.getString("password"),
                        rs.getDouble("salary"),
                        rs.getString("CV"),
                        rs.getInt("hours")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Teacher login failed: " + e.getMessage());
        }
        return Optional.empty();
    }
}

