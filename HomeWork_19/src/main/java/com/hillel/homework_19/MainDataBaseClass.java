package com.hillel.homework_19;

import com.hillel.homework_19.models.StudentClass;
import com.hillel.homework_19.utils.DataBaseUtilClass;
import com.hillel.homework_19.utils.ScannerUtilClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class MainDataBaseClass {
    public static void main(String[] args) throws ClassNotFoundException {
        DataBaseConfigurationClass.configureDB();

        do {
            root_main.info("""
                                        
                    1 - Add new student.
                    2 - Delete student by id.
                    3 - Print students deleted skipped.
                    4 - Print all students.
                    5 - Print student by full name.
                    6 - Print student by id.
                    7 - Drop DB.
                    """);
            int option = ScannerUtilClass.getCorrectOption();
            switch (option) {
                case 1 -> {
                    Connection conn = null;
                    Statement stmt = null;
                    try {
                        Class.forName("org.h2.Driver");
                        conn = DriverManager.getConnection("jdbc:h2:" + "./DB/Student",
                                "root", "hillel");
                        stmt = conn.createStatement();
                        addStudent(stmt);
                    } catch (Exception se) {
                        root_main.info("Exception caught... [Class]: MainClass, [Line]: 37");
                        //Handle errors for JDBC
                        se.printStackTrace();
                    } finally {
                        closeConnection(conn, stmt);
                    }
                }
                case 2 -> {
                    Connection conn = null;
                    Statement stmt = null;
                    try {
                        Class.forName("org.h2.Driver");
                        conn = DriverManager.getConnection("jdbc:h2:" + "./DB/Student",
                                "root", "hillel");
                        stmt = conn.createStatement();
                        deleteStudent(stmt);
                    } catch (Exception se) {
                        root_main.info("Exception caught... [Class]: MainClass, [Line]: 54");
                        //Handle errors for JDBC
                        se.printStackTrace();
                    } finally {
                        closeConnection(conn, stmt);
                    }
                }
                case 3 -> {
                    Connection conn = null;
                    Statement stmt = null;
                    try {
                        Class.forName("org.h2.Driver");
                        conn = DriverManager.getConnection("jdbc:h2:" + "./DB/Student",
                                "root", "hillel");
                        stmt = conn.createStatement();
                        printCurrentStudents(stmt);
                    } catch (Exception se) {
                        root_main.info("Exception caught... [Class]: MainClass, [Line]: 71");
                        //Handle errors for JDBC
                        se.printStackTrace();
                    } finally {
                        closeConnection(conn, stmt);
                    }
                }
                case 4 -> {
                    Connection conn = null;
                    Statement stmt = null;
                    try {
                        Class.forName("org.h2.Driver");
                        conn = DriverManager.getConnection("jdbc:h2:" + "./DB/Student",
                                "root", "hillel");
                        stmt = conn.createStatement();
                        printAllStudents(stmt);
                    } catch (Exception se) {
                        root_main.info("Exception caught... [Class]: MainClass, [Line]: 86");
                        //Handle errors for JDBC
                        se.printStackTrace();
                    } finally {
                        closeConnection(conn, stmt);
                    }
                }
                case 5 -> {
                    Connection conn = null;
                    Statement stmt = null;
                    try {
                        Class.forName("org.h2.Driver");
                        conn = DriverManager.getConnection("jdbc:h2:" + "./DB/Student",
                                "root", "hillel");
                        stmt = conn.createStatement();
                        printStudentByFullName(stmt);
                    } catch (Exception se) {
                        root_main.info("Exception caught... [Class]: MainClass, [Line]: 105");
                        //Handle errors for JDBC
                        se.printStackTrace();
                    } finally {
                        closeConnection(conn, stmt);
                    }
                }
                case 6 -> {
                    Connection conn = null;
                    Statement stmt = null;
                    try {
                        Class.forName("org.h2.Driver");
                        conn = DriverManager.getConnection("jdbc:h2:" + "./DB/Student",
                                "root", "hillel");
                        stmt = conn.createStatement();
                        printStudentById(stmt);
                    } catch (Exception se) {
                        root_main.info("Exception caught... [Class]: MainClass, [Line]: 122");
                        //Handle errors for JDBC
                        se.printStackTrace();
                    } finally {
                        closeConnection(conn, stmt);
                    }
                }
                case 7 -> DataBaseConfigurationClass.dropDataBase();
            }
        } while (ScannerUtilClass.goOrStop().equals("Yes"));
    }

    private static final Logger root_main = LogManager.getRootLogger();

    private static void closeConnection(Connection conn, Statement stmt) {
        try {
            if (stmt != null) stmt.close();
        } catch (SQLException ignored) {
            root_main.info("Exception caught... [Class]: MainClass, [Line]: 134.1");
        }
        try {
            if (conn != null) conn.close();
        } catch (SQLException se) {
            root_main.info("Exception caught... [Class]: MainClass, [Line]: 134.2");
            se.printStackTrace();
        }
    }

    public static void addStudent(Statement stmt) throws SQLException {
        int id_gr = ScannerUtilClass.getCorrectGroupId();
        int st_year = ScannerUtilClass.getCorrectYearOfAdmission();
        String st_name = ScannerUtilClass.correctName();

        DataBaseUtilClass.addStudent(stmt, new StudentClass(st_name, id_gr, st_year));
        stmt.close();
    }

    private static void deleteStudent(Statement stmt) throws SQLException {
        int st_total = DataBaseUtilClass.getStudentsCount(stmt);
        int st_id = ScannerUtilClass.getIntBetweenNumbers(st_total);

        DataBaseUtilClass.deleteStudent(stmt, st_id);
        stmt.close();
    }

    private static void printCurrentStudents(Statement stmt) throws SQLException {
        List<StudentClass> list = DataBaseUtilClass.getCurrentStudents(stmt);
        for (StudentClass students : list) {
            System.out.println(students);
        }
        stmt.close();
    }

    private static void printAllStudents(Statement stmt) throws SQLException {
        List<StudentClass> list = DataBaseUtilClass.getAllStudents(stmt);
        for (StudentClass students : list) {
            System.out.println(students);
        }
        stmt.close();
    }

    private static void printStudentByFullName(Statement stmt) throws SQLException {
        String name = ScannerUtilClass.correctName();
        printStudentData(DataBaseUtilClass.getStudent(stmt, name));
        stmt.close();
    }

    private static void printStudentById(Statement stmt) throws SQLException {
        int totalStudents = DataBaseUtilClass.getStudentsCount(stmt);
        int id = ScannerUtilClass.getIntBetweenNumbers(totalStudents);
        printStudentData(DataBaseUtilClass.getStudent(stmt, id));
        stmt.close();
    }

    private static void printStudentData(StudentClass student) {
        Optional<StudentClass> st = Optional.ofNullable(student);
        if (st.isPresent()) {
            if (!st.get().isDeleted()) {
                System.out.println("Found: " + st.get());
            } else {
                System.out.println("Student deleted.");
            }
        } else {
            System.out.println("Student not found.");
        }
    }
}
