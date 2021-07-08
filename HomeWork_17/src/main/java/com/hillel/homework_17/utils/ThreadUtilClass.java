package com.hillel.homework_17.utils;

import com.hillel.homework_17.models.CustomerClass;

public class ThreadUtilClass {
    public static void createThreads() {
        Thread client1 = new CustomerClass("Client_1");
        Thread client2 = new CustomerClass("Client_2");
        Thread client3 = new CustomerClass("Client_3");
        Thread client4 = new CustomerClass("Client_4");

        client1.start();
        client2.start();
        client3.start();
        client4.start();
    }
}
