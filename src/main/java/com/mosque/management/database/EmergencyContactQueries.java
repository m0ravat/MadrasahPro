package com.mosque.management.database;

import com.mosque.management.users.EmergencyContact;
import com.mosque.management.users.Teacher;

import java.sql.*;
import java.util.Optional;

public class EmergencyContactQueries {
    private static final String URL = "jdbc:mysql://localhost:3306/madrasah";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public static Optional<EmergencyContact> getEmergencyContact(String email){
        String loginSQL = "SELECT * FROM EmergencyContact WHERE studentEmail = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(loginSQL)) {

            pstmt.setString(1, email);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return Optional.of(new EmergencyContact(
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getDate("doB"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("telNo")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Emergency contact fetch failed: " + e.getMessage());
        }
        return Optional.empty();
    }
}
