package com.crackingthecodeinterview.exceptions;

import static com.crackingthecodeinterview.utilities.Constants.EMPTY_STRING;

public class FullStackException extends RuntimeException {

    private String stackType;

    public FullStackException() {
        super("Stack is full");
        this.stackType = EMPTY_STRING;
    }

    public FullStackException(String stackType, String stackSpecifics) {
        super(String.format("%s with %s is full", stackType, stackSpecifics));
        this.stackType = stackType;
    }

    public String getStackType() {
        return stackType;
    }
}
