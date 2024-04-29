DROP DATABASE IF EXISTS firstgen;
CREATE DATABASE firstgen;
USE firstgen;

-- Create the Person table
CREATE TABLE IF NOT EXISTS person (
    samID INT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    date_of_birth DATE
);

-- Create the Mentor table
CREATE TABLE IF NOT EXISTS mentor (
    samID INT PRIMARY KEY,
    username VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    FOREIGN KEY (samID) REFERENCES person(samID)
);

-- Create the Student table
CREATE TABLE IF NOT EXISTS student (
    samID INT PRIMARY KEY,
    major VARCHAR(255),
    minor VARCHAR(255) DEFAULT NULL,
    gpa DECIMAL(3, 2),
    mtrId INT, 
    FOREIGN KEY (samID) REFERENCES person(samID) ON DELETE CASCADE,
    FOREIGN KEY (mtrID) REFERENCES mentor(samID)
);

-- Create the Notes table
CREATE TABLE IF NOT EXISTS notes (
    note_id INT PRIMARY KEY,
    note TEXT,
    date DATE,
    samID INT NOT NULL,
    mtrID INT NOT NULL,
    FOREIGN KEY (samID) REFERENCES student(samID),
    FOREIGN KEY (mtrID) REFERENCES mentor(samID)
);

-- Create the Event table
CREATE TABLE IF NOT EXISTS event (
    samID INT,
    e_name VARCHAR(255),
    date DATE,
    PRIMARY KEY (samID, e_name),
    FOREIGN KEY (samID) REFERENCES person(samID)
);

-- Create junction table student_event for event table
CREATE TABLE IF NOT EXISTS student_event (
    student_id INT,
    event_id_samID INT,
    event_id_e_name VARCHAR(255),
    PRIMARY KEY (student_id, event_id_samID, event_id_e_name),
    FOREIGN KEY (student_id) REFERENCES student(samID),
    FOREIGN KEY (event_id_samID, event_id_e_name) REFERENCES event(samID, e_name)
);

-- Create the Application table
CREATE TABLE IF NOT EXISTS application (
    samID INT PRIMARY KEY,
    join_date DATE,
    FOREIGN KEY (samID) REFERENCES student(samID)
);

-- Create the Application_Info table
CREATE TABLE IF NOT EXISTS application_info (
    app_id INT PRIMARY KEY,
    app_key VARCHAR(255),
    value VARCHAR(255),
    FOREIGN KEY (app_id) REFERENCES application(samID)
);

-- INSERT INTO student(samID, name, major, minor, gpa, mtrId) VALUES ('33994', 'tom', 'science', 'food', '3.55', '89239'); 
-- Dummy Data Queries

insert into person values(1, 'Mentor1', 'mentor1@firstgen.com', '2000-01-01');
insert into mentor values(1, 'mentor1', 'mentor1');

update mentor set password = 'dzZpLdLX5wJ3ZQVlVNgEMIAgohibt2k444Gqt6PuUlQ='
where samID = 1;

select * from mentor;
select * from student;
select * from person;
