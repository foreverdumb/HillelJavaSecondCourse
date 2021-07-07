package com.hillel.homework_2.arithmeticMean;

import java.util.Arrays;

import static com.hillel.homework_2.findingElement.FindingMaxElement.setSize;

public class FindingArithmeticMeanClass {

    public static void findArithmeticMeanArr() {
        int size = setSize();
        double arithmeticMean = 0D;
        int [] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
            arithmeticMean = arithmeticMean + array[i] / (double) size;
        }
        System.out.println(Arrays.toString(array).replaceAll("^\\[|\\]$", "") + " - Array");
        System.out.println("Arithmetic mean equals: " + arithmeticMean);
    }


}
