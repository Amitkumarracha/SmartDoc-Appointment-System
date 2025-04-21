package main.com.smartdoc.controller;

public class DoctorController {


    public String getDoctors() {
        return "List of available doctors";
    }

    public String addDoctor(String doctorDetails) {
        return "Doctor added: " + doctorDetails;
    }
}
