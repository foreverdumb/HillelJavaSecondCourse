package com.hillel.homework_25.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class ScannerUtilClass {
    private static final Logger root = LogManager.getRootLogger();

    public static int getCorrectGroupId() {
        Scanner id = new Scanner(System.in);
        int gr_id;

        do {
            root.info("Please, enter group id (1, 2 or 3): ");
            while (!(id.hasNextInt())) {
                root.info("Integer required!");
            }
            gr_id = id.nextInt();
        } while (gr_id != 1 && gr_id != 2 && gr_id != 3);
        return gr_id;
    }

    public static String getCorrectName() {
        Scanner name = new Scanner(System.in);
        String st_name;
        do {
            root.info("Please, enter student's name: ");
            st_name = name.nextLine();
        } while (!(Character.isUpperCase(st_name.charAt(0))));
        return st_name;
    }

    public static int getCorrectYearOfAdmission() {
        Scanner year = new Scanner(System.in);
        int st_year;

        do {
            root.info("Please, enter year of admission: ");
            while (!(year.hasNextInt())) {
                root.info("Integer required!");
            }
            st_year = year.nextInt();
        } while (!(st_year >= 1999 && st_year <= 2050));
        return st_year;
    }

    public static long getIntBetweenNumbers(int total) {
        Scanner quantity = new Scanner(System.in);
        int st_quantity;

        do {
            root.info("Please, enter student id: ");
            while (!(quantity.hasNextInt())) {
                root.info("Integer required!");
            }
            st_quantity = quantity.nextInt();
        } while (!(st_quantity <= total));
        return st_quantity;
    }

    public static String goOrStop() {
        Scanner sc = new Scanner(System.in);
        String option;
        do {
            root.info("\n" + """
                    Enter 'Yes' to continue
                    Enter 'No' to stop 
                    """);
            option = sc.nextLine();
            if (!option.equals("Yes") && !option.equals("No")) {
                root.info("YES OR NO WERE TYPED INCORRECTLY.");
            }
        } while (!option.equals("Yes") && !option.equals("No"));
        return option;
    }

    public static int getCorrectOption() {
        Scanner quantity = new Scanner(System.in);
        int st_quantity;

        do {
            root.info("Please, enter option: ");
            while (!(quantity.hasNextInt())) {
                root.info("Integer required!");
            }
            st_quantity = quantity.nextInt();
        } while (st_quantity != 1 && st_quantity != 2 && st_quantity != 3 && st_quantity != 4);
        return st_quantity;
    }
}