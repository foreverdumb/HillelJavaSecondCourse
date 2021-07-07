package com.hillel.homework_25.services;

import com.hillel.homework_25.dao.StudentDaoClass;
import com.hillel.homework_25.models.StudentsClass;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceClass {
    private final StudentDaoClass studentDao = new StudentDaoClass();

    public StudentServiceClass() {
    }

    public StudentsClass findUser(int id) {
        return studentDao.findById(id);
    }

    public void saveUser(StudentsClass student) {
        studentDao.save(student);
    }

    public long getStudentsCount() throws SQLException {
        return studentDao.getStudentsCount();
    }

    public List<StudentsClass> findStudentByName(String name) {
        return studentDao.findByName(name);
    }

    public void printAllStudents() {
        studentDao.printStudents();
    }
}
