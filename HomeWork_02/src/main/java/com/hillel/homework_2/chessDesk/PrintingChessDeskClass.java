package com.hillel.homework_2.chessDesk;

public class PrintingChessDeskClass {

    public static void printChessDesk() {
        String[][] deck = new String[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                deck[i][j] = (i + j) % 2 == 0 ? "B" : "W";
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(deck[i][j] + " ");
            }
            System.out.println();
        }
    }
}
