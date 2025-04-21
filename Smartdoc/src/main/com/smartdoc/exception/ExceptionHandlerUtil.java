package main.com.smartdoc.exception;


// utility class that demonstrates how to call all these exceptions. This will be a helper class that shows example scenarios where each exception might be thrown.

import main.com.smartdoc.exception.*;
import main.com.smartdoc.dto.AppointmentDTO;
import main.com.smartdoc.dto.UserDTO;
import java.time.LocalDateTime;

public class ExceptionHandlerUtil {

    // Method demonstrating AuthenticationException
    public void authenticateUser(UserDTO userDTO) throws AuthenticationException {
        if (userDTO.getUsername() == null || userDTO.getPassword() == null) {
            throw new AuthenticationException("Username and password are required");
        }
        // Mock authentication failure
        if (!"admin".equals(userDTO.getUsername()) || !"password123".equals(userDTO.getPassword())) {
            throw new AuthenticationException("Invalid credentials");
        }
    }

    // Method demonstrating DatabaseException
    public void databaseOperation() throws DatabaseException {
        try {
            // Simulate a database operation that fails
            throw new RuntimeException("Connection timeout");
        } catch (RuntimeException e) {
            throw new DatabaseException("Database operation failed", e);
        }
    }

    // Method demonstrating AppointmentException
    public void validateAppointment(AppointmentDTO appointmentDTO) throws AppointmentException {
        if (appointmentDTO.getDoctorId() == 0 || appointmentDTO.getPatientId() == 0) {
            throw new AppointmentException("Doctor ID and Patient ID are required");
        }
    }

    // Method demonstrating DoctorUnavailableException
    public void checkDoctorAvailability(Long doctorId, LocalDateTime dateTime) throws DoctorUnavailableException {
        // Mock check - in reality this would query a database
        boolean isDoctorOnLeave = true; // Simulate doctor unavailable

        if (isDoctorOnLeave) {
            throw new DoctorUnavailableException("Doctor with ID " + doctorId + " is unavailable at the requested time");
        }
    }

    // Method demonstrating SlotUnavailableException
    public void checkSlotAvailability(Long doctorId, LocalDateTime startTime, LocalDateTime endTime)
            throws SlotUnavailableException {
        // Mock check - in reality this would query a schedule
        boolean isSlotBooked = true; // Simulate slot already taken

        if (isSlotBooked) {
            throw new SlotUnavailableException("The requested time slot is already booked");
        }
    }

    // Method demonstrating PaymentProcessingException
    public void processPayment(double amount) throws PaymentProcessingException {
        try {
            // Simulate payment processing that fails
            if (amount <= 0) {
                throw new IllegalArgumentException("Invalid payment amount");
            }
            // Mock payment gateway failure
            throw new RuntimeException("Payment gateway timeout");
        } catch (RuntimeException e) {
            throw new PaymentProcessingException("Payment processing failed", e);
        }
    }

    // Method that demonstrates handling multiple exceptions
    public void completeAppointmentBooking(AppointmentDTO appointmentDTO, double paymentAmount) {
        try {
            validateAppointment(appointmentDTO);
            Long doctorId = Long.valueOf(appointmentDTO.getDoctorId());
            checkDoctorAvailability(doctorId, appointmentDTO.getStartTime());
            checkSlotAvailability(doctorId,
                    appointmentDTO.getStartTime(),
                    appointmentDTO.getEndTime());
            processPayment(paymentAmount);
        } catch (AppointmentException | DoctorUnavailableException |
                 SlotUnavailableException | PaymentProcessingException e) {
            System.err.println("Booking failed: " + e.getMessage());
            // Additional error handling or rethrowing could be done here
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}