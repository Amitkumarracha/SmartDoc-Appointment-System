package main.com.smartdoc.dao;


import main.com.smartdoc.model.Doctor;
import java.util.List;

public interface DoctorDAO extends DAO<Doctor> {
    List<Doctor> getDoctorsBySpecialization(String specialization);
}