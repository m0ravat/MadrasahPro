package com.mosque.management.database;

import com.mosque.management.education.Course;
import com.mosque.management.education.Subject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;

public class CourseQueries {
    private static final String URL = "jdbc:mysql://localhost:3306/madrasah";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Course returnCourse(String name) {
        String loginSQL = "SELECT * FROM Course WHERE courseName= ? ";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(loginSQL)) {

            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Course(
                        rs.getString("courseName"),
                        rs.getString("shortDesc"),
                        rs.getString("longDesc"),
                        rs.getInt("duration"),
                        rs.getDouble("price")
                );
            }
        } catch (SQLException e) {
            System.out.println("Student login failed: " + e.getMessage());
        }
        return null;
    }
    public static List<Subject> generateSubjects(String courseName) {
        List<Subject> subjects = new ArrayList<>();

        String sql = "SELECT subjectName, shortDesc, overview, outcome, duration, startYear " +
                "FROM Subject WHERE courseName = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, courseName);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                subjects.add(new Subject(
                        rs.getString("subjectName"),
                        rs.getString("shortDesc"),
                        rs.getString("overview"),
                        rs.getString("outcome"),
                        rs.getInt("duration"),
                        rs.getString("startYear")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error fetching subjects: " + e.getMessage());
        }

        return subjects;
    }

    public static double makePayment(String email, String course, double money, double debt) {
        LocalDate today = LocalDate.now();

        // SQL queries
        String receiptSQL = "INSERT INTO PaymentReceipt (dateMade, amount, courseName, studentEmail) VALUES (?, ?, ?, ?)";
        String debtSQL = "UPDATE Student SET moneyOwed = ? WHERE email = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Disable auto-commit to start a transaction
            conn.setAutoCommit(false);

            try (PreparedStatement receiptStmt = conn.prepareStatement(receiptSQL);
                 PreparedStatement debtStmt = conn.prepareStatement(debtSQL)) {

                // Insert payment receipt
                receiptStmt.setDate(1, Date.valueOf(today));
                receiptStmt.setDouble(2, money);
                receiptStmt.setString(3, course);
                receiptStmt.setString(4, email);

                int rowsInserted = receiptStmt.executeUpdate();
                if (rowsInserted <= 0) {
                    throw new SQLException("Failed to insert payment receipt.");
                }

                // Update student debt
                debtStmt.setDouble(1, debt);
                debtStmt.setString(2, email);

                int rowsUpdated = debtStmt.executeUpdate();
                if (rowsUpdated <= 0) {
                    throw new SQLException("Failed to update student debt.");
                }

                // Commit the transaction
                conn.commit();
                System.out.println("Payment and debt update processed successfully!");
                return debt - money;

            } catch (SQLException e) {
                // Rollback the transaction in case of an error
                conn.rollback();
                System.out.println("Transaction rolled back due to error: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error during payment processing: " + e.getMessage());
        }
        return debt;
    }
}
