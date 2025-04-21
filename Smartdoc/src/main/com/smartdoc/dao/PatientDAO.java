package main.com.smartdoc.dao;



import main.com.smartdoc.model.Patient;

public interface PatientDAO extends DAO<Patient> {
    Patient getPatientByEmail(String email);
}