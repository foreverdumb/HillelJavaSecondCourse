package com.hillel.homework_2.findingFactorialClass;

import java.util.Scanner;

public class FindingFactorialUsingWhileClass {

    public static void findFactorialUsingWhileLoop() {
        int stopWhile = 1;
        int getTheStopValue = setLimit();
        int calculateFactorialsValue = 1;

        while (stopWhile != getTheStopValue) {

            stopWhile++;
            calculateFactorialsValue *= stopWhile;
        }
        System.out.println("The factorial of " + getTheStopValue + " equals: " + calculateFactorialsValue);
    }

    protected static int setLimit() {
        int limit;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Please, enter the factorials' value: ");
            while (!sc.hasNextInt()) {
                System.out.println("Attention! Integer required!");
                sc.next();
            }
            limit = sc.nextInt();
        } while (limit <= 0);
        return limit;
    }
}
