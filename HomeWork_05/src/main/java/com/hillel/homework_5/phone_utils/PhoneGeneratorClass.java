package com.hillel.homework_5.phone_utils;

import com.hillel.homework_5.models.PhoneClass;

public class PhoneGeneratorClass {
    public static PhoneClass[] generateArray() {
        PhoneClass[] objectsArr = new PhoneClass[15];

        objectsArr[0] = new PhoneClass("Evgeniy", "Loshev", "Andreevich",
                "Kanatnaya, 5", 3445567898764567L, 45, 50, 43,
                56, 433, 4);

        objectsArr[1] = new PhoneClass("Anna", "Karenina", "Gennadievich",
                "Orehovaya, 5", 2114441210807654L, 20, 30, 15,
                0, 22, 100);

        objectsArr[2] = new PhoneClass("Igor", "Dostoevsliy", "Romanovich",
                "Malaya, 5", 3124445110867654L, 40, 20, 200,
                0, 48, 5);

        objectsArr[3] = new PhoneClass("Vasilisa", "Tolstaya", "Fedorovna",
                "Bolshaya, 5", 4114451106807654L, 10, 5, 50,
                40, 32, 4);

        objectsArr[4] = new PhoneClass("Vasiliy", "Veter", "Vladimirovich",
                "Morskaya, 5", 9114447110807654L, 40, 80, 0,
                140, 40, 3);

        objectsArr[5] = new PhoneClass("Petr", "Gromov", "Olegovich",
                "Solnechnaya, 5", 8116471405806654L, 50, 40, 0,
                70, 5000, 1);

        objectsArr[6] = new PhoneClass("Dariya", "Rudskaya", "Semenovna",
                "Pasmurnaya, 5", 9914441760807654L, 100, 70, 67,
                100, 568, 1);

        objectsArr[7] = new PhoneClass("Alina", "Lubimova", "Petrovna",
                "Cvetochnaya, 5", 4415461718897654L, 40, 30, 70,
                88, 545, 4);

        objectsArr[8] = new PhoneClass("Olha", "Brizjan", "Alexandrovna",
                "Rozovaya, 5", 3315461718897054L, 47, 58, 68,
                0, 525, 150);

        objectsArr[9] = new PhoneClass("Vladimir", "Shaporin", "Olegovich",
                "Elochnaya, 5", 2254647140302654L, 150, 189, 150,
                0, 500, 200);

        objectsArr[10] = new PhoneClass("Vladislav", "Gorobec", "Mikhailovich",
                "Genuezskaya, 5", 7716471813899050L, 200, 177, 157,
                770, 30, 0);

        objectsArr[11] = new PhoneClass("Alexandr", "Dudkevich", "Alexandrovitch",
                "Hovorova, 5", 8814443130507600L, 40, 30, 0,
                0, 400, 0);

        objectsArr[12] = new PhoneClass("Roman", "Igoshin", "Romanovich",
                "Chernyahovskogo, 5", 101047171889650L, 40, 30, 30,
                0, 550, 22);

        objectsArr[13] = new PhoneClass("Slava", "Nemcov", "Vasil'evich",
                "Primorskaya, 5", 110047140867694L, 43, 39, 39,
                10, 500, 30);

        objectsArr[14] = new PhoneClass("Mikhail", "Naval'niy", "Gennadievich",
                "Puskinskaya, 5", 3030541317808690L, 334, 150, 0,
                20, 500, 32);

        return objectsArr;
    }
}
