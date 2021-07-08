package com.hillel.homework_14.utils;

import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GameUtilClass {
    private static int setYourOption() {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            System.out.println("""
                    Please, enter one of these options:
                    0 - stone;
                    1 - paper;
                    2 - scissors.
                    Be patient, type in NUMBERS instead of words.
                    """);
            while (!sc.hasNextInt()) {
                System.out.println("Integer required!");
                sc.next();
            }
            option = sc.nextInt();
        } while (option < 0);
        return option;
    }

    private static int setGameQuantity() {
        Scanner sc = new Scanner(System.in);
        int quantity;
        do {
            System.out.println("Please, set the number of games u want to play: ");
            while (!sc.hasNextInt()) {
                System.out.println("Integer required!");
                sc.next();
            }
            quantity = sc.nextInt();
        } while (quantity <= 0);
        return quantity;
    }

    private static int createArtificialIntelligence() {
        return ThreadLocalRandom.current().nextInt(0, 2);
    }

    private static String setUserName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please, enter your name(English letters only, or your name will be set automatically): ");
        if (sc.hasNext("[A-Za-z]*")) {
            return sc.nextLine();
        } else {
            return "No One";
        }
    }

    private static String goOrStop() {
        Scanner sc = new Scanner(System.in);
        String option;
        System.out.println("""
                Enter 'Yes' to continue the game
                Enter 'No' to stop the game
                """);
        option = sc.nextLine();
        if (!option.equals("Yes"))
            if (!option.equals("No"))
                System.out.println("Wrong input!");
        return option;
    }

    public static void getWinner() throws IndexOutOfBoundsException {
        String name = setUserName();
        String yesNo;
        int quantity = setGameQuantity();
        int totalWins = 0;
        int totalLoses = 0;
        int totalDraws = 0;

        int[][] answersTable = new int[3][3];
        answersTable[0][0] = 0;
        answersTable[0][1] = 1;
        answersTable[0][2] = 2;
        answersTable[1][0] = 2;
        answersTable[1][1] = 0;
        answersTable[1][2] = 1;
        answersTable[2][0] = 1;
        answersTable[2][1] = 2;
        answersTable[2][2] = 0;

        try {
            do {
                int[] answers = getAnswers();
                int artificial;
                int user;
                artificial = answers[0];
                user = answers[1];
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < answersTable[i].length; j++) {
                        if (answersTable[i][j] == answersTable[artificial][user]) {
                            if (answersTable[i][j] == 0) {
                                totalDraws++;
                                System.out.println("Draw, robot chose the same option <<"
                                        + artificial + ">> as you!");
                            } else if (answersTable[i][j] == 1) {
                                totalWins++;
                                System.out.println("User " + name + " wins! "
                                        + "Robot chose <<" + artificial + ">> option! ");
                            } else {
                                totalLoses++;
                                System.out.println("Robot wins, it chose <<" + artificial + ">> option!");
                            }
                        }
                    }
                }
                quantity--;
                if (quantity == 0) break;
                yesNo = goOrStop();
            } while (Objects.equals(yesNo, "Yes") && quantity > 0);
            System.out.println("---------------------------------------");
            System.out.println("Dear " + name + ", your total wins equal: " + totalWins
                    + " and total loses equal: " + totalLoses
                    + " if you are interested in draws, the total count equals: " + totalDraws);
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println("You are allowed to enter only 3 options - 0, 1 and 2. " +
                    "Read startup description carefully!");
        }
    }

    private static int[] getAnswers() {
        int choiceOfArtificialIntelligence;
        int userChoice;
        int[] arrAnswers = new int[2];


        choiceOfArtificialIntelligence = createArtificialIntelligence();
        userChoice = setYourOption();
        arrAnswers[0] = choiceOfArtificialIntelligence;
        arrAnswers[1] = userChoice;

        return arrAnswers;
    }
}
