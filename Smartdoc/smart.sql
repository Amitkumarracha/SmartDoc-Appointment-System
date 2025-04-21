-- SmartDoc Database Setup Script
CREATE DATABASE IF NOT EXISTS smart;
USE smart;
-- Drop tables if they exist to avoid errors
DROP TABLE IF EXISTS payments;
DROP TABLE IF EXISTS appointments;
DROP TABLE IF EXISTS doctors;
DROP TABLE IF EXISTS patients;
DROP TABLE IF EXISTS users;

-- Create users table for authentication
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create patients table
CREATE TABLE patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    details TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create doctors table
CREATE TABLE doctors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    details TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create appointments table
CREATE TABLE appointments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    details TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create payments table
CREATE TABLE payments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    details TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert some sample data
INSERT INTO users (username, password) VALUES ('admin', 'admin123');
INSERT INTO users (username, password) VALUES ('doctor1', 'doctor123');
INSERT INTO users (username, password) VALUES ('patient1', 'patient123');

INSERT INTO doctors (details) VALUES ('Dr. John Smith, Cardiologist');
INSERT INTO doctors (details) VALUES ('Dr. Sarah Johnson, Pediatrician');

INSERT INTO patients (details) VALUES ('James Brown, 45, Male, Hypertension');
INSERT INTO patients (details) VALUES ('Emily Davis, 32, Female, Diabetes');

INSERT INTO appointments (details) VALUES ('Patient: James Brown, Doctor: Dr. John Smith, Date: 2023-06-15 10:00 AM');
INSERT INTO appointments (details) VALUES ('Patient: Emily Davis, Doctor: Dr. Sarah Johnson, Date: 2023-06-16 2:30 PM');

INSERT INTO payments (details) VALUES ('Payment for appointment #1, Amount: $150, Status: Paid');
INSERT INTO payments (details) VALUES ('Payment for appointment #2, Amount: $120, Status: Pending');


select * from users;

select * from appointments;