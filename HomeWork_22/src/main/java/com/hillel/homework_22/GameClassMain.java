package com.hillel.homework_26;

import com.hillel.homework_26.utils.GameUtilClass;

public class GameClassMain {
    public static void main(String[] args) {
        if (args.length == 1) {
            String language = args[0].toLowerCase();
            GameUtilClass.setLocale(language);
        } else if (args.length > 1) {
            System.out.println("Allowed to enter only ONE argument (ru/uk/en)");
            System.exit(1);
        }
        GameUtilClass.getWinner();
    }
}
