package com.mosque.management.database;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import com.mosque.management.education.Lesson;
public class LessonQueries {
    private static final String URL = "jdbc:mysql://localhost:3306/madrasah";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public static List<Lesson> getLessonsByTeacher(String teacherEmail) {
        List<Lesson> lessons = new ArrayList<>();
        String query = "SELECT * FROM Lesson WHERE teacherEmail = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, teacherEmail);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String lessonName = rs.getString("lessonName");
                int weekNo = rs.getInt("weekNo");
                int duration = rs.getInt("duration");
                String timeStart = rs.getString("timeStart");
                String subjectName = rs.getString("subjectName");
                String teacher = rs.getString("teacherEmail");

                Lesson lesson = new Lesson(lessonName, weekNo, duration, timeStart, subjectName, teacher);
                lessons.add(lesson);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving lessons: " + e.getMessage());
        }

        return lessons;
    }
}
