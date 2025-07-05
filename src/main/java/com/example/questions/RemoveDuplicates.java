package com.example.questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String[] args) {
        // Remove duplicates from list and preserve the order

        List<String> list = Arrays.asList("apple","banana","oranges","apple","banana");
        List<String> ans =list.stream().distinct().collect(Collectors.toList());
        ans.stream().forEach((String str)->{
            System.out.println(str);
        });
    }
}
