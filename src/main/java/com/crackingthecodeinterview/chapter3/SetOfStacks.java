package com.crackingthecodeinterview.chapter3;

import com.crackingthecodeinterview.exceptions.EmptyMultiStackException;
import com.crackingthecodeinterview.exceptions.EmptyStackException;
import com.crackingthecodeinterview.exceptions.FullMultiStackException;


//3.3 Stack of Plates: Imagine a (literal) stack of plates.
// If the stack gets too high, it might topple.
//    Therefore, in real life, we would likely start a new stack when
//    the previous stack exceeds some
//    threshold. Implement a data structure SetOfStacks that mimics this.
//    SetO-fStacks should be
//    composed of several stacks and should create a new stack
//    once the previous one exceeds capacity.
//    SetOfStacks. push() and SetOfStacks.
//    pop() should behave identically to a single stack
//    (that is, pop () should return the same values as it would
//    if there were just a single stack).

//    FOLLOW UP
//    Implement a function popAt(int index) which performs
//    a pop operation on a specific subStack.

public class SetOfStacks {

    private final int threshold;
    private final SubStackNode setOfStacks;
    private int length;

    private SubStackNode current;

    public SetOfStacks(int threshold) {
        this.threshold = threshold;
        setOfStacks = new SubStackNode(threshold);
        length = 0;
        current = setOfStacks;
    }

    public void push(int data) {
        try {
            if (isEmpty()) {
                length++;
            }
            current.subStack.push(data, 1);
        } catch (FullMultiStackException e) {
            SubStackNode newStack = new SubStackNode(threshold);
            newStack.subStack.push(data, 1);
            current.next = newStack;
            current = current.next;
            length++;
        }
    }

    public int pop() throws EmptyStackException {
        int data;
        try {
            data = current.subStack.pop(1);
            if (isEmpty()) {
                length = 0;
            }
        } catch (EmptyMultiStackException e) {

            if (current == setOfStacks)
                throw new EmptyStackException();
            SubStackNode cursor = setOfStacks;
            while (cursor.next != current) {
                cursor = cursor.next;
            }
            current = cursor;
            data = current.subStack.pop(1);
            length--;
        }
        return data;
    }

    private static class SubStackNode {
        private final MultiStackFixedSize subStack;
        private SubStackNode next;

        public SubStackNode(int threshold) {
            this.subStack = new MultiStackFixedSize(1, threshold);
            next = null;
        }

    }

    public int getLength() {
        return length;
    }

    public int popAt(int subStackNumber) throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int subStackIndex = subStackNumber - 1;
        SubStackNode cursor = setOfStacks;
        for (int i = 0; i < subStackIndex; i++) {
            cursor = cursor.next;
        }
        int data = cursor.subStack.pop(1);
        current = cursor;
        length = subStackNumber;
        if (cursor.next != null) {
            cursor = cursor.next;
            while (cursor != null) {
                if (!cursor.subStack.isEmpty(1)) {
                    push(cursor.subStack.removeAt(1, 1));
                } else {
                    cursor = cursor.next;
                }
            }
        }
        return data;
    }

    public boolean isEmpty() {
        return (current == setOfStacks && setOfStacks.subStack.isEmpty(1));
    }

    @Override
    public String toString() {
        SubStackNode cursor = setOfStacks;
        StringBuilder output = new StringBuilder();
        while (cursor != null) {
            output.append(String.format("%s \n", cursor.subStack.toString()));
            cursor = cursor.next;
        }
        return output.toString();
    }
}
