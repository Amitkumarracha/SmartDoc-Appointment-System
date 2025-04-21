package main.com.smartdoc.model;

public class Notification {
    private String message;
    private boolean isRead;

    public Notification(String message) {
        this.message = message;
        this.isRead = false;
    }

    public String getMessage() {
        return message;
    }

    public boolean isRead() {
        return isRead;
    }

    public void markAsRead() {
        this.isRead = true;
    }
}