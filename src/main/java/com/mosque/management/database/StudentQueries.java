package com.mosque.management.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mosque.management.users.Student;

public class StudentQueries {
    public static void insertNewStudentToDB(Student student) {

        String url = "jdbc:mysql://localhost:3306/madrasah";
        String user = "root";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("Connected to MySQL database!");
            }
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}
