package com.mosque.management.database;
import java.sql.*;
public class StudentAttendanceQueries {
    private static final String URL = "jdbc:mysql://localhost:3306/madrasah";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public static void insertStudentAttendance(String email, String lesson, String mark){
        {
            String query = "INSERT INTO StudentAttendance (studentEmail, lessonName, mark) VALUES (?, ?, ?)";

            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement pstmt = conn.prepareStatement(query)) {

                pstmt.setString(1, email);
                pstmt.setString(2, lesson);
                pstmt.setString(3, mark);

                int rowsInserted = pstmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Attendance marked successfully for student: " + email);
                }

            } catch (SQLException e) {
                System.out.println("Error marking attendance: " + e.getMessage());
            }
        }

    }
    public static boolean isTeacherTeachingLesson(String email, String lesson){
        String query = "SELECT teacherEmail FROM Lesson WHERE lessonName = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, lesson);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String lessonTeacherEmail = rs.getString("teacherEmail");
                return lessonTeacherEmail.equals(email);
            }

        } catch (SQLException e) {
            System.out.println("Error checking lesson authorization: " + e.getMessage());
        }

        return false;
    }
}
