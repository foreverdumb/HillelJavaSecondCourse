insert into Cathedra (cathedraName, headOfCathedraName)
values ('Product Management', 'Olivier Pedrocco');
insert into Cathedra (cathedraName, headOfCathedraName)
values ('Services', 'Elyse Riepl');
insert into Cathedra (cathedraName, headOfCathedraName)
values ('Sales', 'Elfrieda Gettings');
insert into Cathedra (cathedraName, headOfCathedraName)
values ('Marketing', 'Clare Baldi');

insert into Teachers (teacherName, cathedraID)
values ('Simone Bucham', 1);
insert into Teachers (teacherName, cathedraID)
values ('Mohandis Billiard', 2);
insert into Teachers (teacherName, cathedraID)
values ('Danny Antowski', 1);
insert into Teachers (teacherName, cathedraID)
values ('Denna Brassill', 4);
insert into Teachers (teacherName, cathedraID)
values ('Brendan Petrolli', 4);
insert into Teachers (teacherName, cathedraID)
values ('Hephzibah Adamolli', 2);
insert into Teachers (teacherName, cathedraID)
values ('Philipa Standish', 3);
insert into Teachers (teacherName, cathedraID)
values ('Elfie Keston', 4);

insert into Subjects (subjectName, teacherID, term, year)
values ('Finance', 5, 1, 2020);
insert into Subjects (subjectName, teacherID, term, year)
values ('Consumer Durables', 1, 2, 2020);
insert into Subjects (subjectName, teacherID, term, year)
values ('Health Care', 2, 1, 2020);
insert into Subjects (subjectName, teacherID, term, year)
values ('Finance', 1, 2, 2019);
insert into Subjects (subjectName, teacherID, term, year)
values ('Finance', 5, 1, 2020);
insert into Subjects (subjectName, teacherID, term, year)
values ('Technology', 2, 2, 2019);
insert into Subjects (subjectName, teacherID, term, year)
values ('Energy', 8, 1, 2020);
insert into Subjects (subjectName, teacherID, term, year)
values ('Consumer Services', 8, 2, 2019);
insert into Subjects (subjectName, teacherID, term, year)
values ('Technology', 5, 2, 2019);
insert into Subjects (subjectName, teacherID, term, year)
values ('Consumer Services', 7, 2, 2019);
insert into Subjects (subjectName, teacherID, term, year)
values ('Health Care', 6, 2, 2020);
insert into Subjects (subjectName, teacherID, term, year)
values ('Health Care', 8, 1, 2020);
insert into Subjects (subjectName, teacherID, term, year)
values ('Technology', 1, 1, 2020);
insert into Subjects (subjectName, teacherID, term, year)
values ('Energy', 2, 2, 2020);
insert into Subjects (subjectName, teacherID, term, year)
values ('Finance', 8, 1, 2020);

insert into STUDY_GROUP (groupName)
values ('GRP-101');
insert into STUDY_GROUP (groupName)
values ('GRP-201');
insert into STUDY_GROUP (groupName)
values ('GRP-301');

