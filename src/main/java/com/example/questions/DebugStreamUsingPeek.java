package com.example.questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DebugStreamUsingPeek {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple","banana","cat", "dog","world");

        List<String> ans = list.stream()
                .peek(word->{System.out.println("Original: "+ word);})
                .map((String str)-> str.toUpperCase())
                .peek(word->{System.out.println("After operation: "+ word);})
                .collect(Collectors.toList());

//        ans.stream().forEach(str->{System.out.println(str);});
    }
}
