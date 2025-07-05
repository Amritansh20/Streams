package com.example.questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AllNumsStartingWithOne {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(101,12,21,34,1,41,123);
        List<Integer> ans= list.stream().filter(num->String.valueOf(num).startsWith("1")).collect(Collectors.toList());
        ans.stream().forEach(num->{System.out.println(num);});

        // a little variation
        // print all the numbers not starting with one

        System.out.print("******************");
        System.out.println();

        List<Integer> notStartOne= list.stream().filter(num-> !String.valueOf(num).startsWith("1")).collect(Collectors.toList());
        notStartOne.stream().forEach(num->{System.out.println(num);});


    }
}
