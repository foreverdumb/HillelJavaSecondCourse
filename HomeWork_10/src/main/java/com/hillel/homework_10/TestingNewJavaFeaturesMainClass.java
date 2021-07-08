package com.hillel.homework_10;

import com.hillel.homework_10.models.UserClass;
import com.hillel.homework_10.record.RecordClass;

import java.util.Scanner;

public class TestingNewJavaFeaturesMainClass {
    public static void main(String[] args) {
        int option;

        RecordClass feature_1 = new RecordClass(18, true, "Den");

        System.out.println(feature_1);


        do {
            System.out.println("""
                    1 - NullPointerException
                    2 - Pattern Matching
                    3 - Bye
                    """);

            switch (option = setOption()) {
                case 1 -> {
                    UserClass user_1 = new UserClass();
                    user_1.getAddress().getCountry().getName();
                }
                case 2 -> {
                    Object obj = "Igor";

                    if (obj instanceof String s) {
                        System.out.println(s.length());
                    }
                }
                case 3 -> System.out.println("Bye");
            }
        } while (option != 3);
    }

    public static int setOption() {

        Scanner sc = new Scanner(System.in);
        int number;

        do {

            while (!sc.hasNext()) {
                System.out.println("Integer is required!");
                sc.next();
            }
            number = sc.nextInt();
        } while (number <= 0);
        return number;
    }
}
