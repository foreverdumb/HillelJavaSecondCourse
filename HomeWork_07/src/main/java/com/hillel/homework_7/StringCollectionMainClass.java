package com.hillel.homework_7;

import com.hillel.homework_7.service.StringCollectionImplClass;

public class StringCollectionMainClass {
    public static void main(String[] args) {
        StringCollectionImplClass stringCollection_1 = new StringCollectionImplClass();
        StringCollectionImplClass stringCollection_2 = new StringCollectionImplClass();

        String[] strArr = new String[5];

        strArr[0] = "1";
        strArr[1] = "1";
        strArr[2] = "1";
        strArr[3] = "1";
        strArr[4] = "1";

        stringCollection_1.add("1");
        stringCollection_1.add("2");
        stringCollection_1.add("3");
        stringCollection_1.add("4");
        stringCollection_1.add("5");
        stringCollection_1.add("6");
        stringCollection_1.add("7");
        stringCollection_1.add("8");
        stringCollection_1.add("9");
        stringCollection_1.add("10");
        stringCollection_1.add("11");

        stringCollection_2.add("01");
        stringCollection_2.add("02");
        stringCollection_2.add("03");
        stringCollection_2.add("04");
        stringCollection_2.add("05");
        stringCollection_2.add("06");
        stringCollection_2.add("07");
        stringCollection_2.add("08");

        System.out.println(stringCollection_1);
        System.out.println();

        //ITERATOR

        System.out.println("------------------------------------------------------------");

        for (Object strColl :
                stringCollection_1) {
            System.out.println(strColl + "\n");
        }

        System.out.println("------------------------------------------------------------");

        stringCollection_1.add(1, "Vasiliy");
        stringCollection_1.add(2, "Alexandr");
        System.out.println(stringCollection_1);
        System.out.println();

        stringCollection_1.delete("Vasiliy");
        System.out.println(stringCollection_1.size());
        System.out.println(stringCollection_1);
        System.out.println();

        System.out.println("Is Alexandr? " + stringCollection_1.contains("Alexandr"));
        System.out.println();

        System.out.println("Size: " + stringCollection_1.size());
        System.out.println();

        System.out.println("Is equals? " + stringCollection_1.equals(strArr));
        System.out.println();

        System.out.println("2nd index, the element is: " + stringCollection_1.get(2));
        System.out.println();

        stringCollection_1.clear();
        System.out.println(stringCollection_1);
    }
}
