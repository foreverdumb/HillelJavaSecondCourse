package com.hillel.homework_2.findingFactorialClass;

import static com.hillel.homework_2.findingFactorialClass.FindingFactorialUsingWhileClass.setLimit;

public class FindingFactorialClass {

    public static void findFactorial() {
        int getValue = setLimit();
        int calculateFactorial = 1;

        for (int i = 1; i <= getValue; i++) {

            calculateFactorial *= i;
        }
        System.out.println("The factorial equals: " + calculateFactorial);
    }
}
