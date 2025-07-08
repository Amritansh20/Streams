package com.example.questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortDecimalsInReverse {
    public static void main(String[] args) {
        List<Double> list = Arrays.asList(2.32, 4.56, 2.31, 7.98, 10.88, 1.99);

        // ascending
//        list.stream().sorted().forEach(i-> System.out.println(i));

        // descending

        list.stream().sorted(Comparator.reverseOrder()).forEach(i->System.out.println(i));
    }
}
