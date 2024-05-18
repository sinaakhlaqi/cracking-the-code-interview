package com.crackingthecodeinterview.chapter1;

import java.util.Hashtable;
import java.util.Map;

public class IsOnewayEdit {
    /**
     * Determines if two strings are oneway edit of each other or not.
     * <em>
     * this api try's ti solve problem 5
     * <p>
     * Problem Oneway: There are three types of edits that can be performed on strings: insert a character,
     * remove a character, or replace a character. Given two strings, write a function to check if they are
     * one edit (or zero edits) away
     * attention: this version of oneway has bug. I've already spot it.
     * the next version of this project will fix it
     * @param stringA first input string
     * @param stringB second input string
     * @return true if two inputs are oneway derived of each other. Otherwise, return false.
     */
    public static boolean isOneWayEditV1(String stringA, String stringB) {
        if (Math.abs(stringA.length() - stringB.length()) > 1)
            return false;
        Map<Character, Integer> charHistogram = new Hashtable<>();
        String longer = (stringA.length() >= stringB.length()) ? stringA : stringB;
        String shorter = (stringA.length() < stringB.length()) ? stringA : stringB;
        shorter.chars().forEach((ch) -> {
            Character key = (char) ch;
            charHistogram.merge(key, 1, Integer::sum);
        });
        int[] difference = {0};
        longer.chars().forEach((ch) -> {
            Character key = (char) ch;
            Integer value = charHistogram.get(key);
            if (value == null || value == 0) {
                difference[0]++;
            } else {
                charHistogram.put(key, value - 1);
            }
        });
        return difference[0] == 0 || difference[0] == 1;
    }
}