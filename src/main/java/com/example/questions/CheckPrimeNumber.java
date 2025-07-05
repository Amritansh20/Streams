package com.example.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckPrimeNumber {

    public static boolean isPrime(int num){
        if(num<=1)
            return false;

        if(num==2)
            return true;

        for(int i=2;i<=num;i++){
            if(num % i==0)
                return false;

        }
        return true;
    }
    public static void main(String[] args) {
        // check if the list contains a prime number using java streams

        List<Integer> list = Arrays.asList(1,2,3,5,6,7,8,9);
        boolean isPrimeThere = list.stream().anyMatch(num->isPrime(num));
        System.out.println(isPrimeThere);
    }



}
