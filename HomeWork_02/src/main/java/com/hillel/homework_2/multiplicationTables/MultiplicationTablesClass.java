package com.hillel.homework_2.multiplicationTables;

import java.util.Scanner;

public class MultiplicationTablesClass {

    public static void printTable() {
        int one = 1;
        int two = 2;
        int three = 3;
        int four = 4;
        int five = 5;
        int six = 6;
        int seven = 7;
        int eight = 8;
        int nine = 9;
        int ten = 10;

        int result;
        int option;

        do {
            option = setOption();
            switch (option) {
                case 1:
                    for (int i = 1; i <= ten; i++) {

                        result = i * one;
                        System.out.println(result);
                    }
                    System.out.println("---------------");
                    break;
                case 2:
                    for (int i = 1; i <= ten; i++) {

                        result = i * two;
                        System.out.println(result);
                    }
                    System.out.println("---------------");
                    break;
                case 3:
                    for (int i = 1; i <= ten; i++) {

                        result = i * three;
                        System.out.println(result);
                    }
                    System.out.println("---------------");
                    break;
                case 4:
                    for (int i = 1; i <= ten; i++) {

                        result = i * four;
                        System.out.println(result);
                    }
                    System.out.println("---------------");
                    break;
                case 5:
                    for (int i = 1; i <= ten; i++) {

                        result = i * five;
                        System.out.println(result);
                    }
                    System.out.println("---------------");
                case 6:
                    for (int i = 1; i <= ten; i++) {

                        result = i * six;
                        System.out.println(result);
                    }
                    System.out.println("---------------");
                    break;
                case 7:
                    for (int i = 1; i <= ten; i++) {

                        result = i * seven;
                        System.out.println(result);
                    }
                    System.out.println("---------------");
                    break;
                case 8:
                    for (int i = 1; i <= ten; i++) {

                        result = i * eight;
                        System.out.println(result);
                    }
                    System.out.println("---------------");
                    break;
                case 9:
                    for (int i = 1; i <= ten; i++) {

                        result = i * nine;
                        System.out.println(result);
                    }
                    System.out.println("---------------");
                    break;
                case 10:
                    for (int i = 1; i <= ten; i++) {

                        result = i * ten;
                        System.out.println(result);
                    }
                    System.out.println("---------------");
                    break;
                case 11:
                    System.out.println("Bye");
            }
        } while (option != 11);
    }

    private static int setOption() {
        int option;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Please, enter the number of table u want to see, from 1 to 10 \n11 - Exit: ");
            while (!sc.hasNextInt()) {
                System.out.println("Attention! Integer required!");
                sc.next();
            }
            option = sc.nextInt();
        } while (option <= 0);
        return option;
    }
}