insert into Students (studentFullName, groupID, studentYearOfAdmission)
values ('Thomas Shingles', 1, 2016);
insert into Students (studentFullName, groupID, studentYearOfAdmission)
values ('Veronika Marguerite', 3, 2018);
insert into Students (studentFullName, groupID, studentYearOfAdmission)
values ('Lela Danett', 2, 2017);
insert into Students (studentFullName, groupID, studentYearOfAdmission)
values ('Shaylah Brideoke', 3, 2018);
insert into Students (studentFullName, groupID, studentYearOfAdmission)
values ('Thelma Shovelin', 2, 2017);
insert into Students (studentFullName, groupID, studentYearOfAdmission)
values ('Juliet Pengelly', 1, 2016);
insert into Students (studentFullName, groupID, studentYearOfAdmission)
values ('Joli Royds', 3, 2018);
insert into Students (studentFullName, groupID, studentYearOfAdmission)
values ('Rinaldo Gillbard', 2, 2017);
insert into Students (studentFullName, groupID, studentYearOfAdmission)
values ('Chantalle Milward', 2, 2017);
insert into Students (studentFullName, groupID, studentYearOfAdmission)
values ('Isidro Mouatt', 2, 2017);
insert into Students (studentFullName, groupID, studentYearOfAdmission)
values ('Anselma Asipenko', 1, 2016);
insert into Students (studentFullName, groupID, studentYearOfAdmission)
values ('Lynda Gammon', 3, 2018);
insert into Students (studentFullName, groupID, studentYearOfAdmission)
values ('Mill Laverty', 1, 2016);
insert into Students (studentFullName, groupID, studentYearOfAdmission)
values ('Perri Taillard', 2, 2017);
insert into Students (studentFullName, groupID, studentYearOfAdmission)
values ('Ania Langmuir', 3, 2018);
insert into Students (studentFullName, groupID, studentYearOfAdmission)
values ('Averil Broadfield', 1, 2016);
insert into Students (studentFullName, groupID, studentYearOfAdmission)
values ('Correna Yurinov', 2, 2017);
insert into Students (studentFullName, groupID, studentYearOfAdmission)
values ('Sadie Easbie', 3, 2018);
insert into Students (studentFullName, groupID, studentYearOfAdmission)
values ('Tracee Volonte', 3, 2018);
insert into Students (studentFullName, groupID, studentYearOfAdmission)
values ('Bari Swyre', 2, 2017);

insert into Marks (subjectID, studentID, mark)
values (9, 12, 64);
insert into Marks (subjectID, studentID, mark)
values (8, 16, 77);
insert into Marks (subjectID, studentID, mark)
values (12, 11, 82);
insert into Marks (subjectID, studentID, mark)
values (6, 8, 72);
insert into Marks (subjectID, studentID, mark)
values (5, 15, 95);
insert into Marks (subjectID, studentID, mark)
values (5, 4, 83);
insert into Marks (subjectID, studentID, mark)
values (10, 8, 81);
insert into Marks (subjectID, studentID, mark)
values (15, 5, 95);
insert into Marks (subjectID, studentID, mark)
values (6, 8, 67);
insert into Marks (subjectID, studentID, mark)
values (10, 15, 76);
insert into Marks (subjectID, studentID, mark)
values (2, 8, 98);
insert into Marks (subjectID, studentID, mark)
values (3, 5, 100);
insert into Marks (subjectID, studentID, mark)
values (12, 15, 85);
insert into Marks (subjectID, studentID, mark)
values (12, 1, 93);
insert into Marks (subjectID, studentID, mark)
values (1, 16, 73);
insert into Marks (subjectID, studentID, mark)
values (14, 6, 79);
insert into Marks (subjectID, studentID, mark)
values (2, 4, 74);
insert into Marks (subjectID, studentID, mark)
values (1, 4, 82);
insert into Marks (subjectID, studentID, mark)
values (14, 9, 70);
insert into Marks (subjectID, studentID, mark)
values (2, 5, 96);
insert into Marks (subjectID, studentID, mark)
values (6, 3, 79);
insert into Marks (subjectID, studentID, mark)
values (13, 3, 82);
insert into Marks (subjectID, studentID, mark)
values (2, 18, 93);
insert into Marks (subjectID, studentID, mark)
values (7, 6, 98);
insert into Marks (subjectID, studentID, mark)
values (9, 18, 76);
insert into Marks (subjectID, studentID, mark)
values (9, 5, 83);
insert into Marks (subjectID, studentID, mark)
values (14, 14, 92);
insert into Marks (subjectID, studentID, mark)
values (9, 20, 83);
insert into Marks (subjectID, studentID, mark)
values (11, 9, 66);
insert into Marks (subjectID, studentID, mark)
values (13, 4, 61);

