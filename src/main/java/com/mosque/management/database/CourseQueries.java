package com.mosque.management.database;

import com.mosque.management.education.Course;
import com.mosque.management.education.Subject;
import com.mosque.management.users.Student;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;
import java.util.Optional;

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
}
