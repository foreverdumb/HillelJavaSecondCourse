package com.hillel.homework_25;

import com.hillel.homework_25.models.StudentsClass;
import com.hillel.homework_25.models.StudyGroupClass;
import com.hillel.homework_25.services.StudentServiceClass;
import com.hillel.homework_25.utils.HibernateSessionFactoryUtilClass;
import com.hillel.homework_25.utils.ScannerUtilClass;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class MainClass {
    private static final Logger root_logger_main = LogManager.getRootLogger();
    private static final Logger app_logger_main = LogManager.getLogger("appLogger");

    public static void main(String[] args) throws SQLException {
        String continueApp;
        int option;
        app_logger_main.log(Level.INFO, "APP STARTED.");
        do {
            root_logger_main.info("""
                                      
                    1 - Add new student.
                    2 - Print current students.
                    3 - Print student by full name.
                    4 - Print student by id.
                    """);
            option = ScannerUtilClass.getCorrectOption();
            switch (option) {
                case 1 -> saveUser();
                case 2 -> printAll();
                case 3 -> findByName();
                case 4 -> findById();
            }
            continueApp = ScannerUtilClass.goOrStop();
            if (continueApp.equals("No")) {
                app_logger_main.log(Level.INFO, "APP EXECUTED.");
                System.exit(0);
            }
        } while (continueApp.equals("Yes"));
    }

    public static void saveUser() {
        int admYear = ScannerUtilClass.getCorrectYearOfAdmission();
        int group = ScannerUtilClass.getCorrectGroupId();
        String name = ScannerUtilClass.getCorrectName();

        Session session = HibernateSessionFactoryUtilClass.
                getSessionFactory().
                openSession();

        StudyGroupClass id_sg = (StudyGroupClass) session
                .createQuery("from StudyGroupClass where id = " + group)
                .uniqueResult();
        StudentServiceClass studentService = new StudentServiceClass();
        studentService.saveUser(new StudentsClass().setAdmYear(admYear).setGroup(id_sg).setFullName(name));
        app_logger_main.log(Level.INFO, "USER ADDED: " +
                "[name]: " + name +
                " [admYear]: " + admYear +
                " [group]: " + group);
        session.close();
    }

    public static void findById() throws SQLException {
        StudentServiceClass studentService = new StudentServiceClass();
        long total = studentService.getStudentsCount();
        int id = (int) ScannerUtilClass.getIntBetweenNumbers((int) total);

        app_logger_main.log(Level.INFO, "USER BY ID [" + id + "] WAS FOUND.");
        System.out.println(studentService.findUser(id));
    }

    public static void findByName() {
        StudentServiceClass studentService = new StudentServiceClass();
        String name = ScannerUtilClass.getCorrectName();

        List<StudentsClass> names = studentService.findStudentByName(name);
        app_logger_main.log(Level.INFO, "USER BY NAME [" + name + "] WAS FOUND.");
        names.forEach(System.out::println);
    }

    public static void printAll() {
        StudentServiceClass studentService = new StudentServiceClass();

        app_logger_main.log(Level.INFO, "PRINTED ALL STUDENTS.");
        studentService.printAllStudents();
    }
}
