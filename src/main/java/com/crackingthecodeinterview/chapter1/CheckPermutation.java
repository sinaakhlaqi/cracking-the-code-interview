package com.crackingthecodeinterview.chapter1;

import java.util.Hashtable;
import java.util.Map;

public class CheckPermutation {
    // 2. Check Permutation: Given two strings, write a method to decide if one is a permutation of the
    public static boolean checkPermutation(String str1, String str2) {
        if (str1 == null || str2 == null)
            return false;
        Map<Character, Integer> stringCharTable = new Hashtable<>();
        int[] sum = {0};
        boolean[] flag = {true};
        str1.chars().forEach((ch) -> {
            char key = (char) ch;
            stringCharTable.merge(key, 1, Integer::sum);
            sum[0]++;
        });
        str2.chars().forEach((ch) -> {
            char key = (char) ch;
            if (stringCharTable.get(key) == null || (stringCharTable.get(key) - 1 < 0)) {
                flag[0] = false;
            } else {
                stringCharTable.put(key, stringCharTable.get(key) - 1);
                sum[0]--;
            }
        });
        return flag[0] && sum[0] == 0;
    }
}