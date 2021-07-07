package com.hillel.homework_2.sequence;

public class SequenceClass {

    public static void printSequence() {
        for (int i = 0; i < 50; i += 5) {
            if (i > 0) {
                System.out.print("-");
            }
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
