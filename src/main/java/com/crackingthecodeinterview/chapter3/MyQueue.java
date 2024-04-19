package com.crackingthecodeinterview.chapter3;

import java.util.Stack;

//3.5 Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks
public class MyQueue implements Cloneable {

    private final Stack<Integer> inputBufferStack;
    private final Stack<Integer> orderStack;
    private int length;

    public MyQueue() {
        inputBufferStack = new Stack<>();
        orderStack = new Stack<>();
        length = 0;
    }

    private MyQueue(MyQueue myQueue) {
        this.orderStack = (Stack<Integer>) myQueue.orderStack.clone();
        this.inputBufferStack = (Stack<Integer>) myQueue.inputBufferStack.clone();
        this.length = myQueue.length;
    }

    public void add(Integer data) {
        length++;
        inputBufferStack.push(data);
    }

    public Integer removeFirst() {
        Integer data;
        if (orderStack.empty()) {
            if (inputBufferStack.empty()) {
                throw new RuntimeException("queue is empty");
            } else {
                while (!inputBufferStack.empty()) {
                    orderStack.push(inputBufferStack.pop());
                }
                data = orderStack.pop();
            }
        } else {
            data = orderStack.pop();
        }
        length--;
        return data;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        StringBuilder queueItems = new StringBuilder();
        try {
            MyQueue temp = (MyQueue) this.clone();
            while (!temp.isEmpty())
                queueItems.append(String.format("%s <- ", temp.removeFirst()));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return queueItems.substring(0, queueItems.length() - 4).toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        MyQueue myQueue = new MyQueue(this);
        return myQueue;
    }
}