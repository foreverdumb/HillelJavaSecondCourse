package com.hillel.homework_16.utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class FileUtilClass {
    private static final Logger APP_LOGGER = LogManager.getLogger("appLogger");

    public static String getCurrentWorkingDirectory() throws IOException {
        return new File(".").getCanonicalPath();
    }

    public static boolean isExists(String path) throws IndexOutOfBoundsException {
        File dir = new File(path);
        if (dir.exists() && dir.isDirectory() && Objects.requireNonNull(dir.list()).length != 0) {
            APP_LOGGER.log(Level.INFO, "Directory exists.");
            return true;
        } else {
            APP_LOGGER.log(Level.ERROR, "Directory does not exists.");
            return false;
        }
    }

    private static boolean checkDirValidity(File dir) {
        String[] fileNames = dir.list();
        assert fileNames != null;
        for (String name :
                fileNames) {
            if (name.endsWith(".json") || name.endsWith(".yaml")) {
                APP_LOGGER.log(Level.INFO, "Scanning files in directory...file found.");
                return true;
            } else {
                APP_LOGGER.log(Level.ERROR, "Scanning files in directory...nothing found.");
            }
        }
        return false;
    }

    public static boolean scanGivenDirectory(boolean isExists, String path) throws IOException {
        if (isExists) {
            File dir = new File(path);
            return checkDirValidity(dir);
        } else {
            if (scanCurrentDirectory()) {
                APP_LOGGER.log(Level.INFO, "Scanning files in directory...file found.");
            } else APP_LOGGER.log(Level.ERROR, "Scanning files in directory...nothing found.");
        }
        return true;
    }

    public static boolean scanCurrentDirectory() throws IOException {
        String path = getCurrentWorkingDirectory();
        File dir = new File(path);
        return checkDirValidity(dir);
    }

    public static void createResultDir() {
        File dir = new File("./Converted");
        boolean isCreatedResultDir = dir.mkdirs();
        if (isCreatedResultDir) {
            APP_LOGGER.log(Level.INFO, "Converted dir created.");
        } else {
            APP_LOGGER.log(Level.ERROR, "Converted dir was not created.");
        }
    }

    public static String createFile(Object name, String extension) throws IOException {
        String properName = getNameBeforeDot(name.toString());
        String path = getCurrentWorkingDirectory();
        File file = new File(path + "/Converted/converted_file_" + properName + extension);
        boolean isCreatedFile = file.createNewFile();
        if (isCreatedFile) {
            APP_LOGGER.log(Level.INFO, "File created.");
        } else {
            APP_LOGGER.log(Level.ERROR, "File was not created.");
        }
        return file.getAbsolutePath();
    }

    private static String getNameBeforeDot(String name) {
        int end = name.indexOf(".");
        String subString = null;
        if (end != -1) {
            subString = name.substring(0, end);
        }
        return subString;
    }
}
