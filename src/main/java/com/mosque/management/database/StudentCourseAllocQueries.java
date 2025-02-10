package com.mosque.management.database;
import java.sql.*;
import java.time.LocalDate;

public class StudentCourseAllocQueries {
    private static final String URL = "jdbc:mysql://localhost:3306/madrasah";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void enrollStudent(String email, String course) {
        String enrollSQL = "INSERT INTO StudentCourseAllocation (studentEmail, courseName, yearJoined, monthJoined, grade, status) VALUES (?, ?, ?, ?, ?, ?)";
        String coursePriceSQL = "SELECT price FROM Course WHERE courseName = ?";
        String updateMoneyOwedSQL = "UPDATE Student SET moneyOwed = moneyOwed + ? WHERE email = ?";

        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        String grade = "TBA";
        String status = "Unassigned";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmtEnroll = conn.prepareStatement(enrollSQL);
             PreparedStatement pstmtCoursePrice = conn.prepareStatement(coursePriceSQL);
             PreparedStatement pstmtUpdateMoneyOwed = conn.prepareStatement(updateMoneyOwedSQL)) {

            // Retrieve the course price
            pstmtCoursePrice.setString(1, course);
            ResultSet rs = pstmtCoursePrice.executeQuery();
            double coursePrice = 0.0;
            if (rs.next()) {
                coursePrice = rs.getDouble("price");
            } else {
                System.out.println("Course not found: " + course);
                return;
            }

            // Update the student's moneyOwed
            pstmtUpdateMoneyOwed.setDouble(1, coursePrice);
            pstmtUpdateMoneyOwed.setString(2, email);
            int rowsUpdated = pstmtUpdateMoneyOwed.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Student's moneyOwed updated successfully!");
            } else {
                System.out.println("Student not found: " + email);
                return;
            }

            // Enroll the student in the course
            pstmtEnroll.setString(1, email);
            pstmtEnroll.setString(2, course);
            pstmtEnroll.setInt(3, year);
            pstmtEnroll.setInt(4, month);
            pstmtEnroll.setString(5, grade);
            pstmtEnroll.setString(6, status);

            int rowsInserted = pstmtEnroll.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Course enrollment inserted successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Course enrollment insertion failed: " + e.getMessage());
        }
    }
    public static void deleteEnrollment(String email, String course, int year){
        String deleteSQL = "DELETE FROM StudentCourseAllocation WHERE studentEmail = ? AND courseName = ? " +
                "AND yearJoined = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {

            // Set the email parameter in the SQL query
            pstmt.setString(1, email);
            pstmt.setString(2, course);
            pstmt.setInt(3, year);

            // Execute the delete statement
            int rowsAffected = pstmt.executeUpdate();

            // Check if the deletion was successful
            if (rowsAffected > 0) {
                System.out.println("Course with email " + email + " was deleted successfully.");
            } else {
                System.out.println("No course found with email " + email + ". Deletion failed.");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting student enrollment: " + e.getMessage());
        }
    }
}
