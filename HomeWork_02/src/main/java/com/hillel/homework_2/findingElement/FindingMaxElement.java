package com.hillel.homework_2.findingElement;

import java.util.Arrays;
import java.util.Scanner;

public class FindingMaxElement {

    public static void findMaxElement() {
        int size = setSize();
        int buff;
        boolean isSorted = false;
        int[] array = initArr(size);


        while (!isSorted) {

            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {

                if (array[i] < array[i + 1]) {
                    isSorted = false;
                    buff = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buff;
                }
            }
        }
        for (int i = 1; i < array.length; i++) {
            if (array[0] == array[i]) {
                System.out.println("Duplicate of max found: " + array[i]);
            } else {
                System.out.println("No duplicates, the max value is: " + array[0]);
            }
        }
        System.out.println("Array: " + Arrays.toString(array).replaceAll("^\\[|\\]$", ""));
    }

    public static int setSize() {
        int size;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Please, enter the arr value: ");
            while (!sc.hasNextInt()) {
                System.out.println("Integer required!");
                sc.next();
            }
            size = sc.nextInt();
        } while (size <= 0);
        return size;
    }

    private static int[] initArr(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }
}
