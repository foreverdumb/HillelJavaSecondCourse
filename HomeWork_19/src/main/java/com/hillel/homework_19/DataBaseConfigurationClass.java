package com.hillel.homework_19;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConfigurationClass {
    private static final Logger info_logger = LogManager.getLogger("appLogger");

    private static void createTables() throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
        Connection conn;

        try {
            // STEP 1: Register JDBC driver
            /*  Class.forName("org.h2.Driver");*/

            //STEP 2: Open a connection
            info_logger.log(Level.INFO, "Connecting to database to create tables...");
            conn = DriverManager.getConnection("jdbc:h2:" + "./DB/Student",
                    "root", "hillel");

            //STEP 3: Execute a query
            info_logger.log(Level.INFO, "Creating tables in given database...");
            ScriptRunner sr = new ScriptRunner(conn);
            String path = new File(".").getAbsolutePath() +
                    "/HomeWork_19/src/main/java/com/hillel/homework_18/ddl/create_db/create_db.sql";
            Reader reader = new BufferedReader(new FileReader(path));
            sr.runScript(reader);
            conn.close();
            info_logger.log(Level.INFO, "Tables creation finished...");
        } catch (SQLException | FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    private static void fillDBWithData() throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
        Connection conn;

        try {
            // STEP 1: Register JDBC driver
            /*  Class.forName("org.h2.Driver");*/

            //STEP 2: Open a connection
            info_logger.log(Level.INFO, "Connecting to database to fill DB...");
            conn = DriverManager.getConnection("jdbc:h2:" + "./DB/Student",
                    "root", "hillel");

            //STEP 3: Execute a query
            info_logger.log(Level.INFO, "Filling DB with data...");
            String path = new File(".").getAbsolutePath() +
                    "/HomeWork_19/src/main/java/com/hillel/homework_18/ddl/fill_db/fill_db.sql";
            System.out.println(path);
            ScriptRunner sr = new ScriptRunner(conn);
            Reader reader = new BufferedReader(new FileReader(path));
            sr.runScript(reader);
            conn.close();
            info_logger.log(Level.INFO, "Filling DB finished...");
        } catch (SQLException | IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void dropDataBase() throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
        Connection conn;

        try {
            // STEP 1: Register JDBC driver
            /*  Class.forName("org.h2.Driver");*/

            //STEP 2: Open a connection
            info_logger.log(Level.INFO, "Connecting to database to drop DB...");
            conn = DriverManager.getConnection("jdbc:h2:" + "./DB/Student",
                    "root", "hillel");

            //STEP 3: Execute a query
            info_logger.log(Level.INFO, "Dropping DB...");
            String path = new File(".").getAbsolutePath() +
                    "/HomeWork_19/src/main/java/com/hillel/homework_18/ddl/drop_db/drop_db.sql";
            System.out.println(path);
            ScriptRunner sr = new ScriptRunner(conn);
            Reader reader = new BufferedReader(new FileReader(path));
            sr.runScript(reader);
            conn.close();
            info_logger.log(Level.INFO, "Dropping DB finished...");
        } catch (SQLException | IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void configureDB() throws ClassNotFoundException {
        createTables();
        fillDBWithData();
    }
}