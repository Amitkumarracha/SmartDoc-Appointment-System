package main.com.smartdoc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.com.smartdoc.util.DatabaseConnection;

public class DoctorService {
    public String addDoctor(String doctorDetails) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO doctors (details) VALUES (?)"; 
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, doctorDetails);
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                return "Doctor added: " + doctorDetails;
            } else {
                return "Failed to add doctor";
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            return "Error adding doctor: " + e.getMessage();
        }
    }

    public String listDoctors() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM doctors";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            StringBuilder result = new StringBuilder("List of all doctors:\n");
            boolean found = false;
            
            while (rs.next()) {
                found = true;
                int id = rs.getInt("id");
                String details = rs.getString("details");
                result.append("ID: ").append(id).append(" - ").append(details).append("\n");
            }
            
            if (!found) {
                return "No doctors found in the database";
            }
            
            return result.toString();
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            return "Error retrieving doctors: " + e.getMessage();
        }
    }
}