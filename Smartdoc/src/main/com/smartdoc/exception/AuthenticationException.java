package main.com.smartdoc.exception;

public class AuthenticationException extends Exception {
    public AuthenticationException(String message) {
        super(message);
    }
}