package main.com.smartdoc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.com.smartdoc.util.DatabaseConnection;

public class PatientService {
    public String registerPatient(String patientDetails) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO patients (details) VALUES (?)"; 
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, patientDetails);
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                return "Patient registered: " + patientDetails;
            } else {
                return "Failed to register patient";
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            return "Error registering patient: " + e.getMessage();
        }
    }

    public String getPatientProfile(int id) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM patients WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                String details = rs.getString("details");
                return "Patient profile for ID: " + id + " - " + details;
            } else {
                return "No patient found with ID: " + id;
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            return "Error retrieving patient profile: " + e.getMessage();
        }
    }
}
