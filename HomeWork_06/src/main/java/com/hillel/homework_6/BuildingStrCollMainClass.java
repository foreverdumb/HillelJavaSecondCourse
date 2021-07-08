package com.hillel.homework_6;

import com.hillel.homework_6.services.StringCollectionServiceClass;

public class BuildingStrCollMainClass {
    public static void main(String[] args) {
        StringCollectionServiceClass stringCollectionClass = new StringCollectionServiceClass(5);
        stringCollectionClass.addElement("Vasya");
        stringCollectionClass.addElement("Kolya");
        stringCollectionClass.addElement("Tanya");
        stringCollectionClass.addElement("Daniil");
        stringCollectionClass.addElement("Petr");
        stringCollectionClass.setArrSize(15);
        stringCollectionClass.addElement("Vasya2");
        stringCollectionClass.addElement("Vasya3");
        stringCollectionClass.addElement("Vasya4");
        stringCollectionClass.addElement("Vasya5");
        stringCollectionClass.addElement("Vasya6");
        stringCollectionClass.addElement("Vasya7");
        stringCollectionClass.addElement("Vasya8");
        stringCollectionClass.addElement("Vasya9");
        stringCollectionClass.addElement("Vasya10");
        stringCollectionClass.addElement("Vasya11");
        System.out.println();
        System.out.println("Printing whole String collection: ");
        System.out.println(stringCollectionClass);
        stringCollectionClass.deleteElement(3);
        System.out.println();
        System.out.println("Deleting 3rd element of String collection: ");
        System.out.println(stringCollectionClass);
        System.out.println();
        System.out.println("Adding element Vasilisa to the String collection: ");
        stringCollectionClass.addElement("Vasilisa");
        System.out.println(stringCollectionClass);
        System.out.println();
        System.out.println("Getting 14th element from the String collection: ");
        System.out.println(stringCollectionClass.getElement(14));
        System.out.println();
        System.out.println("Getting Vasya element from the String collection: ");
        System.out.println(stringCollectionClass.getElement("Vasya"));
        System.out.println();
        System.out.println("Adding element Olha on the 1st pos in the String collection: ");
        stringCollectionClass.addElement(1, "Olha");
        System.out.println(stringCollectionClass);
        System.out.println();
        System.out.println("Deleting Vasya element from the String collection: ");
        stringCollectionClass.deleteElement(0, "Vasya");
        System.out.println(stringCollectionClass);
    }
}
