package com.hillel.homework_17.models;

import com.hillel.homework_17.enamuration.TransactionEnum;
import com.hillel.homework_17.service.AtmServiceClass;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CustomerClass extends Thread {

    public CustomerClass(String customerName) {
        super(customerName);
    }

    private int setQuantityOfMoneyToGrab() {
        return ThreadLocalRandom.current().nextInt(1_00, 100_000);
    }

    private int setQuantityOfMoneyToReplenish() {
        return ThreadLocalRandom.current().nextInt(1_00, 10_000);
    }

    private TransactionEnum chooseRandomOption() {
        int pick = new Random().nextInt(TransactionEnum.values().length);
        return TransactionEnum.values()[pick];
    }

    @Override
    public synchronized void run() {
        boolean isHaveCash;

        do {
            isHaveCash = AtmServiceClass.isMoneyStillLeft(this, chooseRandomOption(), setQuantityOfMoneyToGrab(),
                    setQuantityOfMoneyToReplenish());
        } while (isHaveCash);
        System.out.println("-----------------------------------------" +
                "\n" +
                this.getName() +
                " went away");
    }
}
