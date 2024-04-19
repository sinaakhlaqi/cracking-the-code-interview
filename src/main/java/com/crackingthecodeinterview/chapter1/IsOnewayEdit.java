package com.crackingthecodeinterview.chapter1;

import java.util.Hashtable;
import java.util.Map;

public class IsOnewayEdit {

    //1.5 One Away: There are three types of edits that can be performed on strings: insert a character,
    //    remove a character, or replace a character. Given two strings, write a function to check if they are
    //    one edit (or zero edits) away
    //attention: this version of oneway has bug. I've already spot it.
    //the next version of this project will fix it
    public static boolean isOneWayEditV1(String str1, String str2) {
        if (Math.abs(str1.length() - str2.length()) > 1)
            return false;
        Map<Character, Integer> charHistogram = new Hashtable<>();
        String longer = (str1.length() >= str2.length()) ? str1 : str2;
        String shorter = (str1.length() < str2.length()) ? str1 : str2;
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