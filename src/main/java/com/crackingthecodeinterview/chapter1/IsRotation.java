package com.crackingthecodeinterview.chapter1;

public class IsRotation {
    //1.9 V1: String Rotation: Assume you have a method isSubString which checks if one word is a substring
    //    of another. Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using only one
    //    call to isSubString (e.g., "waterbottle" is a rotation of" erbottlewat").
    public static boolean isRotationV1(String str1, String str2) {
        if (str1 == null || str2 == null)
            return false;
        boolean isRotation = false;
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] str1Char = str1.chars().toArray();
        int[] str2Char = str2.chars().toArray();
        int index1 = 0;
        int index2 = 0;
        int reset = index2;
        while (reset < str2.length()) {
            if (str1Char[index1] == str2Char[index2]) {
                index1++;
                if (index1 == str1.length()) {
                    isRotation = true;
                    break;
                }
                index2++;
                if (index2 >= str2Char.length) {
                    index2 = index2 % str2Char.length;
                }
            } else {
                index1 = 0;
                reset++;
                index2 = reset;
            }
        }
        return isRotation;
    }

    //1.9 V2:
    public static boolean isRotationV2(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        String doubleStr1 = str1 + str1;
        return doubleStr1.contains(str2);
    }
}