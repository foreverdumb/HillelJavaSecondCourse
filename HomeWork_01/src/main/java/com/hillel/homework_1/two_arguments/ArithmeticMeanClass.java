package com.hillel.homework_1.two_arguments;

public class ArithmeticMeanClass {

    public static void findArithmeticMeanTwoArgs(String... args) {
        double sum = 0D;
        double arithmeticMean = 0D;
        int divider = 2;

        if (args.length == 2) {
            System.out.println("Program arguments: ");
            for (String str : args) {
                System.out.println(str);
                int transformation = Integer.parseInt(str);
                sum += transformation;
                arithmeticMean = sum / divider;
            }
            System.out.println("-----------------------------------------");
            System.out.println("Arithmetic mean of two arguments equals: " + arithmeticMean);
        } else System.out.println("For using this tool write as programme arguments TWO numbers");
    }

    public static void findArithmeticMeanMultipleArgs(String... args) {
        int counter = 0;
        double sum = 0D;
        double arithmeticMean = 0D;

        if (args.length != 0) {
            System.out.println("Program arguments: ");
            for (String str : args) {
                counter++;
                System.out.println(str);
                int transformation = Integer.parseInt(str);
                sum += transformation;
                arithmeticMean = sum / counter;
            }
            System.out.println("-----------------------------------------");
            System.out.println("Arithmetic mean of " + counter + " arguments equals: " + arithmeticMean);
        } else System.out.println("For using this tool you can not leave programme arguments unfilled.");
    }
}
