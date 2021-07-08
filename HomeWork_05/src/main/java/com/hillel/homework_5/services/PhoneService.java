package com.hillel.homework_5.services;

import com.hillel.homework_5.models.PhoneClass;

public interface PhoneService {
    void printAllObj(PhoneClass[] objectsArr);

    void printSubscribersIncreasedCityCalls(PhoneClass[] objectsArr, int time);

    void printSubscribersUsedLongDistanceCalls(PhoneClass[] objectsArr);
}
