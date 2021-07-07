package com.hillel.homework_1.bank_app;

import java.util.Scanner;

public class BankUtils {

    static int numberSetValue;

    public BankUtils() {
    }

    public static int getMoney() {
        System.out.println("Please, enter amount of money($): ");
        return setValues();
    }

    public static int getAnnualInterest() {
        System.out.println("Please, enter annual interest(%): ");
        return setValues();
    }

    public static int getDurationOfDeposit() {
        System.out.println("Please, enter duration of deposit(months): ");
        return setValues();
    }

    private static int setValues() {
        Scanner sc = new Scanner(System.in);
        do {
            while (!sc.hasNextInt()) {
                System.out.println("Attention! Integer required!");
                sc.next();
            }
            numberSetValue = sc.nextInt();
        } while (numberSetValue <= 0);
        return numberSetValue;
    }

    public static void hardPercentCounting(double resultMoney, double resultAnnualInterest,
                                           double resultDurationOfDeposit) {
        double result;
        double const_1 = 100.0D;
        double compoundInterestAfter;
        result = resultMoney * Math.pow(1 + (resultAnnualInterest / resultDurationOfDeposit / const_1),
                resultDurationOfDeposit);
        compoundInterestAfter = result - resultMoney;
        System.out.println("Compound Interest after " + resultDurationOfDeposit + " months: " + compoundInterestAfter);
        System.out.println("Amount after " + resultDurationOfDeposit + " months: " + result);
    }
}
