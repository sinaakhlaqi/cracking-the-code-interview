package com.crackingthecodeinterview.chapter1;

import static com.crackingthecodeinterview.utilities.Constants.NUM_OF_EN_CHARS;

public class IsPalindromePermutation {
    //1.4 Palindrome Permutation: Given a string, write a function to check if it is a permutation of
    //    a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
    //    permutation is a rearrangement of letters. The palindrome does not need to be limited to just
    //    dictionary words.
    public static boolean isPalindromePermutation(String str) {
        if (str == null) {
            return false;
        }
        int[] charHistogram = new int[NUM_OF_EN_CHARS];
        boolean hasOneOddChar = false;
        str.chars().forEach((ch) -> charHistogram[ch]++
        );
        for (int j : charHistogram) {
            if (j % 2 == 1) {
                if (hasOneOddChar) {
                    return false;
                }
                hasOneOddChar = true;
            }
        }
        return true;
    }
}