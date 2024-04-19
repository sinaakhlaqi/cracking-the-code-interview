package com.crackingthecodeinterview.chapter2;


// SimpleNode represent a simple one direction linked list the Data Structure that
// we build the SimpleSinglyList list on;
public class SimpleLinkedList<T> {

    private SimpleLinkedList<T> next;
    private T data;

    public SimpleLinkedList(T data) {
        this.data = data;
    }

    public SimpleLinkedList() {
        this.data = null;
    }

    public SimpleLinkedList<T> getNext() {
        return next;
    }

    public void setNext(SimpleLinkedList<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}