package com.mosque.management.database;
import com.mosque.management.education.Exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.*;
public class ExamQueries {
    private static final String URL = "jdbc:mysql://localhost:3306/madrasah";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public static List<Exam> getExamsByTeacher(String teacherEmail) {
        List<Exam> exams = new ArrayList<>();
        String query = "SELECT examID, total, type, weekTaken, subjectName, teacherEmail FROM Exam WHERE teacherEmail = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, teacherEmail);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int examID = rs.getInt("examID");
                double total = rs.getDouble("total");
                String type = rs.getString("type");
                int weekTaken = rs.getInt("weekTaken");
                String subjectName = rs.getString("subjectName");
                String teacher = rs.getString("teacherEmail");

                // Create an Exam object and add it to the list
                Exam exam = new Exam(examID, total, type, weekTaken, subjectName, teacher);
                exams.add(exam);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving exams: " + e.getMessage());
        }

        return exams;
    }
    public static void insertExamResult(String studentEmail, int examID, double mark) {
        String query = "INSERT INTO ExamResult (studentEmail, examID, mark) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, studentEmail);
            pstmt.setInt(2, examID);
            pstmt.setDouble(3, mark);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Exam mark entered successfully for student: " + studentEmail);
            }

        } catch (SQLException e) {
            System.out.println("Error entering exam mark: " + e.getMessage());
        }
    }

    public static boolean isTeacherLeadingExam(String teacherEmail, int examID) {
        String query = "SELECT teacherEmail FROM Exam WHERE examID = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, examID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String examTeacherEmail = rs.getString("teacherEmail");
                return examTeacherEmail.equals(teacherEmail);
            }

        } catch (SQLException e) {
            System.out.println("Error checking exam authorization: " + e.getMessage());
        }

        return false;
    }
}
