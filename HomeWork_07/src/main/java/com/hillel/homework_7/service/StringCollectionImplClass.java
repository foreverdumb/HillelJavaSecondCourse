package com.hillel.homework_7.service;

import java.util.Arrays;
import java.util.Iterator;

public class StringCollectionImplClass implements StringCollectionServiceClass, Iterable<Object> {
    private String[] stringCollection;
    private int size;
    private static final int DEFAULT_SIZE = 10;

    public StringCollectionImplClass() {
        this.stringCollection = new String[DEFAULT_SIZE];
    }

    public StringCollectionImplClass(int size) {
        if (size <= 0) {
            this.stringCollection = new String[size];
        } else {
            throw new IllegalStateException("Size can not be less then 0! ");
        }
    }

    String[] increaseSize() {
        String[] buff = new String[(stringCollection.length * 2)];
        System.arraycopy(stringCollection, 0, buff, 0, stringCollection.length);
        return buff;
    }

    void isIndexOutOfRange(int index) {
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

    @Override
    public boolean add(String element) {
        if (size == stringCollection.length) {
            stringCollection = increaseSize();
        }
        stringCollection[size] = element;
        size++;
        return true;
    }

    @Override
    public boolean add(int index, String element) {
        isIndexOutOfRange(index);
        String buff = stringCollection[index];
        stringCollection[index] = element;
        return true;
    }

    @Override
    public boolean delete(String element) {
        for (int i = 0; i < stringCollection.length; i++) {
            if (stringCollection[i].equals(element) && i != --size) {
                System.arraycopy(stringCollection, i + 1, stringCollection,
                        i, size - i);
                stringCollection[size] = null;
                /*size--;*/
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(String element) {
        return indexOf(element) >= 0;
    }

    @Override
    public boolean equals(String[] strArr) {
        return Arrays.hashCode(stringCollection) == Arrays.hashCode(strArr);
    }

    @Override
    public boolean clear() {
        for (int i = 0; i < stringCollection.length; i++) {
            stringCollection[i] = null;
            size = 0;
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String get(int index) {
        isIndexOutOfRange(index);
        return stringCollection[index];
    }

    @Override
    public String toString() {
        return "DescribingStringCollection{" +
                "stringCollection=" + Arrays.toString(stringCollection) +
                ", size=" + size +
                '}';
    }

// ITERATOR

    @Override
    public Iterator<Object> iterator() {
        return new iIterator();
    }

    private class iIterator implements Iterator<Object> {

        int index = 0;

        @Override
        public boolean hasNext() {
            return index < stringCollection.length && stringCollection[index] != null;
        }

        @Override
        public Object next() {
            return stringCollection[index++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
