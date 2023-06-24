package com.prakritidev.verma.dynamicprogramming.subsequence;

import java.util.*;

public class WordBreak {

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
        
        // Base case: If the word is empty, it is considered a valid word break
        if (word.isEmpty()) {
            System.out.println("Word break found: " + word);
            return true;
        }

        int size = word.length();

        // Check for all possible prefix lengths
        for (int i = 1; i <= size; i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            System.out.println("Checking prefix: " + prefix);

            // If the current prefix is in the dictionary, make a recursive call
            // with the remaining suffix of the word
            if (dictionary.contains(prefix)) {
                System.out.println("Found prefix in dictionary: " + prefix);
                boolean suffixResult = wordBreak(suffix, dictionary);
                if (suffixResult) {
                    System.out.println("Word break found: " + word);
                    return true;
                }
            }
        }

        System.out.println("No word break found: " + word);
        return false;
    }
}
