package main.com.smartdoc.model;

public class Doctor extends User {
    private Specialization specialization;

    public Doctor(String id, String name, String email, Specialization specialization) {
        super(id, name, email);
        this.specialization = specialization;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }
}
