-- SQL script to create the 'ams' database and common batch tables
-- Run this script in your MySQL server (e.g. using mysql CLI or a client)

CREATE DATABASE IF NOT EXISTS `ams` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `ams`;

-- Tables used by the application. Modify or add batches as needed.
CREATE TABLE IF NOT EXISTS `Batch62` (
  `Roll_No` INT PRIMARY KEY,
  `Student_Name` VARCHAR(255) NOT NULL,
  `Avg_Marks` INT DEFAULT 0,
  `Phone` BIGINT,
  `Email` VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `Batch63` (
  `Roll_No` INT PRIMARY KEY,
  `Student_Name` VARCHAR(255) NOT NULL,
  `Avg_Marks` INT DEFAULT 0,
  `Phone` BIGINT,
  `Email` VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `Batch64` (
  `Roll_No` INT PRIMARY KEY,
  `Student_Name` VARCHAR(255) NOT NULL,
  `Avg_Marks` INT DEFAULT 0,
  `Phone` BIGINT,
  `Email` VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Basic staff table for authentication
CREATE TABLE IF NOT EXISTS `staff` (
  `username` VARCHAR(100) PRIMARY KEY,
  `password` VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Note: The existing Java code refers to a database named 'Vcube'.
-- To use the new 'ams' database, update JDBC URLs in the DAO classes
-- from 'jdbc:mysql://localhost:3306/Vcube' to 'jdbc:mysql://localhost:3306/ams'.

-- End of script
