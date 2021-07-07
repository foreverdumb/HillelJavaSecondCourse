package com.hillel.homework_2;

import com.hillel.homework_2.arithmeticMean.FindingArithmeticMeanClass;
import com.hillel.homework_2.changeElements.ChangingElementsClass;
import com.hillel.homework_2.chessDesk.PrintingChessDeskClass;
import com.hillel.homework_2.findingElement.FindingMaxElement;
import com.hillel.homework_2.findingElement.FindingMinElementClass;
import com.hillel.homework_2.findingFactorialClass.FindingFactorialClass;
import com.hillel.homework_2.findingFactorialClass.FindingFactorialUsingDoWhileClass;
import com.hillel.homework_2.findingFactorialClass.FindingFactorialUsingWhileClass;
import com.hillel.homework_2.multiplicationTables.MultiplicationTablesClass;
import com.hillel.homework_2.pow.PowClass;
import com.hillel.homework_2.sequence.SequenceClass;
import com.hillel.homework_2.showingTheOddNumbers.ShowingOddNumbersArrClass;
import com.hillel.homework_2.showingTheOddNumbers.ShowingTheOddNumbersClass;
import com.hillel.homework_2.showingTheOddNumbers.ShowingTheOddNumbersUsingDoWhileClass;
import com.hillel.homework_2.showingTheOddNumbers.ShowingTheOddNumbersUsingWhileClass;

import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        int set_option;

        do {
        set_option = setOption();
        switch (set_option) {
            case 1 -> ShowingTheOddNumbersClass.showOddNumbers();
            case 2 -> FindingFactorialClass.findFactorial();
            case 3 -> ShowingTheOddNumbersUsingWhileClass.showOddNumbersUsingWhileLoop();
            case 4 -> ShowingTheOddNumbersUsingDoWhileClass.showingTheOddNumbersUsingDoWhileLoop();
            case 5 -> FindingFactorialUsingWhileClass.findFactorialUsingWhileLoop();
            case 6 -> FindingFactorialUsingDoWhileClass.findingFactorialUsingDoWhileLoop();
            case 7 -> PowClass.calculatePow();
            case 8 -> SequenceClass.printSequence();
            case 9 -> MultiplicationTablesClass.printTable();
            case 10 -> ShowingOddNumbersArrClass.printOddNumbersArr();
            case 11 -> FindingMinElementClass.findMinElement();
            case 12 -> FindingMaxElement.findMaxElement();
            case 13 -> ChangingElementsClass.changeElements();
            case 14 -> FindingArithmeticMeanClass.findArithmeticMeanArr();
            case 15 -> PrintingChessDeskClass.printChessDesk();
            case 16 -> System.out.println("Bye");
        }

        } while (set_option != 16);
    }

    public static int setOption() {
        int option;
        Scanner option_sc = new Scanner(System.in);
        List<Integer> options = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);

        do {
            System.out.println("""
                    Please, choose the next option:
                    1 -  Task #1;
                    2 -  Task #2;
                    3 -  Task #3;
                    4 -  Task #4;
                    5 -  Task #5;
                    6 -  Task #6;
                    7 -  Task #7;
                    8 -  Task #8;
                    9 -  Task #9;
                    10 - Task #10;
                    11 - Task #11;
                    12 - Task #12;
                    13 - Task #13;
                    14 - Task #14;
                    15 - Task #15;
                    16 - Exit.
                    """);
            while (!option_sc.hasNextInt()) {
                System.out.println("Integer required!");
                option_sc.next();
            }
            option = option_sc.nextInt();
        } while (!options.contains(option));
        return option;
    }
}
