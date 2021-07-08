package com.hillel.homework_13.utils;

import java.util.Scanner;

public class ScannerUtilClass {
    public static String setNumber() {
        String number;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Please, enter the number u want to see as pseudo graphic " +
                    "(no spaces between numerals allowed)");
            while (!(sc.hasNext("[0-9]+"))) {
                System.out.println("Number required!");
                sc.next();
            }
            number = sc.next();
        } while (!(number.matches("[0-9]+")));
        return number;
    }
}
