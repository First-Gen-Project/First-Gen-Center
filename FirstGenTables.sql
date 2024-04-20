
CREATE DATABASE firstgen;
USE firstgen;

-- Create the Person table
CREATE TABLE IF NOT EXISTS person (
    sam_id INT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    date_of_birth DATE
);

-- Create the Mentor table
CREATE TABLE IF NOT EXISTS mentor (
    sam_id INT PRIMARY KEY,
    username VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    FOREIGN KEY (sam_id) REFERENCES person(sam_id)
);

-- Create the Student table
CREATE TABLE IF NOT EXISTS student (
    sam_id INT PRIMARY KEY,
    major VARCHAR(255),
    minor VARCHAR(255) DEFAULT NULL,
    gpa DECIMAL(3, 2),
    mentor_id INT,
    FOREIGN KEY (sam_id) REFERENCES person(sam_id),
    FOREIGN KEY (mentor_id) REFERENCES mentor(sam_id)
);

-- Create the Notes table
CREATE TABLE IF NOT EXISTS notes (
    note_id INT PRIMARY KEY,
    note TEXT,
    date DATE,
    sam_id INT NOT NULL,
    mentor_id INT NOT NULL,
    FOREIGN KEY (sam_id) REFERENCES student(sam_id),
    FOREIGN KEY (mentor_id) REFERENCES mentor(sam_id)
);

-- Create the Event table
CREATE TABLE IF NOT EXISTS event (
    sam_id INT,
    e_name VARCHAR(255),
    date DATE,
    PRIMARY KEY (sam_id, e_name),
    FOREIGN KEY (sam_id) REFERENCES person(sam_id)
);

-- Create junction table student_event for event table
CREATE TABLE IF NOT EXISTS student_event (
    student_id INT,
    event_id_sam_id INT,
    event_id_e_name VARCHAR(255),
    PRIMARY KEY (student_id, event_id_sam_id, event_id_e_name),
    FOREIGN KEY (student_id) REFERENCES student(sam_id),
    FOREIGN KEY (event_id_sam_id, event_id_e_name) REFERENCES event(sam_id, e_name)
);

-- Create the Application table
CREATE TABLE IF NOT EXISTS application (
    sam_id INT PRIMARY KEY,
    join_date DATE,
    FOREIGN KEY (sam_id) REFERENCES student(sam_id)
);

-- Create the Application_Info table
CREATE TABLE IF NOT EXISTS application_info (
    app_id INT PRIMARY KEY,
    app_key VARCHAR(255),
    value VARCHAR(255),
    FOREIGN KEY (app_id) REFERENCES application(sam_id)
);

