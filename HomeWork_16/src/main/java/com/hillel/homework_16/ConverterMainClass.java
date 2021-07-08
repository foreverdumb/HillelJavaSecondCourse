package com.hillel.homework_16;

import com.hillel.homework_16.utils.ConvertingUtilClass;
import com.hillel.homework_16.utils.FileUtilClass;
import com.hillel.homework_16.utils.TimeMeasureUtilClass;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConverterMainClass {
    public static void main(String[] args) throws Exception {
        final Logger appLogger = LogManager.getLogger("appLogger");
        appLogger.log(Level.INFO, """
                DIRECTORY VALID STATUS MEANING:\s
                IF TRUE - CAPABLE FILES WITH CONVERTING EXIST\s
                IF FALSE - NO CAPABLE FILES WITH CONVERTING EXIST\s""");
        FileUtilClass.createResultDir();
        int argument = args.length;

        if (argument == 0) {
            boolean isDirExists = FileUtilClass.isExists(FileUtilClass.getCurrentWorkingDirectory());
            appLogger.log(Level.INFO, "Directory exists status: " + isDirExists + ".");
            boolean isDirValid = FileUtilClass.scanCurrentDirectory();
            appLogger.log(Level.INFO, "Directory valid status: " + isDirValid + ".");
            if (isDirExists && isDirValid) {
                ConvertingUtilClass.jsonAsYaml(FileUtilClass.getCurrentWorkingDirectory());
                appLogger.log(Level.INFO, "JSON FILES CONVERTED TO YAML");
                ConvertingUtilClass.yamlAsJson(FileUtilClass.getCurrentWorkingDirectory());
                appLogger.log(Level.INFO, "YAML FILE CONVERTED TO JSON");
                String time = TimeMeasureUtilClass.measureTimeOfConverting();
                appLogger.log(Level.INFO, "Time was spent for converting files: " + time);
            } else {
                appLogger.log(Level.ERROR, "NO APPROPRIATE FILES FOUND IN THE CURRENT DIR");
            }
        } else if (argument == 1) {
            boolean isDirExists = FileUtilClass.isExists(args[0]);
            appLogger.log(Level.INFO, "Directory exists status: " + isDirExists + ".");
            boolean isDirValid = FileUtilClass.scanGivenDirectory(isDirExists, args[0]);
            appLogger.log(Level.INFO, "Directory valid status: " + isDirValid + ".");
            if (isDirExists && isDirValid) {
                ConvertingUtilClass.jsonAsYaml(args[0]);
                appLogger.log(Level.INFO, "JSON FILES CONVERTED TO YAML");
                ConvertingUtilClass.yamlAsJson(args[0]);
                appLogger.log(Level.INFO, "YAML FILE CONVERTED TO JSON");
                String time = TimeMeasureUtilClass.measureTimeOfConverting();
                appLogger.log(Level.INFO, "Time was spent for converting files: " + time);
            }
        } else {
            appLogger.log(Level.ERROR, "ONLY ONE ARGUMENT WITH APPROPRIATE DIRECTORY OR NO ARGUMENTS ALLOWED");
        }
    }
}
