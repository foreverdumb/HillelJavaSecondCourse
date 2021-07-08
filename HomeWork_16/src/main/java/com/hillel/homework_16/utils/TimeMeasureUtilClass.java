package com.hillel.homework_16.utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class TimeMeasureUtilClass {
    private static final Logger APP_LOGGER = LogManager.getLogger("appLogger");

    public static String measureTimeOfConverting() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread.sleep(1000 * 4);
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        String humanResult = String.format("Milli = %s, ( S_Start : %s, S_End : %s ) \n", duration, startTime, endTime);
        APP_LOGGER.log(Level.INFO, humanResult);
        return millisToShortDHMS(duration);
    }

    private static String millisToShortDHMS(long duration) {
        String res = "";
        long days = TimeUnit.MILLISECONDS.toDays(duration);
        long hours = TimeUnit.MILLISECONDS.toHours(duration)
                - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(duration));
        long minutes = TimeUnit.MILLISECONDS.toMinutes(duration)
                - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(duration));
        long seconds = TimeUnit.MILLISECONDS.toSeconds(duration)
                - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration));
        if (days == 0) {
            res = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        } else {
            res = String.format("%dd%02d:%02d:%02d", days, hours, minutes, seconds);
        }
        return res;
    }
}
