package com.crackingthecodeinterview;

import java.util.Hashtable;
import java.util.Map;
import java.util.function.Supplier;

public class CheckPermutation {
    /**
     * Given two strings, this method determines if one is a permutation
     * of the other string.
     * <em>
     * this api try's to solve problem 2
     * <p>
     * Problem check permutation: Given two strings, write a method to decide if one is a permutation of the
     *
     * @param stringA first string input
     * @param stringB second string input
     * @return true if two strings are permutation of each other; otherwise false.
     * @throws NullPointerException if one of the input strings are null;
     */
    public static boolean checkPermutation(String stringA, String stringB) {
        Map<Character, Integer> charHistogram = new Hashtable<>();
        stringA.chars().forEach((ch) -> {
            char key = (char) ch;
            charHistogram.merge(key, 1, Integer::sum);
        });

        for (char ch : stringB.toCharArray()) {
            if (!charHistogram.containsKey(ch))
                return false;
            int chCount = charHistogram.get(ch) - 1;
            if (chCount == 0)
                charHistogram.remove(ch);
            else
                charHistogram.merge(ch, -1, Integer::sum);
        }
        return charHistogram.isEmpty();
    }
}