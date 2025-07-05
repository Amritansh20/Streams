package com.example.questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,5,9);
        List<Integer> list2 = Arrays.asList(2,3,10);

        Stream<Integer> mergedStream = Stream.concat(list1.stream(),list2.stream());
        List<Integer> ans = mergedStream.sorted().collect(Collectors.toList());
        ans.stream().forEach(i->{System.out.println(i);});
//        mergedStream.sorted().forEach(i-> {System.out.println(i);});
    }
}
