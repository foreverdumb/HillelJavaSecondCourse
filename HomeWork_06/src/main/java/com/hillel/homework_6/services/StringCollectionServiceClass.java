package com.hillel.homework_6.services;

import java.util.Arrays;

public class StringCollectionServiceClass {
    private int arrSize = 10;
    private int pointer = 0;
    private String[] arr;
    private static final int REDUCE = 4;

    public StringCollectionServiceClass(int arrSize) {
        this.arr = new String[arrSize];
    }

    public void setArrSize(int arrSize) {
        this.arrSize = arrSize;
    }

    public int getArrSize() {
        return arrSize;
    }

    @Override
    public String toString() {
        return "StringCollectionClass {" +
                " \n===========================================================" +
                " \narr= " + Arrays.toString(arr) +
                " \n===========================================================" +
                '}';
    }

    public void changeArrSize(int newLength) {

        String[] secondArr = new String[newLength];
        System.arraycopy(arr, 0, secondArr, 0, pointer);
        arr = secondArr;
    }

    public void addElement(String element) {
        if (pointer == arr.length - 1) {
            changeArrSize(arr.length * 2);
        }
        arr[pointer++] = element;
    }

    public void addElement(int index, String element) {
        checkIndexRange(index);
        if (pointer == arr.length - 1) {
            changeArrSize(arr.length * 2);
        }
        if (index != arrSize) {
            System.arraycopy(arr, index, arr, index + 1, arrSize - index);
        }
        arr[index] = element;
    }

    public String getElement(int index) {
        checkIndexRange(index);
        return arr[index];
    }

    public String getElement(String element) {
        for (String s :
                arr) {
            if (element.equals(s)) {
                return s;
            }
        }
        return "Unknown";
    }

    public void deleteElement(int index) {
        checkIndexRange(index);
        if (pointer - index >= 0) System.arraycopy(arr, index + 1, arr, index, pointer - index);
        arr[pointer] = null;
        pointer--;
        if (arr.length > getArrSize() && pointer < arr.length / REDUCE)
            changeArrSize(arr.length / 2);
    }

    public void deleteElement(int index, String element) {
        for (int i = 0; i < arr.length; i++) {
            checkIndexRange(index);
            if (arr[i].equals(element) && index != --arrSize) {
                System.arraycopy(arr, index + 1, arr, index, pointer - index);
                arr[pointer] = null;
                arrSize--;
                return;
            } else if (!arr[i].equals(element)) {
                System.out.println("Wrong element");
            }
        }
    }

    public void checkIndexRange(int index) {
        if (index > getArrSize()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: "
                    + getArrSize());
        }
    }
}
