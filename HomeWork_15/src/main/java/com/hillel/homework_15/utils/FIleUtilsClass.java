package com.hillel.homework_15.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FIleUtilsClass {
    public static String getDirectory() throws IOException {
        return new File(".").getCanonicalPath();
    }

    public static String createDirectory() throws IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date(1212121212121L);


        String path = getDirectory();
        String logFile = path + "/LogDir/log_" + format.format(date) + ".txt";
        File logDir = new File(path, "LogDir");
        if (logDir.mkdir()) {
            System.out.println("Directory LogDir has already created");
        }
        File log_file = new File(logFile);
        if (log_file.createNewFile()) {
            System.out.println("File has already created");
        }
        return log_file.getName();
    }

    public static void writeLog(int win, int loss, int draw,
                                int quantityOfGames, String fileName, String name,
                                int artificialChoice, int userChoice, int declined) throws IOException {
        String path = getDirectory();
        String pathDeep = path + "/LogDir/" + fileName;
        try (FileWriter writer = new FileWriter(pathDeep, true)) {
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write("-------------------------------");
            bufferedWriter.newLine();
            bufferedWriter.write("Player: " + name);
            bufferedWriter.newLine();
            bufferedWriter.write("-------------------------------");
            bufferedWriter.newLine();
            bufferedWriter.write("Wins:   " + win);
            bufferedWriter.newLine();
            bufferedWriter.write("Losses: " + loss);
            bufferedWriter.newLine();
            bufferedWriter.write("Draws:  " + draw);
            bufferedWriter.newLine();
            bufferedWriter.write("Quantity of tries that were chosen: " + quantityOfGames);
            bufferedWriter.newLine();
            bufferedWriter.write("Your option was: " + userChoice + "\ncomputer's choice was: " + artificialChoice);
            bufferedWriter.newLine();
            bufferedWriter.write("Quantity of games that were played: " + declined);
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }
}
