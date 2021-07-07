package com.hillel.homework_2.showingTheOddNumbers;

public class ShowingTheOddNumbersClass {

    public static void showOddNumbers() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }
}