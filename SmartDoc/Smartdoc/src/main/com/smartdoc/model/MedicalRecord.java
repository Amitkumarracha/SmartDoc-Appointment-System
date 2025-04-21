package main.com.smartdoc.model;

public class MedicalRecord {
    private String diagnosis;
    private String treatment;

    public MedicalRecord(String diagnosis, String treatment) {
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }
}
