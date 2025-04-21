package main.com.smartdoc.controller;

public class PatientController {

    public String getPatientProfile(int id) {
        return "Patient profile for ID: " + id;
    }

    public String registerPatient(String patientDetails) {
        return "Patient registered: " + patientDetails;
    }
}
