package com.prakritidev.verma.dynamicprogramming.subsequence;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        System.out.println("Checking string: " + s);
        return longestPalindromeHelper(s, 0, s.length() - 1);
    }

    public static String longestPalindromeHelper(String s, int start, int end) {
        // Base case: when start and end indices meet or cross each other,
        // return the substring between them as the longest palindromic substring
        if (start >= end) {
            String substring = s.substring(start, end + 1);
            System.out.println("Palindrome found: " + substring);
            return substring;
        }

        // Recursive cases:
        // Case 1: If the start and end characters are the same,
        // check if the remaining substring is also a palindrome
        if (s.charAt(start) == s.charAt(end)) {
            String remaining = longestPalindromeHelper(s, start + 1, end - 1);
            if (remaining.length() == end - start - 1) {
                String palindrome = s.substring(start, end + 1);
                System.out.println("Palindrome found: " + palindrome);
                return palindrome;
            }
        }

        // Case 2: Check the longest palindromic substring by excluding the start character
        String substring1 = longestPalindromeHelper(s, start + 1, end);

        // Case 3: Check the longest palindromic substring by excluding the end character
        String substring2 = longestPalindromeHelper(s, start, end - 1);

        // Return the longest palindromic substring among the three cases
        if (substring1.length() >= substring2.length()) {
            System.out.println("Longest palindrome: " + substring1);
            return substring1;
        } else {
            System.out.println("Longest palindrome: " + substring2);
            return substring2;
        }
    }
}

