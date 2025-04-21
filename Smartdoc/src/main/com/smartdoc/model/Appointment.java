package main.com.smartdoc.model;

import java.time.LocalDateTime;

public class Appointment {
    private int id;
    private Doctor doctor;
    private Patient patient;
    private TimeSlot timeSlot;
    private AppointmentStatus status;

    public Appointment(int id, Doctor doctor, Patient patient, TimeSlot timeSlot, AppointmentStatus status) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.timeSlot = timeSlot;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }
}
