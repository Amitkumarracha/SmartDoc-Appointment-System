package main.com.smartdoc.exception;

public class DoctorUnavailableException extends Exception {
    public DoctorUnavailableException(String message) {
        super(message);
    }
}