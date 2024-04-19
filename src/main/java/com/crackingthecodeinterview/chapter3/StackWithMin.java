package com.crackingthecodeinterview.chapter3;

import java.util.Stack;


//3.2 Stack Min: How would you design a stack which,
//    in addition to push and pop, has a function min
//    which returns the minimum element? Push,
//    pop and min should all operate in 0(1) time.
public class StackWithMin {
    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;

    public StackWithMin() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int data) {
        if (data < min())
            minStack.push(data);
        stack.push(data);
    }

    public int pop() {
        int output = stack.pop();
        if (output == min())
            minStack.pop();
        return output;
    }

    public int peek() {
        return stack.peek();
    }

    public int min() {
        if (stack.isEmpty())
            return Integer.MAX_VALUE;
        return minStack.peek();
    }
}
