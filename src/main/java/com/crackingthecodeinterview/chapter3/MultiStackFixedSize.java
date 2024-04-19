package com.crackingthecodeinterview.chapter3;


import com.crackingthecodeinterview.exceptions.EmptyMultiStackException;
import com.crackingthecodeinterview.exceptions.FullMultiStackException;
import com.crackingthecodeinterview.exceptions.InvalidStackNumberException;

import static com.crackingthecodeinterview.utilities.Constants.*;


//3.1 Three in One: Describe how you could use a
//    single array to implement three stacks
public class MultiStackFixedSize {

    private final int numberOfStacks;
    private final int stackCapacity;
    private final int[] data;
    private final int[] countOfElements;

    public MultiStackFixedSize(int numberOfStacks, int stackCapacity) {
        this.numberOfStacks = numberOfStacks;
        this.stackCapacity = stackCapacity;
        data = new int[numberOfStacks * stackCapacity];
        countOfElements = new int[numberOfStacks];
    }

    public void push(int dataElement, int stackNumber)
            throws InvalidStackNumberException, FullMultiStackException {
        checkStackNumber(stackNumber);
        if (isFull(stackNumber))
            throw new FullMultiStackException(stackNumber);

        int stackIndex = stackNumber - 1;
        int head = stackIndex * stackCapacity + countOfElements[stackIndex];
        data[head] = dataElement;
        countOfElements[stackIndex]++;
    }

    public int pop(int stackNumber)
            throws InvalidStackNumberException, EmptyMultiStackException {
        checkStackNumber(stackNumber);

        if (isEmpty(stackNumber))
            throw new EmptyMultiStackException(stackNumber);

        int stackIndex = stackNumber - 1;
        int head = stackIndex * stackCapacity + (countOfElements[stackIndex] - 1);
        countOfElements[stackIndex]--;
        return data[head];
    }

    public int sizeOf(int stackNumber) throws InvalidStackNumberException {
        checkStackNumber(stackNumber);
        return countOfElements[stackNumber - 1];
    }

    public int peek(int stackNumber) throws InvalidStackNumberException {
        checkStackNumber(stackNumber);

        if (isEmpty(stackNumber))
            throw new NullPointerException(String.format("stack %d is empty", stackNumber));

        int stackIndex = stackNumber - 1;
        int head = stackIndex * stackCapacity + (countOfElements[stackIndex] - 1);
        return data[head];
    }

    public int removeAt(int stackNumber, int elementNumber) throws EmptyMultiStackException,
            IndexOutOfBoundsException {
        int stackIndex = stackNumber - 1;
        int elementIndex = stackNumber - 1;
        checkStackNumber(stackNumber);
        if (countOfElements[stackIndex] == 0)
            throw new EmptyMultiStackException(stackNumber);
        if (elementNumber > countOfElements[stackIndex] || elementNumber < 1)
            throw new IndexOutOfBoundsException
                    (String.format("index %d is not within bounds", elementIndex));

        int element = data[stackIndex * stackCapacity + elementIndex];
        for (int i = stackIndex * stackCapacity + elementIndex
             ; i < stackIndex * stackCapacity + countOfElements[stackIndex] - 1;
             i++) {
            data[i] = data[i + 1];
        }
        countOfElements[stackIndex]--;
        return element;
    }

    //helpers
    public boolean isEmpty(int stackNumber) throws InvalidStackNumberException {
        checkStackNumber(stackNumber);

        int stackIndex = stackNumber - 1;
        return countOfElements[stackIndex] == 0;
    }

    public boolean isFull(int stackNumber) throws InvalidStackNumberException {
        checkStackNumber(stackNumber);

        int stackIndex = stackNumber - 1;
        return countOfElements[stackIndex] == stackCapacity;
    }

    public void checkStackNumber(int stackNumber) {
        if (stackNumber > numberOfStacks || stackNumber < 1)
            throw new InvalidStackNumberException(stackNumber);
    }

    @Override
    public String toString() {
        StringBuilder output =
                new StringBuilder(String.format("Total stacks %s. Capacity of each %s\n"
                        , numberOfStacks, stackCapacity));
        for (int i = 0; i < countOfElements.length; i++) {
            StringBuilder stackItemList = new StringBuilder();
            if (countOfElements[i] == 0) {
                output.append(String.format("stack %d is empty\n", (i + 1)));

            } else {
                int firstElement = i * stackCapacity;
                int lastElement = firstElement + (countOfElements[i] - 1);
                stackItemList.append(String.format(SEPARATOR, String.format("stack %d", i + 1)));
                stackItemList.append(TOP_STACK_EMBLEM);
                for (int j = lastElement; j >= firstElement; j--) {
                    stackItemList.append(String.format("%s <- ", data[j]));
                }
                output.append(String.format("%s\n",
                        stackItemList.substring(0, stackItemList.length() - 4)));
            }
        }
        return output.toString();
    }
}