package com.example.questions;

import java.util.Arrays;
import java.util.Comparator;

public class LastElementOfArray {
    public static void main(String[] args) {
        int[] arr = {3,1,5,4,8,9,10};

        Arrays.stream(arr)
                .sorted()
                .skip(arr.length-1)
                .findFirst()
                .ifPresent(i->System.out.println(i));

        Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(0)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
