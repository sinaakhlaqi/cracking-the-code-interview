package com.crackingthecodeinterview.exceptions;

import static com.crackingthecodeinterview.utilities.Constants.EMPTY_STRING;

public class EmptyStackException extends RuntimeException {

    private String stackType;

    public EmptyStackException() {
        super("Stack is empty");
        this.stackType = EMPTY_STRING;
    }

    public EmptyStackException(String stackType, String stackSpecifics) {
        super(String.format("%s with %s is empty", stackType, stackSpecifics));
        this.stackType = stackType;
    }

    public String getStackType() {
        return stackType;
    }
}
