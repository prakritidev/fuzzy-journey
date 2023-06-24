package com.prakritidev.verma.dynamicprogramming.subsequence;

import java.util.*;

public class WordBreakDP {

    public static void main(String[] args) {
        // Array of strings to be added in the dictionary
       String[] temp_dictionary = {"cats","dog","sand","and","cat"};

        // Create a dictionary set and add words
        Set<String> dictionary = new HashSet<>(Arrays.asList(temp_dictionary));

        // Sample input cases
        System.out.println(wordBreak("catsandog", dictionary));
    }

    public static boolean wordBreak(String word, Set<String> dictionary) {
        System.out.println("Checking word: " + word);

        int size = word.length();

        // Create a DP table to store subproblem results
        boolean[] dp = new boolean[size + 1];
        dp[0] = true; // Base case: empty string is considered a valid word break

        // Check for all possible substrings of the word
        for (int i = 1; i <= size; i++) {
            System.out.println("Checking substring: " + word.substring(0, i));

            // Check if the current substring is in the dictionary
            if (dictionary.contains(word.substring(0, i))) {
                dp[i] = true;
                System.out.println("Substring found in dictionary!");

                // Continue checking the remaining substring
                for (int j = i + 1; j <= size; j++) {
                    System.out.println("Checking remaining substring: " + word.substring(i, j));

                    // If the remaining substring is also in the dictionary and the previous substring is a valid word break,
                    // mark the current substring as a valid word break
                    if (dictionary.contains(word.substring(i, j)) && dp[i]) {
                        dp[j] = true;
                        System.out.println("Word break found: " + word.substring(0, j));
                    }
                }
            }
        }

        // The last value in the DP table indicates whether a valid word break is possible for the entire word
        boolean result = dp[size];

        System.out.println("No word break found: " + word);

        return result;
    }
}

