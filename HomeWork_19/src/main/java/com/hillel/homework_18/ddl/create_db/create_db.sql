CREATE SCHEMA if not exists Student;

CREATE TABLE IF NOT EXISTS Cathedra
(
    ID_CA                  BIGINT       NOT NULL PRIMARY KEY AUTO_INCREMENT,
    cathedraName           TINYTEXT     NOT NULL,
    headOfCathedraFullName VARCHAR(150) NOT NULL
);

CREATE TABLE IF NOT EXISTS Teachers
(
    ID_TE           BIGINT       NOT NULL PRIMARY KEY AUTO_INCREMENT,
    fullTeacherName VARCHAR(150) NOT NULL,
    cathedraID      BIGINT       NOT NULL
);

CREATE TABLE IF NOT EXISTS Subjects
(
    ID_SU       BIGINT      NOT NULL PRIMARY KEY AUTO_INCREMENT,
    subjectName VARCHAR(50) NOT NULL,
    teacherID   BIGINT      NOT NULL,
    term        TINYINT     NOT NULL,
    year        SMALLINT    NOT NULL
);

CREATE TABLE IF NOT EXISTS Marks
(
    ID_M      BIGINT     NOT NULL PRIMARY KEY AUTO_INCREMENT,
    subjectID BIGINT     NOT NULL,
    studentID BIGINT     NOT NULL,
    mark      VARCHAR(3) NOT NULL
);

CREATE TABLE IF NOT EXISTS StudyGroup
(
    ID_SG     BIGINT      NOT NULL PRIMARY KEY AUTO_INCREMENT,
    groupName VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Students
(
    ID_ST                  BIGINT                NOT NULL PRIMARY KEY AUTO_INCREMENT,
    studentFullName        VARCHAR(150)          NOT NULL,
    groupID                BIGINT                NOT NULL,
    studentYearOfAdmission SMALLINT,
    isDeleted              BOOLEAN DEFAULT FALSE NOT NULL
);

ALTER TABLE IF EXISTS Teachers
    ADD
        CONSTRAINT FK_Teachers_Cathedra
            FOREIGN KEY (cathedraID)
                REFERENCES Cathedra (ID_CA)
                ON DELETE CASCADE
                ON UPDATE CASCADE;

ALTER TABLE IF EXISTS Subjects
    ADD
        CONSTRAINT FK_Subjects_Teachers
            FOREIGN KEY (teacherID)
                REFERENCES Teachers (ID_TE)
                ON DELETE CASCADE
                ON UPDATE CASCADE;

ALTER TABLE IF EXISTS Marks
    ADD
        CONSTRAINT FK_Marks_Subject
            FOREIGN KEY (subjectID)
                REFERENCES Subjects (ID_SU)
                ON DELETE CASCADE
                ON UPDATE CASCADE;

ALTER TABLE IF EXISTS Students
    ADD
        CONSTRAINT FK_Students_StudyGroup
            FOREIGN KEY (groupID)
                REFERENCES StudyGroup (ID_SG)
                ON DELETE CASCADE
                ON UPDATE CASCADE;

ALTER TABLE IF EXISTS Marks
    ADD
        CONSTRAINT FK_Marks_Students
            FOREIGN KEY (studentID)
                REFERENCES Students (ID_ST)
                ON DELETE CASCADE
                ON UPDATE CASCADE;