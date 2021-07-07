package com.hillel.homework_1;

import com.hillel.homework_1.bank_app.BankAppClass;
import com.hillel.homework_1.two_arguments.ArithmeticMeanClass;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {

        do {
            switch (setOption()) {
                case 1 -> ArithmeticMeanClass.findArithmeticMeanTwoArgs(args);
                case 2 -> ArithmeticMeanClass.findArithmeticMeanMultipleArgs(args);
                case 3 -> BankAppClass.findPercent();
            }
        } while (goOrStop().equals("Yes"));
    }

    public static int setOption() {
        Scanner option = new Scanner(System.in);
        int option_number;

        do {
            System.out.println("""
                    Please, enter your option:
                    1 - Task #1 Arithmetic mean two args;
                    2 - Task #2 Arithmetic mean multiple args;
                    3 - Task #3 Bank app to count percent.
                    """);
            while (!option.hasNextInt()) {
                System.out.println("Integer required!");
                option.next();
            }
            option_number = option.nextInt();
        } while (option_number != 1 && option_number != 2 && option_number != 3 && option_number != 4);

        return option_number;
    }

    public static String goOrStop() {
        Scanner stopContinue = new Scanner(System.in);
        String option;

        do {
            System.out.println("""
                    Type 'Yes' to continue
                    Type 'No' to stop
                    """);
            option = stopContinue.next();
        } while (!option.equals("Yes") && !option.equals("No"));
        return option;
    }
}
