package com.crackingthecodeinterview.exceptions;

import java.util.Arrays;

public class MalformedCharArrayException extends RuntimeException {

    private final int numOfRequiredSpaces;
    private final int numOfProvidedSpaces;
    private final char[] url;

    public MalformedCharArrayException(char[] url, int numOfRequiredSpaces, int numOfProvidedSpaces) {
        super(String.format
                ("Char array \n%s\nrequire" +
                                " %d spaces to be urlified" +
                                " but provided %d\n",
                        Arrays.toString(url), numOfRequiredSpaces, numOfProvidedSpaces));
        this.numOfRequiredSpaces = numOfRequiredSpaces;
        this.numOfProvidedSpaces = numOfProvidedSpaces;
        this.url = url;
    }

    public int getNumOfRequiredSpaces() {
        return numOfRequiredSpaces;
    }

    public int getNumOfProvidedSpaces() {
        return numOfProvidedSpaces;
    }

    public char[] getUrl() {
        return url;
    }
}
