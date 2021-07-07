package com.hillel.homework_2.findingFactorialClass;

import static com.hillel.homework_2.findingFactorialClass.FindingFactorialUsingWhileClass.setLimit;

public class FindingFactorialUsingDoWhileClass {

    public static void findingFactorialUsingDoWhileLoop() {
        int getLimit = setLimit();
        int stopDoWhile = 1;
        int calculateFactorial = 1;

        do {

            stopDoWhile++;
            calculateFactorial *= stopDoWhile;
        } while (stopDoWhile != getLimit);
        System.out.println("The factorial of " + getLimit + " equals: " + calculateFactorial);
    }
}
