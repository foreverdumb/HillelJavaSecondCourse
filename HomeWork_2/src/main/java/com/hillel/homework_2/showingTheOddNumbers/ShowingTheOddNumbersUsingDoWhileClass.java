package com.hillel.homework_2.showingTheOddNumbers;

public class ShowingTheOddNumbersUsingDoWhileClass {

    public static void showingTheOddNumbersUsingDoWhileLoop() {
        int limit = 0;

        do {
            limit++;

            if (limit % 2 != 0) {
                System.out.println(limit);
            }
        } while (limit != 100);
    }
}
