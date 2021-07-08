CREATE DATABASE if not exists Student;
USE Student;

CREATE TABLE Cathedra
(
    ID_CA                  BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    cathedraName           TINYTEXT        NOT NULL,
    headOfCathedraFullName VARCHAR(150)    NOT NULL
);

CREATE TABLE Teachers
(
    ID_TE           BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    fullTeacherName VARCHAR(150)    NOT NULL,
    cathedraID      BIGINT UNSIGNED NOT NULL
);

CREATE TABLE Subjects
(
    ID_SU       BIGINT UNSIGNED   NOT NULL PRIMARY KEY AUTO_INCREMENT,
    subjectName VARCHAR(50)       NOT NULL,
    teacherID   BIGINT UNSIGNED   NOT NULL,
    term        TINYINT UNSIGNED  NOT NULL,
    year        SMALLINT UNSIGNED NOT NULL
);

CREATE TABLE Marks
(
    ID_M      BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    subjectID BIGINT UNSIGNED NOT NULL,
    studentID BIGINT UNSIGNED NOT NULL,
    mark      VARCHAR(1)      NOT NULL
);

CREATE TABLE StudyGroup
(
    ID_SG     BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    groupName VARCHAR(50)     NOT NULL
);

CREATE TABLE Students
(
    ID_ST                  BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    studentFullName        VARCHAR(150)    NOT NULL,
    groupID                BIGINT UNSIGNED NOT NULL,
    studentYearOfAdmission SMALLINT UNSIGNED
);

ALTER TABLE Teachers
    ADD
        CONSTRAINT FK_Teachers_Cathedra
            FOREIGN KEY (cathedraID)
                REFERENCES Cathedra (ID_CA)
                ON DELETE CASCADE
                ON UPDATE CASCADE;

ALTER TABLE Subjects
    ADD
        CONSTRAINT FK_Subjects_Teachers
            FOREIGN KEY (teacherID)
                REFERENCES Teachers (ID_TE)
                ON DELETE CASCADE
                ON UPDATE CASCADE;

ALTER TABLE Marks
    ADD
        CONSTRAINT FK_Marks_Subject
            FOREIGN KEY (subjectID)
                REFERENCES Subjects (ID_SU)
                ON DELETE CASCADE
                ON UPDATE CASCADE;

ALTER TABLE Students
    ADD
        CONSTRAINT FK_Students_StudyGroup
            FOREIGN KEY (groupID)
                REFERENCES StudyGroup (ID_SG)
                ON DELETE CASCADE
                ON UPDATE CASCADE;

ALTER TABLE Marks
    ADD
        CONSTRAINT FK_Marks_Students
            FOREIGN KEY (studentID)
                REFERENCES Students (ID_ST)
                ON DELETE CASCADE
                ON UPDATE CASCADE;