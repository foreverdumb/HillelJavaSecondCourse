package com.hillel.homework_19.utils;

import com.hillel.homework_19.models.StudentClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseUtilClass {
    public static boolean addStudent(Statement stmt, StudentClass student) throws SQLException {
        String sql = String.format(
                "INSERT INTO PUBLIC.STUDENTS (studentFullName, groupID, studentYearOfAdmission) " +
                        "VALUES ('%s', %d, %d)",
                student.getFullName(),
                student.getGroupId(),
                student.getAdmYear());
        return stmt.executeUpdate(sql) == 1;
    }


    public static boolean deleteStudent(Statement stmt, int id) throws SQLException {
        String sql = String.format(
                "UPDATE PUBLIC.STUDENTS " +
                        "SET isDeleted = true " +
                        "WHERE PUBLIC.STUDENTS.ID_ST = %d", id);
        return stmt.executeUpdate(sql) == 1;
    }


    public static List<StudentClass> getCurrentStudents(Statement st) throws SQLException {
        List<StudentClass> list = new ArrayList<>();
        String sql = "SELECT * FROM PUBLIC.STUDENTS WHERE PUBLIC.STUDENTS.isDeleted = false";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            list.add(getStudentFromResultSet(rs));
        }
        return list;
    }


    public static List<StudentClass> getAllStudents(Statement st) throws SQLException {
        List<StudentClass> list = new ArrayList<>();
        String sql = "SELECT * FROM STUDENTS";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            list.add(getStudentFromResultSet(rs));
        }
        return list;
    }


    public static StudentClass getStudent(Statement st, String fullName) throws SQLException {
        String sql = String.format(
                "SELECT * FROM PUBLIC.STUDENTS " +
                        "WHERE PUBLIC.STUDENTS.studentFullName = '%s'", fullName);
        ResultSet rs = st.executeQuery(sql);
        return rs.next() ? getStudentFromResultSet(rs) : null;
    }


    public static StudentClass getStudent(Statement st, int id) throws SQLException {
        String sql = String.format(
                "SELECT * FROM PUBLIC.STUDENTS " +
                        "WHERE PUBLIC.STUDENTS.ID_ST = %d", id);
        ResultSet rs = st.executeQuery(sql);
        return rs.next() ? getStudentFromResultSet(rs) : null;
    }

    public static int getStudentsCount(Statement st) throws SQLException {
        String sql = "SELECT COUNT(*) AS totalRows FROM STUDENTS";
        ResultSet rs = st.executeQuery(sql);
        return rs.next() ? rs.getInt("totalRows") : 0;
    }


    private static StudentClass getStudentFromResultSet(ResultSet rs) throws SQLException {
        int Id = rs.getInt("ID_ST");
        String FullName = rs.getString("studentFullName");
        int GroupId = rs.getInt("groupID");
        int AdmYear = rs.getInt("studentYearOfAdmission");
        boolean IsDeleted = rs.getBoolean("isDeleted");

        return new StudentClass().setId(Id)
                .setFullName(FullName)
                .setGroupId(GroupId)
                .setAdmYear(AdmYear)
                .setDeleted(IsDeleted);
    }
}
