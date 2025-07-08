package com.example.questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;

public class FindNthSmallestInteger {
    public static void main(String[] args) {
        int[] arr = {3,1,5,4,8,9,10};
        int n = 3; // need 3rd smallest number

        Arrays.stream(arr)
                .sorted()
                .skip(n-1)
                .findFirst()
                .ifPresent(System.out::println);

        // If you need nth largest just change the sorting logic
        // boxed is converting int to Integer
        Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(n-1)
                .findFirst()
                .ifPresent(i->System.out.println(i));

    }
}
