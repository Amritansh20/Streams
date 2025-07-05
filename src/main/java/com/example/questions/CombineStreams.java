package com.example.questions;

import com.example.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class CombineStreams {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(4,5,6);

        Stream<Integer> combinedStream = Stream.concat(list1.stream(), list2.stream());
        combinedStream.forEach(System.out :: println);
    }

}
