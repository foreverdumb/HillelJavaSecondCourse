package com.hillel.homework_1.bank_app;

import java.util.Scanner;

public class BankAppClass {

    public static void findPercent() {
        Scanner sc = new Scanner(System.in);
        int stopOrGo;
        double resultMoney = 0D;
        double resultAnnualInterest = 0D;
        double resultDurationOfDeposit = 0D;
        do {
            System.out.println("""
                    Please, choose an option:\s
                    1 - Enter the amount of money you want to put on deposit\s
                    2 - Enter the annual interest\s
                    3 - Enter the duration of deposit\s
                    4 - Calculate percentages
                    5 - Exit""");
            while (!sc.hasNextInt()) {
                System.out.println("Attention! Integer required!");
                sc.next();
            }
            stopOrGo = sc.nextInt();
            switch (stopOrGo) {
                case 1 -> {
                    resultMoney = BankUtils.getMoney();
                }
                case 2 -> {
                    resultAnnualInterest = BankUtils.getAnnualInterest();
                }
                case 3 -> {
                    resultDurationOfDeposit = BankUtils.getDurationOfDeposit();
                }
                case 4 -> BankUtils.hardPercentCounting(resultMoney, resultAnnualInterest, resultDurationOfDeposit);
                case 5 -> System.out.println("Bye!");
            }
        } while (stopOrGo != 5);
    }
}
