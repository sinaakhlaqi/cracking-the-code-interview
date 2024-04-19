package com.crackingthecodeinterview.chapter1;

import java.util.Collections;

import static com.crackingthecodeinterview.utilities.Constants.NUM_OF_EN_CHARS;

public class IsUnique {
    // 1. Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
    //    cannot use additional data structures?
    public static boolean isUnique(String str) {
        if (str == null)
            return false;

        Integer[] charHistogram = Collections.nCopies(125, 0).toArray(new Integer[NUM_OF_EN_CHARS]);
        boolean[] isUnique = {true};

        str.chars().forEach((ch) -> {
            if (charHistogram[ch] > 0) {
                isUnique[0] = false;
            } else {
                charHistogram[ch]++;
            }
        });
        return isUnique[0];
    }
}