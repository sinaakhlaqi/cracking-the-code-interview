package com.crackingthecodeinterview.exceptions;

public class FullMultiStackException extends FullStackException {

    private final int stackNumber;
    private final static String TYPE = "MultiFixedSizeStack";

    public FullMultiStackException(int stackNumber) {
        super(TYPE, String.format("stackNumber=%d", stackNumber));
        this.stackNumber = stackNumber;
    }

    public int getStackNumber() {
        return stackNumber;
    }
}
