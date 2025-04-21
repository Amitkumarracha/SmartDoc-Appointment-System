# SmartDoc Application

A simple Java application for managing a medical clinic without Spring framework, using pure JDBC for database connectivity.

## Project Overview

SmartDoc is a terminal-based application that provides functionality for:
- User authentication (login/register)
- Appointment management
- Doctor management
- Patient management
- Payment processing

## Setup Instructions

### Prerequisites

- Java JDK 8 or higher
- MySQL database
- JDBC MySQL Connector (included in the lib folder)

### Database Setup

1. Create a MySQL database named `smartdoc`
2. Run the SQL script to set up the database tables:
   ```
   mysql -u root -p smartdoc < database_setup.sql
   ```
   Or you can run the script using MySQL Workbench or another SQL client.

### Running the Application

1. Compile the Java files:
   ```
   javac -d bin -cp lib/mysql-connector-java-8.0.28.jar src/main/com/smartdoc/SmartDocApplication.java src/main/com/smartdoc/controller/*.java src/main/com/smartdoc/service/*.java src/main/com/smartdoc/util/*.java
   ```

2. Run the application:
   ```
   java -cp bin;lib/mysql-connector-java-8.0.28.jar main.com.smartdoc.SmartDocApplication
   ```
   Note: On Unix/Linux/Mac, use `:` instead of `;` in the classpath.

## Database Configuration

The database connection settings are in `src/main/com/smartdoc/util/DatabaseConnection.java`. Modify the following constants if needed:

- `URL`: JDBC URL for your MySQL database
- `USER`: MySQL username
- `PASSWORD`: MySQL password

## Project Structure

- `controller/`: Contains controller classes that handle user interactions
- `service/`: Contains service classes that implement business logic and database operations
- `util/`: Contains utility classes like database connection
- `model/`: Contains data model classes (to be implemented)
- `exception/`: Contains custom exception classes

## Notes

- This application uses plain JDBC for database operations without any ORM framework
- All Spring annotations have been removed to make it a pure Java application
- The application provides a simple terminal-based menu system for interaction