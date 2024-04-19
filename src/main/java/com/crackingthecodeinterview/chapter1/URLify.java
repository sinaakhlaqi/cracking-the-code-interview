package com.crackingthecodeinterview.chapter1;

import com.crackingthecodeinterview.exceptions.MalformedCharArrayException;

public class URLify {
    // 3. URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
    //    has sufficient space at the end to hold the additional characters, and that you are given the "true"
    //    length of the string. (Note: if implementing in Java, please use a character array so that you can
    //    perform this operation in place.)
    public static void urlify(char[] url) throws NullPointerException, MalformedCharArrayException {

        if (url == null)
            throw new NullPointerException("Null url reference!!!");

        int headCursor = url.length - 1;
        int tailCursor = headCursor;
        boolean flag = true;
        int leftmostSpacesCount = 0;
        int innerUrlSpacesCount = 0;

        while (tailCursor > 0 && headCursor > -1) {
            if (url[headCursor] == ' ' && flag) {
                headCursor--;
                leftmostSpacesCount++;
            } else {
                flag = false;
            }
            if (url[headCursor] != ' ' && !flag) {
                url[tailCursor] = url[headCursor];
                tailCursor--;
                headCursor--;
            } else if (url[headCursor] == ' ' && !flag) {
                url[tailCursor--] = '0';
                url[tailCursor--] = '2';
                url[tailCursor--] = '%';
                headCursor--;
                innerUrlSpacesCount++;
            }
        }
        if ((innerUrlSpacesCount * 2) != leftmostSpacesCount) {
            throw new MalformedCharArrayException(url, (innerUrlSpacesCount * 3),
                    (innerUrlSpacesCount + leftmostSpacesCount));
        }
    }
}