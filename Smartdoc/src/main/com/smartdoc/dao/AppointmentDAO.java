package main.com.smartdoc.dao;

import main.com.smartdoc.model.Appointment;
import java.util.List;

public interface AppointmentDAO extends DAO<Appointment> {
    List<Appointment> getAppointmentsByDoctorId(int doctorId);
    List<Appointment> getAppointmentsByPatientId(int patientId);
}