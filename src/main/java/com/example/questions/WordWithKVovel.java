package com.example.questions;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordWithKVovel {
    public static void main(String[] args) {
        String sentence = "I have an apple and orange on the table";
        int k=2;

        List<String> ans= Arrays.stream(sentence.split(" "))
        .filter( word -> countVovels(word)==k).collect(Collectors.toList());

        ans.forEach(word->System.out.println(word));
    }

    public static long countVovels(String word){
       return word.chars()
                .mapToObj(ch -> (char) ch)
                .filter(ch-> "aeiouAEIOU".indexOf(ch)!=-1)
                .count();
    }

}
