package com.crackingthecodeinterview.chapter1;

public class Compress {
    //1.6 String Compression: Implement a method to perform basic string compression using the counts
    //    of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
    //    "compressed" string would not become smaller than the original string, your method should return
    //    the original string. You can assume the string has only uppercase and lowercase letters (a - z).
    public static String compress(String str) {
        if (str == null)
            return null;
        StringBuilder compressed = new StringBuilder();
        int charCount = 1;
        int i = 0;
        while (i < str.length()) {
            int j = i + 1;
            while (j < str.length()) {
                if (str.charAt(j) == str.charAt(i)) {
                    charCount++;
                    j++;
                } else {
                    break;
                }
            }
            compressed.append(str.charAt(i));
            if (charCount > 1) {
                compressed.append(charCount);
            }
            i = j;
            charCount = 1;
        }
        return compressed.length() < str.length() ? compressed.toString() : str;
    }
}