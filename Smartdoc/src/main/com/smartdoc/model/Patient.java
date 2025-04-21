package main.com.smartdoc.model;

public class Patient extends User {
    private String address;

    public Patient(String id, String name, String email, String address) {
        super(id, name, email);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}