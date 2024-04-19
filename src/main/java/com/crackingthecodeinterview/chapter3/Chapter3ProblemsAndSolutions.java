package com.crackingthecodeinterview.chapter3;

import java.util.Stack;

import static com.crackingthecodeinterview.utilities.Constants.*;

public class Chapter3ProblemsAndSolutions {
    public static void main(String[] args) {

        //3.1 test
        System.out.println(String.format(SEPARATOR, "3.1 Testing MultiStack"));

        MultiStackFixedSize multiStackFixedSize1 = new MultiStackFixedSize(3, 2);

        //Init multiStack with some data

        multiStackFixedSize1.push(1, 1);
        multiStackFixedSize1.push(2, 1);
        multiStackFixedSize1.push(3, 2);
        multiStackFixedSize1.push(4, 2);
        multiStackFixedSize1.push(5, 3);
        multiStackFixedSize1.push(6, 3);

        System.out.println(String.format(SEPARATOR, "-"));
        System.out.println(multiStackFixedSize1);

        int i1_1 = multiStackFixedSize1.removeAt(1, 1);
        int i1_2 = multiStackFixedSize1.removeAt(1, 1);

        multiStackFixedSize1.push(1, 1);

        System.out.println(String.format(SEPARATOR, "-"));
        System.out.println(multiStackFixedSize1);

        int i1_3 = multiStackFixedSize1.removeAt(1, 1);

        System.out.println(String.format(SEPARATOR, "-"));
        System.out.println(multiStackFixedSize1);

        // This snippet causes EmptyStackException

//        int i1_4 = multiStackFixedSize1.pop(1);
//        int i1_5 = multiStackFixedSize1.pop(2);
//        int i1_6 = multiStackFixedSize1.pop(2);
//        int i1_7 = multiStackFixedSize1.pop(2);

        System.out.println(String.format(SEPARATOR, "-"));
        System.out.println(multiStackFixedSize1);

        // This snippet causes FullStackException

//        multiStackFixedSize1.push(7, 2);
//        multiStackFixedSize1.push(8, 2);
//        multiStackFixedSize1.push(9, 3);
//        multiStackFixedSize1.push(10, 3);
//        multiStackFixedSize1.push(11, 3);

        System.out.println(String.format(SEPARATOR, "-"));
        System.out.println(multiStackFixedSize1);

        int i1_8 = multiStackFixedSize1.pop(3);
        multiStackFixedSize1.push(12, 3);

        System.out.println(String.format(SEPARATOR, "-"));
        System.out.println(multiStackFixedSize1);

        int i1_9 = multiStackFixedSize1.pop(3);
        multiStackFixedSize1.push(13, 3);

        // Again this snippet causes EmptyStackException

//        int i8 = multiStackFixedSize1.pop(1);
//        int i9 = multiStackFixedSize1.pop(1);

        System.out.println(String.format(SEPARATOR, "-"));
        System.out.println(multiStackFixedSize1);

        System.out.println(String.format(SEPARATOR, "3.1 End of testing MultiStack"));

        //3.2 test
        System.out.println(String.format(SEPARATOR, "3.2 Testing StackWithMin"));
        StackWithMin stackWithMin = new StackWithMin();
        stackWithMin.push(10);
        stackWithMin.push(2);
        stackWithMin.push(5);
        stackWithMin.push(1);

        System.out.println(String.format(SEPARATOR, "-"));
        System.out.println(stackWithMin.min());

        stackWithMin.pop();
        stackWithMin.pop();

        System.out.println(String.format(SEPARATOR, "-"));
        System.out.println(stackWithMin.min());

        stackWithMin.pop();

        System.out.println(String.format(SEPARATOR, "-"));
        System.out.println(stackWithMin.min());

        System.out.println(String.format(SEPARATOR, "3.2 End of testing StackWithMin"));

        //3.3 test

        System.out.println(String.format(SEPARATOR, "3.3 Testing SetOfStacks"));

        SetOfStacks setOfStacks = new SetOfStacks(2);
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);
        setOfStacks.push(6);

        System.out.println(String.format(SEPARATOR, '-'));
        System.out.println("length: " + setOfStacks.getLength());
        System.out.println(setOfStacks);

        setOfStacks.popAt(1);
        setOfStacks.popAt(2);

        System.out.println(String.format(SEPARATOR, '-'));
        System.out.println(setOfStacks);
        System.out.println("length: " + setOfStacks.getLength());

        System.out.println(String.format(SEPARATOR, "3.3 End of testing SetOfStacks"));

        //test 3.4

        System.out.println(String.format(SEPARATOR, "3.4 Testing MyQueue"));

        MyQueue myQueue = new MyQueue();

        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);

        System.out.println(String.format(SEPARATOR, '-'));
        System.out.println(myQueue);

        Integer i = myQueue.removeFirst();
        i = myQueue.removeFirst();
        myQueue.add(10);
        myQueue.removeFirst();
        myQueue.removeFirst();

        System.out.println(String.format(SEPARATOR, '-'));
        System.out.println(myQueue);

        System.out.println(String.format(SEPARATOR, "3.4 End of testing MyQueue"));


        //test 3.5

        System.out.println(String.format(SEPARATOR, "3.5 Testing bubbleSortStack(Stack)"));

        Stack<Integer> stack = new Stack<>();

        stack.push(2);
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(4);

        bubbleSortStack(stack);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(String.format(SEPARATOR, "3.5 End of testing bubbleSortStack(Stack)"));
    }

    //3.5 Sort Stack: Write a program to sort a stack such that the smallest items
//    are on the top. You can use
//    an additional temporary stack,
//    but you may not copy the elements into any other data structure
//    (such as an array).
//    The stack supports the following operations: push, pop, peek, and is Empty.
    public static <T extends Comparable<T>> void bubbleSortStack(Stack<T> stack) {
        T temp;
        Stack<T> auxiliary = new Stack<>();

        if (stack.size() > 1) {
            while (!stack.isEmpty()) {
                temp = stack.pop();
                if (!stack.isEmpty() && stack.peek().compareTo(temp) < 0) {
                    auxiliary.push(stack.pop());
                    stack.push(temp);
                    while (!auxiliary.isEmpty())
                        stack.push(auxiliary.pop());
                } else {
                    auxiliary.push(temp);
                }
            }
            while (!auxiliary.isEmpty()) {
                stack.push(auxiliary.pop());
            }
        }
    }
}