package com.hillel.homework_9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class RemovingDuplicatesClass {
    public static void main(String[] args) {
        ArrayList<Object> col_1 = new ArrayList<>();
        col_1.add(2);
        col_1.add(2);
        col_1.add(2);
        col_1.add(2);
        col_1.add(5);
        col_1.add(6);

        System.out.println(removeDuplicates(col_1));

        ArrayList<Object> col_2 = new ArrayList<>();

        col_2.add("Sarah");
        col_2.add("Sarah");
        col_2.add("Sarah");
        col_2.add("Sarah");
        col_2.add("Mike");

        System.out.println(removeDuplicates(col_2));
    }


    public static Collection<Object> removeDuplicates(Collection<Object> col) {

        if (col.isEmpty()) {
            System.out.println("Collection is empty!");
        }
        return col.stream().distinct().collect(Collectors.toList());
    }
}
