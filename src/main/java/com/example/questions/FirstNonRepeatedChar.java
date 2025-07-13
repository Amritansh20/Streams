package com.example.questions;


import java.util.LinkedHashMap;
import java.util.stream.Collectors;

// find the first non-repeating char in given string.

public class FirstNonRepeatedChar {
    public static void main(String[] args) {
        String input = "swiss";
        input.chars()
                .mapToObj(ch->(char) ch)
                .collect(Collectors.groupingBy(ch->ch, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry->entry.getValue()==1)
                .map(entry->entry.getKey())
                .findFirst().ifPresent(System.out :: println);

    }


}
