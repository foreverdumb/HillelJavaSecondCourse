package com.hillel.homework_17.service;

import com.hillel.homework_17.enamuration.TransactionEnum;
import com.hillel.homework_17.models.CustomerClass;

import java.util.UUID;

public class AtmServiceClass {
    volatile static int atmQuantityOfCashMoney = 1_000_000;
    volatile static long moneyToTransfer = 0;
    static String atmName = "HillelATM#1";

    public synchronized static boolean isMoneyStillLeft(CustomerClass customer, TransactionEnum transaction,
                                                        int quantityOfMoneyToGrab, int quantityOfMoneyToReplenish) {

        switch (transaction) {
            case GRAB -> {
                if (quantityOfMoneyToGrab < atmQuantityOfCashMoney) {
                    atmQuantityOfCashMoney -= quantityOfMoneyToGrab;
                    System.out.println("-----------------------------------------" +
                            "\nTransaction info..." +
                            "\nServicing ATM name: " + atmName +
                            "\nCustomer name: " + customer.getName() +
                            "\nTransaction id: " + UUID.randomUUID() +
                            "\nQuantity of money you grabbed: " + quantityOfMoneyToGrab + "$" +
                            "\nOperation successful, take your cash please...");
                    System.out.println("ATM cash left: " + atmQuantityOfCashMoney + "$" +
                            "\nYou took: " + quantityOfMoneyToGrab + "$");
                    return true;
                } else if (quantityOfMoneyToGrab >= atmQuantityOfCashMoney) {
                    quantityOfMoneyToGrab = atmQuantityOfCashMoney;
                    int res = atmQuantityOfCashMoney - quantityOfMoneyToGrab;
                    if (res == 0) {
                        return false;
                    }
                }
            }
            case REPLENISH -> {
                if (atmQuantityOfCashMoney != 0) {

                    moneyToTransfer += quantityOfMoneyToReplenish;
                    System.out.println("-----------------------------------------" +
                            "\nTransaction info..." +
                            "\nServicing ATM name: " + atmName +
                            "\nCustomer name: " + customer.getName() +
                            "\nTransaction id: " + UUID.randomUUID() +
                            "\nQuantity of money you replenished: " + quantityOfMoneyToReplenish + "$" +
                            "\nOperation successful, money transferred...");
                    System.out.println("-----------------------------------------" +
                            "\nTotal quantity of money transferred: " + moneyToTransfer + "$" +
                            "\nYou transferred: " + quantityOfMoneyToReplenish + "$");
                    return true;
                }
            }
        }
        return false;
    }
}
