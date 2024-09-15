package com.example.demo.strings;

public class PalindromeChecker {

    public boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker();
        String testString = "racecar";
        boolean result = checker.isPalindrome(testString);
        System.out.println("Is \"" + testString + "\" a palindrome? " + result);
    }
}