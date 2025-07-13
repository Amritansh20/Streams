package com.example.questions;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SumUniqueNumbers {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,20,30,30,10,20,40);
        int ans=list.stream()
                .distinct()
                .mapToInt(i->i.intValue())
                .sum();

        System.out.println(ans);
    }
}
