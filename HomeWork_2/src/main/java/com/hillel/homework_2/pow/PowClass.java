package com.hillel.homework_2.pow;

import java.util.Scanner;

public class PowClass {

    public static void calculatePow() {
        int pow = setPow();
        int number = setNumber();
        int result = 1;

        for (int i = 0; i < pow; i++) {

            result = result * number;
        }
        System.out.println("The result of elevation equals: " + result);
    }

    private static int setData() {
        int data;
        Scanner sc = new Scanner(System.in);

        do {
            while (!sc.hasNextInt()) {
                System.out.println("Attention! Integer required!");
                sc.next();
            }
            data = sc.nextInt();
        } while (data <= 0);
        return data;
    }

    private static int setPow() {
        System.out.println("Please, set the pow value: ");
        return setData();
    }

    private static int setNumber() {
        System.out.println("Please, enter the number you want to be elevated: ");
        return setData();
    }
}
