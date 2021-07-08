package com.hillel.homework_7.service;

public interface StringCollectionServiceClass {
    boolean add(String element);

    boolean add(int index, String element);

    boolean delete(String element);

    boolean contains(String element);

    boolean equals(String[] strArr);

    boolean clear();

    int size();

    String get(int index);
}
