package com.example.demo.strings;

import java.util.Arrays;

public class AnagramChecker {

    /**
     * Checks if two strings are anagrams of each other.
     *
     * @param s1 the first string
     * @param s2 the second string
     * @return true if the strings are anagrams, false otherwise
     */
    public boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);
        return Arrays.equals(s1Array, s2Array);
    }

    public static void main(String[] args) {
        AnagramChecker checker = new AnagramChecker();

        String s1 = "listen";
        String s2 = "silent";
        boolean result = checker.areAnagrams(s1, s2);
        System.out.println(s1 + " and " + s2 + " are anagrams: " + result);

        s1 = "hello";
        s2 = "world";
        result = checker.areAnagrams(s1, s2);
        System.out.println(s1 + " and " + s2 + " are anagrams: " + result);
    }
}