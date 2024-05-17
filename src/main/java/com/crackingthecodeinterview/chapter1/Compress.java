package com.crackingthecodeinterview.chapter1;


import java.util.ArrayList;
import java.util.List;

public class Compress {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
    }

    /**
     * Returns a compact representation of input string with respect to character frequency
     * in the input string.
     * <em>
     * this api try's to solve problem 6
     * <p>
     * Problem String Compression: Implement a method to perform basic string compression using the counts
     * of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
     * "compressed" string would not become smaller than the original string, your method should return
     * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
     *
     * @param inputString the input string
     * @return the compressed string
     * @throws NullPointerException if the inputString is null
     * @example compress(aabcccccaaa) returns a2blc5a3;
     */
    public static String compress(String inputString) {
        StringBuilder compressed = new StringBuilder();
        int charCount;
        int i = 0;
        while (i < inputString.length()) {
            charCount = countRepeatedChar(inputString,
                    inputString.charAt(i),
                    i);
            compressed.append(inputString.charAt(i));
            if (charCount > 1) {
                compressed.append(charCount);
            }
            i = (charCount == 0) ? i + 1 : i + charCount;
        }
        return compressed.length() < inputString.length() ? compressed.toString() : inputString;
    }


    // helpers
    public static int countRepeatedChar(String inputString, char repeatedChar, int startIndex) {
        int countOfChar = 0;
        int charIndex = startIndex;
        while (charIndex < inputString.length()
                && (inputString.charAt(charIndex) == repeatedChar)) {
            countOfChar++;
            charIndex++;
        }
        return countOfChar;
    }

}