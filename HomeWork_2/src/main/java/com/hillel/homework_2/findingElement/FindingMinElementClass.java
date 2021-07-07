package com.hillel.homework_2.findingElement;

import java.util.Arrays;

import static com.hillel.homework_2.findingElement.FindingMaxElement.setSize;

public class FindingMinElementClass {

    public static void findMinElement() {

        int size = setSize();
        int buff;
        boolean isSorted = false;
        int[] array = initArr(size);



        while (!isSorted) {
            isSorted = true;

            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    isSorted = false;
                    buff = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buff;
                }
            }
        }

        for (int i = 1; i < array.length; i++) {
            if (array[0] == array[i]) {
                System.out.println("Duplicate of min found: " + array[i]);
            } else {
                System.out.println("No duplicates, the min value is: " + array[0]);
            }
        }
        System.out.println("Array: " + Arrays.toString(array).replaceAll("^\\[|\\]$", ""));
    }

    private static int[] initArr(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }
}
