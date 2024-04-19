package com.crackingthecodeinterview.exceptions;

public class EmptyMultiStackException extends EmptyStackException {

    private final int stackNumber;
    private final static String TYPE = "MultiFixedSizeStack";

    public EmptyMultiStackException(int stackNumber) {
        super(TYPE, String.format("Stack Number %d", stackNumber));
        this.stackNumber = stackNumber;
    }

    public int getStackNumber() {
        return stackNumber;
    }
}
