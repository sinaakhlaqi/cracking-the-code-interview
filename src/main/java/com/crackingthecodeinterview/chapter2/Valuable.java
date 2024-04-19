package com.crackingthecodeinterview.chapter2;

//each class implement this,should announce its own value
public interface Valuable<T> extends Comparable<T> {
    int val();
}
