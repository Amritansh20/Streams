package com.example.questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindStringStartsWithNum {
    public static void main(String[] args) {
        // Given a list of string. fins out strings that start with number

        List<String> list = Arrays.asList("01Banana", "Banana","apple", "9India");
        List<String> ans =list.stream().filter((String str)->Character.isDigit(str.charAt(0))).collect(Collectors.toList());
        ans.forEach(str->System.out.println(str));
    }
}
