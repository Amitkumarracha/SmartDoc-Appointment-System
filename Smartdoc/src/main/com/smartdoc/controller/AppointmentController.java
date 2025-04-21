package main.com.smartdoc.controller;

import main.com.smartdoc.service.AppointmentService;

public class AppointmentController {
    private AppointmentService appointmentService;
    
    public AppointmentController() {
        this.appointmentService = new AppointmentService();
    }
    
    public String bookAppointment(String appointmentDetails) {
        return appointmentService.bookAppointment(appointmentDetails);
    }

    public String getAppointment(int id) {
        return appointmentService.getAppointmentById(id);
    }
}
