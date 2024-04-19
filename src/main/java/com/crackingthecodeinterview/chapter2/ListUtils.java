package com.crackingthecodeinterview.chapter2;

import java.util.Iterator;

public class ListUtils {

    //2.5 Sum Lists: You have two numbers represented by a linked list, where each node contains a single
    //    digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
    //    function that adds the two numbers and returns the sum as a linked list.
    public static SimpleSinglyLinkedList<SimpleData> addAsDigit(SimpleSinglyLinkedList<SimpleData> numList1
            , SimpleSinglyLinkedList<SimpleData> numList2) {
        SimpleSinglyLinkedList<SimpleData> sumList = new SimpleSinglyLinkedList<>();
        Iterator<SimpleLinkedList<SimpleData>> shorterList;
        Iterator<SimpleLinkedList<SimpleData>> longerList;
        if (numList1 != null && numList2 != null) {
            if (numList1.getLength() < numList2.getLength()) {
                shorterList = numList1;
                longerList = numList2;
            } else {
                shorterList = numList2;
                longerList = numList1;
            }
            int auxiliary = 0;
            int sum;
            int digit;
            while (shorterList.hasNext()) {
                sum = shorterList.next().getData().val() + longerList.next().getData().val() + auxiliary;
                digit = sum % 10;
                auxiliary = sum / 10;
                sumList.appendToTail(new SimpleData(digit, ""));
            }
            while (longerList.hasNext()) {
                sum = longerList.next().getData().val() + auxiliary;
                if (sum / 10 == 0) {
                    sumList.appendToTail(new SimpleData(sum, ""));
                    auxiliary = 0;
                } else {
                    digit = sum % 10;
                    auxiliary = sum / 10;
                    sumList.appendToTail(new SimpleData(digit, ""));
                }
            }
            if (auxiliary > 0)
                sumList.appendToTail(new SimpleData(auxiliary, ""));
        }
        return sumList;
    }

    //2.6 Palindrome: Implement a function to check if a linked list is a palindrome.
    public static boolean isPalindrome(SimpleSinglyLinkedList<SimpleData> list) {
        if (list.getLength() == 0) {
            return false;
        }
        int midOfList = list.getLength() / 2;
        SimpleLinkedList<SimpleData> head = list.getList();
        SimpleLinkedList<SimpleData> halfRight = list.getList();
        boolean isPalindrome = true;
        for (int i = 0; i <= midOfList; i++) {
            halfRight = halfRight.getNext();
        }
        while (isPalindrome && halfRight != null) {
            if (!(head.getData().val() == halfRight.getData().val())) {
                isPalindrome = false;
                break;
            }
            head = head.getNext();
            halfRight = halfRight.getNext();
        }
        return isPalindrome;
    }

    //2.8 Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
    //    beginning of the loop.
    public static SimpleLinkedList<SimpleData> findLoop(SimpleLinkedList<SimpleData> list) {

        boolean hasLoop = false;
        SimpleLinkedList<SimpleData> slowRunner = list;
        SimpleLinkedList<SimpleData> fastRunner = list;
        SimpleLinkedList<SimpleData> inLoopCursor = null;
        SimpleLinkedList<SimpleData> headListCursor = list;

        while (fastRunner.getNext().getNext() != null) {
            slowRunner = slowRunner.getNext();
            fastRunner = fastRunner.getNext().getNext();
            if (slowRunner == fastRunner) {
                inLoopCursor = slowRunner;
                hasLoop = true;
                break;
            }
        }
        if (hasLoop) {
            while (headListCursor != inLoopCursor) {
                inLoopCursor = inLoopCursor.getNext();
                headListCursor = headListCursor.getNext();
            }
            return headListCursor;
        } else {
            return null;
        }
    }
}
