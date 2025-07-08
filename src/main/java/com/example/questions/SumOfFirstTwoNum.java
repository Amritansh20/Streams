package com.example.questions;

import java.awt.desktop.SystemEventListener;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class SumOfFirstTwoNum {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(100,200,300,400,500);

        int ans=list.stream()
                .limit(2)
                .mapToInt(i->i.intValue())
                .sum();

        System.out.println(ans);

        // If the requirement it to multiply
        // reduce converts whole stream into one result
        Optional<Integer> product =list.stream()
                .limit(2)
                .reduce((a,b)->a*b);

        product.ifPresent(System.out::println);
    }

}
