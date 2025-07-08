package com.example.questions;

import java.util.Arrays;
import java.util.List;

public class SumOfFirstTwoNum {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(100,200,300,400,500);

        int ans=list.stream()
                .limit(2)
                .mapToInt(i->i.intValue())
                .sum();

        System.out.println(ans);
    }

}
