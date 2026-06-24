# EduTrackr — Smart Tracking of Student Data & Performance

EduTrackr is a Java web application built with JSP, Servlets, JDBC, and MySQL to help schools manage student attendance and academic performance efficiently.

## 🚀 Project Overview

This project delivers a complete student management experience, including:

- Staff and student login flows
- Attendance entry and monitoring
- Academic marks tracking
- Student registration and profile management
- Data display pages for attendance and student records
- Export support via Excel utility

## 🧩 Key Features

- **Staff login** and **student login** using separate authentication
- **Attendance capture** with daily tracking and attendance reports
- **Marks management** for recording student performance
- **Student CRUD operations** (create, view, edit)
- **Web interface** using JSP and CSS
- **Database support** with MySQL and SQL schema setup script

## 🛠️ Technology Stack

- Java 8+ / Java Servlets
- JSP (JavaServer Pages)
- JDBC for database access
- MySQL / MariaDB
- HTML, CSS, JavaScript
- Apache Tomcat or any compatible Servlet container

## 📁 Project Structure

- `src/main/java/com/controller/` — servlet controllers for student, attendance, marks, and login flows
- `src/main/java/com/DAO/` — data access interfaces and implementations
- `src/main/java/com/Model/` — domain models for students, staff, and attendance
- `src/main/webapp/` — JSP pages, CSS, JS, and web configuration
- `src/main/databaseFiles/` — database schema and sample data files

## 🧪 Setup Instructions

1. Install Java and MySQL.
2. Create a database and import `src/main/databaseFiles/create_ams_db.sql`.
3. Configure the database connection in your project (JDBC URL, username, password).
4. Import the project into Eclipse or IntelliJ as a Dynamic Web Project.
5. Deploy to Apache Tomcat.
6. Open the project URL in a browser to access the dashboard.

## 🎯 Usage

- Access `StudentLogin.jsp` for student users
- Access `StaffLogin.jsp` for staff users
- Use `InsertStudent.jsp` to add new student records
- View attendance via `Attendance.jsp` and `AttendanceData.jsp`
- Manage marks through `Marks.jsp`
- Navigate student records with `Students_Data.jsp` and `ViewStudents.jsp`

## 💡 Notes for Recruiters

This repository demonstrates the ability to build full-stack Java web applications with:

- layered architecture (controllers, DAO, models)
- dynamic JSP-based views
- database integration and data persistence
- modular web application design for student management

## 📌 Contact

For more details or a demo, connect via GitHub.
