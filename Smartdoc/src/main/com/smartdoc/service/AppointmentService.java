package main.com.smartdoc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.com.smartdoc.util.DatabaseConnection;

public class AppointmentService {
    public String bookAppointment(String appointmentDetails) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO appointments (details) VALUES (?)"; 
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, appointmentDetails);
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                return "Appointment booked: " + appointmentDetails;
            } else {
                return "Failed to book appointment";
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            return "Error booking appointment: " + e.getMessage();
        }
    }

    public String getAppointmentById(int id) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM appointments WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                String details = rs.getString("details");
                return "Details for appointment ID: " + id + " - " + details;
            } else {
                return "No appointment found with ID: " + id;
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            return "Error retrieving appointment: " + e.getMessage();
        }
    }
}