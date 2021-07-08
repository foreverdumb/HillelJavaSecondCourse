package com.hillel.homework_11;

import java.util.Arrays;

public class ArrStrListUtilsClass {

    private String[] stringCollection;
    private int size;
    private static final int DEFAULT_SIZE = 10;

    public ArrStrListUtilsClass() {
        this.stringCollection = new String[DEFAULT_SIZE];
    }

    public ArrStrListUtilsClass(int size) {
        if (size > 0) {
            this.stringCollection = new String[size];
        } else {
            throw new IllegalStateException("Size can not be less then 0! ");
        }
    }

    public String[] increaseSize() {
        String[] buff = new String[(stringCollection.length * 2)];
        System.arraycopy(stringCollection, 0, buff, 0, stringCollection.length);
        return buff;
    }

    public void isIndexOutOfRange(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Can not find the element "
                    + "Elements in array: = " + size
                    + ". Total size of array = " + stringCollection.length);
        }
    }

    public int indexOf(String element) {
        if (element == null) {
            for (int i = 0; i < stringCollection.length; i++)
                if (stringCollection[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (element.equals(stringCollection[i]))
                    return i;
        }
        return -1;
    }

    public boolean add(String element) {
        if (size == stringCollection.length) {
            stringCollection = increaseSize();
        }
        stringCollection[size] = element;
        size++;
        return true;
    }

    public boolean add(int index, String element) {
        isIndexOutOfRange(index);
        String buff = stringCollection[index];
        stringCollection[index] = element;
        return true;
    }

    public boolean delete(String element) {
        for (int i = 0; i < stringCollection.length; i++) {
            if (stringCollection[i].equals(element) && i != --size) {
                System.arraycopy(stringCollection, i + 1, stringCollection,
                        i, size - i);
                stringCollection[size] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    public boolean contains(String element) {
        return indexOf(element) >= 0;
    }

    public boolean equals(String[] strArr) {
        return Arrays.hashCode(stringCollection) == Arrays.hashCode(strArr);
    }

    public boolean clear() {
        for (int i = 0; i < stringCollection.length; i++) {
            stringCollection[i] = null;
            size = 0;
        }
        return true;
    }

    public int size() {
        return size;
    }

    public String get(int index) {
        isIndexOutOfRange(index);
        return stringCollection[index];
    }

    public String toString() {
        return "DescribingStringCollection{" +
                "stringCollection=" + Arrays.toString(stringCollection) +
                ", size=" + size +
                '}';
    }
}
