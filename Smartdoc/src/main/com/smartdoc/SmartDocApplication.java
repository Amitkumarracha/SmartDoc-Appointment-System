package main.com.smartdoc;

import java.util.Scanner;
import main.com.smartdoc.controller.AdminController;
import main.com.smartdoc.controller.AuthController;
import main.com.smartdoc.controller.AppointmentController;
import main.com.smartdoc.service.DoctorService;
import main.com.smartdoc.service.PatientService;
import main.com.smartdoc.service.PaymentService;

public class SmartDocApplication {
    private static Scanner scanner = new Scanner(System.in);
    private static AuthController authController = new AuthController();
    private static AppointmentController appointmentController = new AppointmentController();
    private static DoctorService doctorService = new DoctorService();
    private static PatientService patientService = new PatientService();
    private static PaymentService paymentService = new PaymentService();
    
    public static void main(String[] args) {
        System.out.println("👨‍⚕️ SmartDoc System is starting...");
        System.out.println("JDBC-based application without Spring annotations");
        
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1: // Authentication
                    handleAuthMenu();
                    break;
                case 2: // Appointments
                    handleAppointmentMenu();
                    break;
                case 3: // Doctors
                    handleDoctorMenu();
                    break;
                case 4: // Patients
                    handlePatientMenu();
                    break;
                case 5: // Payments
                    handlePaymentMenu();
                    break;
                case 6: // Admin
                    AdminController adminController = new AdminController();
                    adminController.showAllAdmins();
                    break;
                case 0: // Exit
                    running = false;
                    System.out.println("Thank you for using SmartDoc. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
    
    private static void displayMainMenu() {
        System.out.println("\n===== SmartDoc Main Menu =====");
        System.out.println("1. Authentication");
        System.out.println("2. Appointments");
        System.out.println("3. Doctors");
        System.out.println("4. Patients");
        System.out.println("5. Payments");
        System.out.println("6. Admin");
        System.out.println("0. Exit");
        System.out.println("=============================");
    }
    
    private static void handleAuthMenu() {
        System.out.println("\n===== Authentication Menu =====");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("0. Back to Main Menu");
        System.out.println("==============================");
        
        int choice = getIntInput("Enter your choice: ");
        
        switch (choice) {
            case 1: // Login
                System.out.print("Enter username: ");
                String loginUsername = scanner.nextLine();
                System.out.print("Enter password: ");
                String loginPassword = scanner.nextLine();
                String loginResult = authController.login(loginUsername, loginPassword);
                System.out.println(loginResult);
                break;
            case 2: // Register
                System.out.print("Enter new username: ");
                String regUsername = scanner.nextLine();
                System.out.print("Enter new password: ");
                String regPassword = scanner.nextLine();
                String regResult = authController.register(regUsername, regPassword);
                System.out.println(regResult);
                break;
            case 0: // Back
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    
    private static void handleAppointmentMenu() {
        System.out.println("\n===== Appointments Menu =====");
        System.out.println("1. Book Appointment");
        System.out.println("2. View Appointment");
        System.out.println("0. Back to Main Menu");
        System.out.println("=============================");
        
        int choice = getIntInput("Enter your choice: ");
        
        switch (choice) {
            case 1: // Book
                System.out.print("Enter appointment details: ");
                String appointmentDetails = scanner.nextLine();
                String bookResult = appointmentController.bookAppointment(appointmentDetails);
                System.out.println(bookResult);
                break;
            case 2: // View
                int appointmentId = getIntInput("Enter appointment ID: ");
                String viewResult = appointmentController.getAppointment(appointmentId);
                System.out.println(viewResult);
                break;
            case 0: // Back
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    
    private static void handleDoctorMenu() {
        System.out.println("\n===== Doctors Menu =====");
        System.out.println("1. Add Doctor");
        System.out.println("2. List All Doctors");
        System.out.println("0. Back to Main Menu");
        System.out.println("========================");
        
        int choice = getIntInput("Enter your choice: ");
        
        switch (choice) {
            case 1: // Add
                System.out.print("Enter doctor details: ");
                String doctorDetails = scanner.nextLine();
                String addResult = doctorService.addDoctor(doctorDetails);
                System.out.println(addResult);
                break;
            case 2: // List
                String listResult = doctorService.listDoctors();
                System.out.println(listResult);
                break;
            case 0: // Back
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    
    private static void handlePatientMenu() {
        System.out.println("\n===== Patients Menu =====");
        System.out.println("1. Register Patient");
        System.out.println("2. View Patient Profile");
        System.out.println("0. Back to Main Menu");
        System.out.println("==========================");
        
        int choice = getIntInput("Enter your choice: ");
        
        switch (choice) {
            case 1: // Register
                System.out.print("Enter patient details: ");
                String patientDetails = scanner.nextLine();
                String registerResult = patientService.registerPatient(patientDetails);
                System.out.println(registerResult);
                break;
            case 2: // View
                int patientId = getIntInput("Enter patient ID: ");
                String viewResult = patientService.getPatientProfile(patientId);
                System.out.println(viewResult);
                break;
            case 0: // Back
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    
    private static void handlePaymentMenu() {
        System.out.println("\n===== Payments Menu =====");
        System.out.println("1. Process Payment");
        System.out.println("2. View Payment");
        System.out.println("0. Back to Main Menu");
        System.out.println("==========================");
        
        int choice = getIntInput("Enter your choice: ");
        
        switch (choice) {
            case 1: // Process
                System.out.print("Enter payment details: ");
                String paymentDetails = scanner.nextLine();
                String processResult = paymentService.processPayment(paymentDetails);
                System.out.println(processResult);
                break;
            case 2: // View
                int paymentId = getIntInput("Enter payment ID: ");
                String viewResult = paymentService.getPaymentById(paymentId);
                System.out.println(viewResult);
                break;
            case 0: // Back
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    
    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
}
