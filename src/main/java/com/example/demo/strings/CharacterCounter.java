package com.example.demo.strings;

import java.util.HashMap;
import java.util.Map;

public class CharacterCounter {

    //Count the Occurrences of Each Character in a String
    public Map<Character, Integer> countCharacters(String str) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        return charCount;
    }

    public static void main(String[] args) {
        CharacterCounter counter = new CharacterCounter();
        String testString = "hello world";
        Map<Character, Integer> result = counter.countCharacters(testString);
        System.out.println("Character counts: " + result);
    }
}