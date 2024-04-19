package com.crackingthecodeinterview.chapter2;


import static com.crackingthecodeinterview.utilities.Constants.*;

public class Chapter2ProblemsAndSolutions {

    public static void main(String[] args) {
        //initialize the linked list
        SimpleData s1 = new SimpleData(1, "one");
        SimpleData s2 = new SimpleData(2, "two");
        SimpleData s3 = new SimpleData(3, "three");
        SimpleData s4 = new SimpleData(4, "four");
        SimpleData s5 = new SimpleData(5, "five");
        SimpleData s6 = new SimpleData(6, "six");
        SimpleData s7 = new SimpleData(7, "seven");
        SimpleData s8 = new SimpleData(8, "eight");
        SimpleData s9 = new SimpleData(9, "nine");
        SimpleData s10 = new SimpleData(10, "ten");
        SimpleData s11 = new SimpleData(11, "eleven");
        SimpleData s12 = new SimpleData(12, "twelve");

        SimpleSinglyLinkedList<SimpleData> list2_1 = new SimpleSinglyLinkedList<>();
        SimpleSinglyLinkedList<SimpleData> list2_2 = new SimpleSinglyLinkedList<>();
        SimpleSinglyLinkedList<SimpleData> list2_3 = new SimpleSinglyLinkedList<>();
        SimpleSinglyLinkedList<SimpleData> list2_4 = new SimpleSinglyLinkedList<>();

        //list2_1 init
        list2_1.appendToTail(s2);
        list2_1.appendToTail(s3);
        list2_1.appendToTail(s2);
        list2_1.appendToTail(s1);
        list2_1.appendToTail(s1);
        list2_1.appendToTail(s3);
        list2_1.appendToTail(s3);
        list2_1.appendToTail(s1);
        list2_1.appendToTail(s2);
        list2_1.appendToTail(s2);
        list2_1.appendToTail(s2);
        list2_1.appendToTail(s4);
        list2_1.appendToTail(s2);
        list2_1.appendToTail(s5);
        list2_1.appendToTail(s6);
        list2_1.appendToTail(s6);
        list2_1.appendToTail(s6);

        //list2_2 init
        list2_2.appendToTail(s1);
        list2_2.appendToTail(s3);
        list2_2.appendToTail(s2);
        list2_2.appendToTail(s1);
        list2_2.appendToTail(s2);
        list2_2.appendToTail(s1);
        list2_2.appendToTail(s3);
        list2_2.appendToTail(s1);
        list2_2.appendToTail(s3);
        list2_1.appendToTail(s1);

        //list2_3 init
        list2_3.appendToTail(s1);
        list2_3.appendToTail(s2);
        list2_3.appendToTail(s3);
        list2_3.appendToTail(s4);
        list2_3.appendToTail(s5);
        list2_3.appendToTail(s6);

        //list2_4 init
        list2_4.appendToTail(s3);
        list2_4.appendToTail(s2);
        list2_4.appendToTail(s4);
        list2_4.appendToTail(s1);
        list2_4.appendToTail(s1);
        list2_4.appendToTail(s2);
        list2_4.appendToTail(s5);
        //end initializing


        //2.1 test
        System.out.printf(SEPARATOR, "test 2.1 remove duplicates");
        System.out.println(list2_1);
        list2_1.removeDuplicates();
        //list.removeDuplicatesNoBuff();
        System.out.println("after remove duplicates:\n");
        System.out.print(list2_1);
        System.out.printf(SEPARATOR, "end of test 2.1");
        System.out.println();

        //2.2 test

        System.out.printf(SEPARATOR, "test 2.2 kth to the last");
        int k = 3;
        System.out.println(list2_2);
        SimpleLinkedList<SimpleData> kthNode = list2_2.kthToTheLast(k);
//        SimpleNode<SimpleData> kthNode = list2_2.kthToTheLastWithLength(k);
        if (kthNode != null) {
            System.out.printf("the %d'th to last element of list is %s with data: \n%s\n", k, kthNode, kthNode.getData());
        } else {
            System.out.println("no such element");
        }
        System.out.printf(SEPARATOR, "end of test 2.2");
        System.out.println();

        //2.3 test

        System.out.printf(SEPARATOR, "test 2.3 remove mid of the list");
        System.out.println(list2_3);
        System.out.println("after remove the mid of the list:\n");
        list2_1.removeMid();
        System.out.println(list2_3);
        System.out.printf(SEPARATOR, "end of test 2.3");
        System.out.println();

        //2.4 test

        System.out.printf(SEPARATOR, "test 2.4 list partitioning");
        System.out.println(list2_4);
        System.out.printf("list partitioning with k=%d \n\n", k);
        list2_4.partition(3);
        System.out.println(list2_4);
        System.out.printf(SEPARATOR, "end of test 2.4");

        //2.5 test

        System.out.printf(SEPARATOR, "test 2.5 sum of two linked list as numbers");
        SimpleSinglyLinkedList<SimpleData> num1 = new SimpleSinglyLinkedList<>();
        SimpleSinglyLinkedList<SimpleData> num2 = new SimpleSinglyLinkedList<>();
        num1.appendToTail(s1);
        num2.appendToTail(s9);
        num2.appendToTail(s9);
        num2.appendToTail(s9);
        SimpleSinglyLinkedList<SimpleData> sum = ListUtils.addAsDigit(num1, num2);
        System.out.printf("sum of %s and %s is %s\n", num1.asNumberString(), num2.asNumberString(), sum.asNumberString());
        System.out.printf(SEPARATOR, "end of test 2.5");
        System.out.println();

        //2.6 test

        System.out.printf(SEPARATOR, "test 2.6 is Palindrome");
        SimpleSinglyLinkedList<SimpleData> testPalindrome = new SimpleSinglyLinkedList<>();
        testPalindrome.appendToTail(s1);
        testPalindrome.appendToTail(s2);
        testPalindrome.appendToTail(s2);
        testPalindrome.appendToTail(s1);
        System.out.printf("the number %s palindrome property is %b\n", testPalindrome.asNumberString(), ListUtils.isPalindrome(testPalindrome));
        System.out.printf(SEPARATOR, "end of test 2.6");
        System.out.println();

        //2.7 test
        System.out.printf(SEPARATOR, "test 2.7 Intersection of two lists");
        SimpleSinglyLinkedList<SimpleData> list2_7_1 = new SimpleSinglyLinkedList<>();
        SimpleSinglyLinkedList<SimpleData> list2_7_2 = new SimpleSinglyLinkedList<>();
        SimpleSinglyLinkedList<SimpleData> list2_7_3 = new SimpleSinglyLinkedList<>();

        //making first list with intersect of second list
        list2_7_3.appendToTail(s5);
        list2_7_3.appendToTail(s6);

        list2_7_1.appendToTail(s1);
        list2_7_1.appendToTail(s2);
        list2_7_1.appendToTail(list2_7_3);

        list2_7_2.appendToTail(list2_7_3);
        list2_7_2.appendToTail(s3);
        list2_7_2.appendToTail(s4);
        //end of inti first and second lists

        System.out.println("list A:\n" + list2_7_1);
        System.out.println("list B:\n" + list2_7_2);
        SimpleSinglyLinkedList<SimpleData> intersect = list2_7_1.intersect(list2_7_2);
        System.out.println("list Intersect:\n" + intersect);
        System.out.printf(SEPARATOR, "end of test 2.7");
        System.out.println();

        // 2.8 test (important) -> 'making a looped list manually since the problem has fundamental inconsistency with
        //     implementation of SimpleSinglyLinkedList'
        System.out.printf(SEPARATOR, "test 2.8 Loop Detection");
        SimpleLinkedList<SimpleData> loopList = new SimpleLinkedList<>();
        SimpleLinkedList<SimpleData> cursorLoopList;
        SimpleLinkedList<SimpleData> startLoopNode = new SimpleLinkedList<>(s4);

        //initializing the looped list and it's staffs
        loopList.setData(s1);
        loopList.setNext(new SimpleLinkedList<>(s2));

        cursorLoopList = loopList.getNext();
        cursorLoopList.setNext(new SimpleLinkedList<>(s3));

        cursorLoopList = cursorLoopList.getNext();
        cursorLoopList.setNext(startLoopNode);

        cursorLoopList = cursorLoopList.getNext();
        cursorLoopList.setNext(new SimpleLinkedList<>(s5));

        cursorLoopList = cursorLoopList.getNext();
        cursorLoopList.setNext(new SimpleLinkedList<>(s6));

        cursorLoopList = cursorLoopList.getNext();
        cursorLoopList.setNext(new SimpleLinkedList<>(s7));

        cursorLoopList = cursorLoopList.getNext();
        cursorLoopList.setNext(new SimpleLinkedList<>(s8));

        cursorLoopList = cursorLoopList.getNext();
        cursorLoopList.setNext(new SimpleLinkedList<>(s9));

        cursorLoopList = cursorLoopList.getNext();
        cursorLoopList.setNext(new SimpleLinkedList<>(s10));

        cursorLoopList = cursorLoopList.getNext();
        cursorLoopList.setNext(new SimpleLinkedList<>(s11));

        cursorLoopList = cursorLoopList.getNext();
        cursorLoopList.setNext(new SimpleLinkedList<>(s12));

        cursorLoopList = cursorLoopList.getNext();
        cursorLoopList.setNext(startLoopNode);
        //end init
        SimpleLinkedList<SimpleData> loopHead = ListUtils.findLoop(loopList);
        System.out.printf("the loop head is %s\n\twith data %s\n", loopHead, loopHead.getData());
        System.out.printf(SEPARATOR, "end of test 2.8");
        System.out.println();
    }
}