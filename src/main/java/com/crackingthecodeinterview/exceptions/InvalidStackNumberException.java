package com.crackingthecodeinterview.exceptions;


public class InvalidStackNumberException extends RuntimeException {

    private final int stackNumber;

    public InvalidStackNumberException(int stackNumber) {
        super(String.format("no such stack with number %d", stackNumber));
        this.stackNumber = stackNumber;
    }

    public int getStackNumber() {
        return stackNumber;
    }
}
