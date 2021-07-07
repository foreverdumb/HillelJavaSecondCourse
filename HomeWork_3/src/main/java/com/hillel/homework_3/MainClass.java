package com.hillel.homework_3;

import java.util.Scanner;

public class MainClass extends CarClass {
    public static void main(String[] args) {

        int option;
        int counter = 0;
        int[] sequenceOfOptions = {1, 2, 4, 3, 5, 6, 7};
        Scanner sc = new Scanner(System.in);


        do {
            counter++;
            System.out.println("""
                    Please, choose an option:\s
                    1 - Full trip cost\s
                    2 - Fuel u need to fill up by reaching Krivoe Ozero\s
                    3 - Fuel u need to fill up by reaching Zhaskov\s
                    4 - Refuel when reached Krivoe Ozero\s
                    5 - Refuel when reached Zhaskov
                    6 - Fuel left when u reached Kyiv\s
                    7 - Exit""");
            while (!sc.hasNextInt()) {
                System.out.println("Integer required!");
                sc.next();
            }
            option = sc.nextInt();

            for (int i = 0; i < sequenceOfOptions.length; i++) {
                if (!(option == sequenceOfOptions[counter - 1])) {
                    System.out.println("Wrong travel sequence. " +
                            "\nThe right way to travel: choose options in the next sequence: " +
                            "1, 2, 4, 3, 5, 6, 7");
                    System.exit(1);
                }
            }
            switch (option) {
                case 1 -> {
                    CarClass cost = new CarClass();
                    for (String arr : args) {
                        int result = Integer.parseInt(arr);
                        System.out.println("Total cost of trip(UAH): "
                                + (double) result * (cost.consumptionA() + cost.consumptionB()));
                    }
                }
                case 2 -> {

                    CarClass infoStopA = new CarClass();
                    infoStopA.refuelInfoA();
                }
                case 3 -> {

                    CarClass infoStopB = new CarClass();
                    infoStopB.refuelInfoB();
                }
                case 4 -> {

                    CarClass refuelA = new CarClass();
                    System.out.println("Your car refueled, when reached the Krivoe Ozero," +
                            " total amount: " + refuelA.refuelA());
                }
                case 5 -> {

                    CarClass refuelB = new CarClass();
                    System.out.println("Your car refueled when reached the Zhaskov," +
                            " total amount: " + refuelB.refuelB());
                }
                case 6 -> {

                    CarClass fuelLeftWhenReachedKyiv = new CarClass();
                    fuelLeftWhenReachedKyiv.amountOfFuelWhenReachedKyiv();
                }
                case 7 -> System.out.println("Bye!");
            }
        } while (option != 7);
    }
}
