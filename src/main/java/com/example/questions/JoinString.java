package com.example.questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoinString {
    public static void main(String[] args) {
        // Given a list of Strings add '[' as prefix and ']' as  suffix and ',' seperated.
        List<String> list = Arrays.asList("apple", "banana", "cat");

//        list.stream().map(word->'['+word+']'+',').forEach(System.out::print);
        // output = [apple],[banana],[cat],
        // Last , is problem

        String result=list.stream()
                .map(word->'['+word+']')
                .collect(Collectors.joining(","));

        System.out.println(result);

        // If requirement is to make -> ["apple", "banana", "cat"]

        String ans=list.stream()
                .collect(Collectors.joining(",","[","]"));
        System.out.println(ans);


    }
}
