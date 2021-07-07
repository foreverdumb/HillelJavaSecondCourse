package com.hillel.homework_2.showingTheOddNumbers;

import java.util.Arrays;

public class ShowingOddNumbersArrClass {

    public static void printOddNumbersArr() {
        int[] array = new int[10];

        array[0] = 1;
        array[1] = 3;
        array[2] = 5;
        array[3] = 7;
        array[4] = 9;
        array[5] = 11;
        array[6] = 13;
        array[7] = 15;
        array[8] = 17;
        array[9] = 19;

        System.out.print(Arrays.toString(array).replaceAll("^\\[|\\]$", ""));
    }
}
