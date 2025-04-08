# 🏥 Smart Doc - Doctor Appointment System
Smart Doc is a comprehensive Java-based Doctor Appointment Management System designed to streamline the booking, management, and tracking 
of medical appointments. It provides tailored functionalities for patients, doctors, and admins, built using core Java concepts and backed by a robust relational database.

---

 📌 Table of Contents

- [🚀 Features](#-features)
- [🗂️ Project Structure](#️-project-structure)
- [🛠️ Technologies Used](#️-technologies-used)
- [🧠 Core Concepts](#-core-concepts)
- [🧱 Database Schema](#-database-schema)
- [🖼️ ER Diagram](#️-er-diagram)
- [📚 Usage](#-usage)
- [📦 Future Improvements](#-future-improvements)

---

 ## 🚀 Features

- 🔐 User authentication with roles (Patient, Doctor, Admin)
- 👨‍⚕️ Doctor profile management and availability slots
- 🧑‍💻 Patient onboarding and insurance handling
- 📅 Smart appointment booking and cancellation
- 💊 Electronic Medical Records (EMR)
- 💳 Payment processing with support for insurance
- 📢 Notification system (Email, SMS, In-App)
- ⭐ Doctor reviews and rating system


---

## 🗂️ Project Structure
```markdown



SmartDoc/
│
├── src/
│   ├── Main.java
│   ├── models/
│   ├── utils/
│   ├── dao/
│   └── services/
│
├── db/
│   └── schema.sql
│
├── docs/
│   └── ER-Diagram.png
│
├── assets/
│   └── logo.png
│
└── README.md
```

---

## 🛠️ Technologies Used

- 💻 Java (Core Concepts, OOP, Threads, Exceptions)
- 🗃️ MySQL for relational data handling
- 🧠 JDBC (Java Database Connectivity)
- 📈 Git & GitHub for version control
- 📄 Markdown for documentation

---

## 🧠 Core Concepts

- Object-Oriented Programming (Inheritance, Encapsulation)
- Multi-threading for concurrent operations (e.g. email triggers)
- Exception handling for stability
- Relational database design with normalized tables
- Foreign key constraints and indexing for optimized queries

---

## 🧱 Database Schema

The database includes the following main tables:

- `users`: Login and role-based access
- `patients`, `doctors`: Profile info
- `appointments`, `time_slots`: Scheduling logic
- `medical_records`, `payments`, `insurance_providers`, `patient_insurance`
- `reviews`, `notifications`, `specializations`, `doctor_specializations`


The Entity-Relationship (ER) Diagram shows relationships between core entities:
- 1-to-Many: One doctor can have many time slots
- Many-to-Many: Doctors & specializations
- Foreign key constraints and normalized mapping for integrity

---

## 📚 Usage

- **Patient**: Register, login, browse doctors, book appointments, view medical history
- **Doctor**: Login, manage slots, access patient records, write prescriptions
- **Admin**: Oversee the system, verify doctor registrations, analytics

---

## 📦 Future Improvements

- Add GUI using JavaFX or Swing
- Integrate real-time notifications (email/SMS API)
- Add admin dashboards with analytics
- Enable video consultation module
- Support for electronic prescriptions PDF generation

---


Developed by- 
Bhoomika Kapde
AMitkumar Racha
Deepesh Srivastava
Palak Sharma
