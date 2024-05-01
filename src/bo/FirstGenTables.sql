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

    FOREIGN KEY (samID) REFERENCES person(samID) on DELETE CASCADE

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

    eventID INT,
    e_name VARCHAR(255),
    samID INT,
    date DATE,
    PRIMARY KEY (eventID, e_name),

    FOREIGN KEY (samID) REFERENCES person(samID)
);

-- Create junction table student_event for event table
CREATE TABLE IF NOT EXISTS student_event (

    samID INT PRIMARY KEY,
    student_attend VARCHAR(255),
    eventID INT,
    e_name VARCHAR(255),
    FOREIGN KEY (samID) REFERENCES student(samID),
    FOREIGN KEY (eventID, e_name) REFERENCES event(eventID, e_name)

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

insert into person values(000376298, 'Dougathy Gilbert', 'dgilbert@shsu.edu', '2004-04-27');
insert into mentor values(000376298, 'dGilbert', 'PhamLover<3!');
insert into person values(1, 'James', 'James@shsu.edu', '1968-04-27');
insert into mentor values(1, 'mentor1', 'mentor1');
insert into person values(000289736, 'Gary Dinglesnorpee', 'gqd123@shsu.edu', '2015-06-10');
insert into student values(000289736, 'Theatre Arts', 'Criminal Justice', '2.01', '000376298');
insert into person values(000434461, 'Marlin Tower II', 'mxt092@firstgen.com', '2001-12-09');
insert into mentor values(000434461, 'mTower2', 'Seven7Seven$$');
insert into person values(000897239, 'Betsy Hepititus', 'student1@firstgen.com', '1969-06-09');
insert into student values(000897239, 'Criminal Justice', 'N/A', '1.52', '000434461');
insert into person values(000234768, 'Peter Griffin', 'plg523@shsu.edu', '1966-07-18');
insert into mentor values(000234768, 'pGriffin', 'ShutUpMeg*1738');
insert into person values(000987546, 'Conye Northsouth', 'con@firstgen.com', '1984-03-16');
insert into student values(000987546, 'Political Science', 'Rapping', '3.94', '000234768');
insert into event values(1, 'Party Rokkers', 000376298, '2005-01-01');
insert into student_event values(000289736, 'Yes', 1, 'Party Rokkers');


update mentor set password = 'dzZpLdLX5wJ3ZQVlVNgEMIAgohibt2k444Gqt6PuUlQ='
where samID = 1;


select * from person;
select * from mentor;
select * from student;
select * from event;
select * from student_event;

