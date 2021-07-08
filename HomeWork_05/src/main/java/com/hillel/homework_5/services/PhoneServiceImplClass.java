package com.hillel.homework_5.services;

import com.hillel.homework_5.models.PhoneClass;

public class PhoneServiceImplClass implements PhoneService {

    @Override
    public void printAllObj(PhoneClass[] objectsArr) {
        for (PhoneClass subscribers : objectsArr) {
            System.out.println(subscribers);
        }
        System.out.println();
    }

    @Override
    public void printSubscribersIncreasedCityCalls(PhoneClass[] objectsArr, int time) {
        for (PhoneClass subscribers : objectsArr) {
            if (subscribers.getTimeOfCityDistanceCalls() > time) {
                System.out.println(subscribers);
            }
            System.out.println();
        }
    }

    @Override
    public void printSubscribersUsedLongDistanceCalls(PhoneClass[] objectsArr) {
        for (PhoneClass subscribers : objectsArr) {
            if (subscribers.getTimeOfLongDistanceCalls() > 0) {
                System.out.println(subscribers);
            }
            System.out.println();
        }
    }
}
