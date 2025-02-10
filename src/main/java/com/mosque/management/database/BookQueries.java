package com.mosque.management.database;

import java.sql.*;

public class BookQueries {
    private static final String URL = "jdbc:mysql://localhost:3306/madrasah";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public static void viewBooks(String courseName) {
        String query = "SELECT b.bookName, b.bookDesc, b.author, b.price " +
                "FROM Book b " +
                "JOIN Subject s ON b.subjectName = s.subjectName " +
                "WHERE s.courseName = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, courseName);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("Books for Course: " + courseName);
            while (rs.next()) {
                System.out.println("Book Name: " + rs.getString("bookName"));
                System.out.println("Description: " + rs.getString("bookDesc"));
                System.out.println("Author: " + rs.getString("author"));
                System.out.println("Price: " + rs.getDouble("price"));
                System.out.println("-----------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving books: " + e.getMessage());
        }
    }
    public static double buyBook(String bookName, String studentEmail) {
        String getPriceQuery = "SELECT price FROM Book WHERE bookName = ?";
        String updateMoneyOwedQuery = "UPDATE Student SET moneyOwed = moneyOwed + ? WHERE email = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmtPrice = conn.prepareStatement(getPriceQuery);
             PreparedStatement pstmtUpdate = conn.prepareStatement(updateMoneyOwedQuery)) {

            // Step 1: Retrieve the book's price
            pstmtPrice.setString(1, bookName);
            ResultSet rs = pstmtPrice.executeQuery();

            if (rs.next()) {
                double bookPrice = rs.getDouble("price");

                // Step 2: Update the student's moneyOwed
                pstmtUpdate.setDouble(1, bookPrice);
                pstmtUpdate.setString(2, studentEmail);
                int rowsUpdated = pstmtUpdate.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("Book purchased successfully! £" + bookPrice + " added to your money owed.");
                    return bookPrice;
                } else {
                    System.out.println("Student not found.");
                }
            } else {
                System.out.println("Book not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error purchasing book: " + e.getMessage());
        }
        return 0;
    }
}
