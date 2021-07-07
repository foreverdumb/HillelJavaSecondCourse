package com.hillel.homework_2.changeElements;

import java.util.Arrays;
import java.util.Scanner;

public class ChangingElementsClass {

    public static void changeElements() {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.println("Please, enter a value of an array: ");
            while (!sc.hasNextInt()) {
                System.out.println("Please, enter integer!");
                sc.next();
            }
            n = sc.nextInt();
        } while (n <= 0);
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
        }
        System.out.println(Arrays.toString(array).replaceAll("^\\[|\\]$", "")
                + " - default array");
        int[] result = changePlaces(array);
        System.out.println(Arrays.toString(result).replaceAll("^\\[|\\]$", "")
                + " - array with changed elements");
    }

    private static int[] changePlaces(int[] array) {
        int buffer;
        if (array[0] == array[array.length - 1]) {
            System.out.println("First and second elements are similar.");
        } else {
            buffer = array[0]; //buffer = 1 (just for an example)
            array[0] = array[array.length - 1]; // first = last
            array[array.length - 1] = buffer; // last = buffer
        }
        return array;
    }
}
