package com.example.questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrintAllPrime {
    public static boolean isPrime(int num){
        if(num<=1)
            return false;

        // checking prime my stream
        return IntStream.rangeClosed(2, (int) Math.sqrt(num)).noneMatch(i->num%i==0);
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> ans = list.stream().filter(num->isPrime(num)).collect(Collectors.toList());
        ans.forEach(i->{System.out.println(i);});

    }
}
