package com.hillel.homework_22.utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class GameUtilClass {
    static Locale loc = Locale.getDefault();
    static ResourceBundle rb = ResourceBundle.getBundle("l10nOfTheApp", loc);
    static String uuid = String.valueOf(UUID.randomUUID());
    static String userName;

    static {
        System.setProperty("UUID", uuid);
    }

    private static final Logger app_logger = LogManager.getLogger("appLogger");
    private static final Logger games_logger = LogManager.getLogger("gamesLogger");

    public static int setYourOption() {
        app_logger.log(Level.INFO, "USER ENTERED TO THE NEW GAME ROUND. <<" + userName + ">>");
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            System.out.println(rb.getString("options"));
            while (!sc.hasNextInt()) {
                app_logger.log(Level.WARN, "NON INTEGER WHILE CHOOSING THE GAME OPTION. <<" + userName + ">>");
                sc.next();
            }
            option = sc.nextInt();
            checkInput(option);
        } while (option != 1 && option != 2 && option != 0);
        return option;
    }

    public static void checkInput(int option) {
        List<Integer> optionsList = List.of(0, 1, 2);
        if (!optionsList.contains(option)) {
            app_logger.log(Level.WARN, "INCORRECT INPUT. NO SUCH OPTIONS. <<" + userName + ">>");
        }
    }

    public static int setGameQuantity() {
        Scanner sc = new Scanner(System.in);
        int quantity;
        do {
            System.out.println(rb.getString("numberOfGames"));
            while (!sc.hasNextInt()) {
                app_logger.log(Level.WARN, "NON INTEGER WHILE CHOOSING THE GAME QUANTITY. <<" + userName + ">>");
                sc.next();
            }
            quantity = sc.nextInt();
        } while (quantity <= 0);
        return quantity;
    }

    public static int createArtificialIntelligence() {
        return ThreadLocalRandom.current().nextInt(0, 2);
    }

    public static String setUserName() {
        Scanner sc = new Scanner(System.in);
        System.out.println(rb.getString("setUserName"));
        if (sc.hasNext("[A-Za-z]*")) {
            return sc.nextLine();
        } else {
            app_logger.log(Level.WARN, "NO USERNAME WAS FOUND, WAS SET BY DEFAULT. <<" + userName + ">>");
            return "No One";
        }
    }

    public static String goOrStop() {
        Scanner sc = new Scanner(System.in);
        String option;
        do {
            System.out.println(rb.getString("goOrStop"));
            option = sc.nextLine();
            if (!option.equals("Yes") && !option.equals("No")) {
                app_logger.log(Level.WARN, "YES OR NO WERE TYPED INCORRECTLY. <<" + userName + ">>");
            }
        } while (!option.equals("Yes") && !option.equals("No"));
        return option;
    }

    public static void getWinner() throws IndexOutOfBoundsException {
        app_logger.log(Level.INFO, "APP STARTED...");
        userName = setUserName();
        String yesNo;
        int quantity = setGameQuantity();
        int totalWins = 0;
        int totalLoses = 0;
        int totalDraws = 0;
        int logQuantity = quantity;
        int logQuantityDeclined = quantity;
        int declineResult;
        int leftToPlay;

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
                                games_logger.log(Level.INFO, "Draw, robot chose the same option <<" + artificial
                                        + ">> as you! Player: <<" + userName + ">>");
                                System.out.println(rb.getString("draw"));
                            } else if (answersTable[i][j] == 1) {
                                totalWins++;
                                games_logger.log(Level.INFO, "User <<" + userName + ">> wins! "
                                        + "Player's option <<" + user + ">>"
                                        + " Robot chose <<" + artificial + ">> option!");
                                rb.getString("win");
                            } else {
                                totalLoses++;
                                games_logger.log(Level.INFO, "Robot wins, it chose <<" + artificial + ">> option! " +
                                        "Player: <<" + userName + ">> looses!" + "\nPlayer's option <<" + user + ">>");
                                System.out.println(rb.getString("loss"));
                            }
                        }
                    }
                }

                quantity--;
                declineResult = logQuantityDeclined - quantity;
                leftToPlay = logQuantity - declineResult;

                games_logger.log(Level.INFO, "ROUNDS WERE CHOSEN: " + logQuantity);
                games_logger.log(Level.INFO, "ROUNDS WERE PLAYED: " + declineResult);
                games_logger.log(Level.INFO, "ROUNDS LEFT TO PLAY: " + leftToPlay);

                if (quantity == 0) {
                    app_logger.log(Level.INFO, "USER EXITED THE GAME. <<" + userName + ">>");
                    break;
                }

                yesNo = goOrStop();
                if (yesNo.equals("No")) {
                    app_logger.log(Level.INFO, "USER EXITED THE GAME. <<" + userName + ">>");
                    app_logger.log(Level.WARN, "'NO' OPTION WAS CHOSEN BY THE USER. <<" + userName + ">>");
                }
            } while (Objects.equals(yesNo, "Yes") && quantity > 0);

            games_logger.log(Level.WARN, "\nDear <<" + userName + ">>, your total wins equal: <<" + totalWins
                    + ">> \nand total loses equal: <<" + totalLoses
                    + ">> \nIf you are interested in draws, the total count equals: <<" + totalDraws + ">>");
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            indexOutOfBoundsException.printStackTrace();
        }
        app_logger.log(Level.INFO, "APP EXECUTED...");
    }

    public static int[] getAnswers() {
        int choiceOfArtificialIntelligence;
        int userChoice;
        int[] arrAnswers = new int[2];


        choiceOfArtificialIntelligence = createArtificialIntelligence();
        userChoice = setYourOption();
        arrAnswers[0] = choiceOfArtificialIntelligence;
        arrAnswers[1] = userChoice;

        return arrAnswers;
    }

    public static void setLocale(String lang) {
        if (!lang.equals("ru") && !lang.equals("en") && !lang.equals("uk")) {
            app_logger.log(Level.WARN, "WRONG LOCALE INPUT");
            System.exit(1);
        }
        loc = new Locale(lang);
        rb = ResourceBundle.getBundle("l10nOfTheApp", loc);
    }
}
