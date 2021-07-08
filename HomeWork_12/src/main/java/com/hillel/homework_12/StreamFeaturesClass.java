package com.hillel.homework_12;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFeaturesClass {
    public static void main(String[] args) {
        //Integer List Task  #1
        ArrayList<Integer> integer_list_param = new ArrayList<>();
        ArrayList<Integer> integer_list_save_param;

        //String List Task #2
        List<Pair> string_list_param = Stream.of("one", "two", "three", "four")
                .map(c -> new Pair(c, c.toUpperCase()))
                .collect(Collectors.toList());

        //String List Task #3
        ArrayList<String> string_2_list_param = new ArrayList<>();

        string_2_list_param.add("masha");
        string_2_list_param.add("masha");
        string_2_list_param.add("MARIA");
        string_2_list_param.add("stas");
        string_2_list_param.add("miha");
        string_2_list_param.add("Stas");
        string_2_list_param.add("STAS");

        //Task #1 methods call
        System.out.println(integer_list_save_param = setIntList(5, integer_list_param));

        System.out.println(calcAverage(integer_list_save_param));

        System.out.println("------------------------------------------");

        //Task #2 methods call
        System.out.println(string_list_param);

        System.out.println("------------------------------------------");

        //Task #3 methods call
        filterByOwnRules(string_2_list_param);
    }

    public static ArrayList<Integer> setIntList(int size, ArrayList<Integer> integer_list) {

        for (int i = 0; i < size; i++) {

            integer_list.add(ThreadLocalRandom.current().nextInt(0, 100));
        }
        return integer_list;
    }

    public static double calcAverage(ArrayList<Integer> integer_list_save_param) {

        return integer_list_save_param
                .stream()
                .mapToInt(d -> d)
                .average()
                .orElse(0.0D);
    }

    public static void filterByOwnRules(ArrayList<String> string_2_list_param) {

        string_2_list_param
                .stream()
                .filter(c -> c.length() == 4)
                .filter(c -> c.equals(c.toLowerCase()))
                .forEach(System.out::println);
    }
}

@AllArgsConstructor
@ToString
class Pair {
    Object element_1;
    Object element_2;
}
