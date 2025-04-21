package main.com.smartdoc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.com.smartdoc.util.DatabaseConnection;

public class AuthService {
    public String login(String username, String password) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?"; 
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return "User " + username + " logged in successfully";
            } else {
                return "Invalid username or password";
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            return "Error during login: " + e.getMessage();
        }
    }

    public String register(String username, String password) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            // First check if username already exists
            String checkSql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, username);
            ResultSet rs = checkStmt.executeQuery();
            
            if (rs.next()) {
                return "Username " + username + " already exists";
            }
            
            // If username doesn't exist, insert new user
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)"; 
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                return "User " + username + " registered successfully";
            } else {
                return "Failed to register user";
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            return "Error during registration: " + e.getMessage();
        }
    }
}
