package main.com.smartdoc.controller;

public class AdminController {
    public String getAdminDashboard() {
        return "Admin dashboard loaded successfully";
    }
    
    public void showAllAdmins() {
        System.out.println("Showing all admin users in the system...");
        System.out.println("Admin1: John Doe (System Administrator)");
        System.out.println("Admin2: Jane Smith (Database Administrator)");
    }
}