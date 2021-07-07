package com.hillel.homework_2.showingTheOddNumbers;

public class ShowingTheOddNumbersUsingWhileClass {

    public static void showOddNumbersUsingWhileLoop() {
        int stopWhile = 0;

        while (stopWhile != 100) {
            stopWhile++;
            if (stopWhile % 2 != 0) {
                System.out.println(stopWhile);
            }
        }
    }
}
