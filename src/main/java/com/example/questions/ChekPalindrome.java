package com.example.questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ChekPalindrome {
    public static boolean isPalindrome(String str){
        int i=0;
        int j=str.length()-1;

        while (i <= j) {
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public static boolean palindromeByStream(String str){
        return IntStream.range(0,str.length()-1).allMatch(i->str.charAt(i)==str.charAt(str.length()-1-i));
    }
    public static void main(String[] args) {
        List<String> list = Arrays.asList("nitin","aba","Amritansh","Nishant","Simran");
        List<String> ans=list.stream().filter((String str)->palindromeByStream(str)).collect(Collectors.toList());
        ans.forEach(str->System.out.println(str));
    }
}
