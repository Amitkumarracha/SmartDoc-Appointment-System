package main.com.smartdoc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.com.smartdoc.util.DatabaseConnection;

public class PaymentService {
    public String processPayment(String paymentDetails) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO payments (details) VALUES (?)"; 
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, paymentDetails);
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                return "Payment processed: " + paymentDetails;
            } else {
                return "Failed to process payment";
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            return "Error processing payment: " + e.getMessage();
        }
    }
    
    public String getPaymentById(int id) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM payments WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                String details = rs.getString("details");
                return "Payment details for ID: " + id + " - " + details;
            } else {
                return "No payment found with ID: " + id;
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            return "Error retrieving payment: " + e.getMessage();
        }
    }
}