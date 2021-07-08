package com.hillel.homework_13.utils;

import java.util.Arrays;

public class PseudoGraphicsUtilClass {
    private static String[] getGraphicalTemplate(String number) {

        switch (number) {
            case "1" -> {
                return new String[]{
                        "  @@  ",
                        " @@@  ",
                        "@ @@  ",
                        "  @@  ",
                        "@@@@@@"};

            }
            case "2" -> {
                return new String[]{
                        " @@@@ ",
                        "@@  @@",
                        "   @@ ",
                        "  @@  ",
                        "@@@@@@"};
            }
            case "3" -> {
                return new String[]{
                        " @@@@ ",
                        "@@  @@",
                        "   @@ ",
                        "@@  @@",
                        " @@@@ "};
            }
            case "4" -> {
                return new String[]{
                        "   @@ ",
                        "  @ @ ",
                        " @  @ ",
                        "@@@@@@",
                        "    @ "};
            }
            case "5" -> {
                return new String[]{
                        "@@@@@@",
                        "@@    ",
                        "@@@@@ ",
                        "    @@",
                        "@@@@@ "};
            }
            case "6" -> {
                return new String[]{
                        " @@@@ ",
                        "@@    ",
                        "@@@@@ ",
                        "@@  @@",
                        " @@@@ "};
            }
            case "7" -> {
                return new String[]{
                        "@@@@@@",
                        "   @@ ",
                        "  @@  ",
                        " @@   ",
                        "@@    "};
            }
            case "8" -> {
                return new String[]{
                        " @@@@ ",
                        "@@  @@",
                        " @@@@ ",
                        "@@  @@",
                        " @@@@ "};
            }
            case "9" -> {
                return new String[]{
                        " @@@@ ",
                        "@@  @@",
                        " @@@@@",
                        "    @@",
                        " @@@@ "};
            }
            case "0" -> {
                return new String[]{
                        " @@@@ ",
                        "@@  @@",
                        "@@  @@",
                        "@@  @@",
                        " @@@@ "};
            }
            default -> {
                return new String[]{"ERROR"};
            }
        }
    }

    private static String[] transformNumToGraphics(String number) throws IndexOutOfBoundsException {
        String reverseNumberStr = new StringBuffer(number).reverse().toString();
        int spaces = number.length() - number.replaceAll(" ", "").length();
        int strLengthNoSpaces = number.length() - spaces;
        int counter = 0;
        String[] splittingTheNumberStr = reverseNumberStr.split("");
        String[] stringNumArr = {"", "", "", "", ""};
        String[] tempArr;
        try {
            while (counter != strLengthNoSpaces) {
                for (String s : splittingTheNumberStr) {
                    tempArr = getGraphicalTemplate(s);
                    for (int i = 0; i < stringNumArr.length; i++) {
                        stringNumArr[i] = tempArr[i] + " " + stringNumArr[i];
                    }
                    counter++;
                }
            }
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println(indexOutOfBoundsException.getMessage());
            indexOutOfBoundsException.printStackTrace();
        }
        return stringNumArr;
    }

    private static void printStreamOfTransformedNum(String[] strArr) {
        Arrays.stream(strArr).forEach(System.out::println);
    }

    public static void outPutResult(String strNumber) {
        PseudoGraphicsUtilClass.printStreamOfTransformedNum(PseudoGraphicsUtilClass.transformNumToGraphics(strNumber));
    }
}
