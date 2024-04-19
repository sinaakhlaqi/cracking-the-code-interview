package com.crackingthecodeinterview.chapter2;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

import static com.crackingthecodeinterview.utilities.Constants.*;


//this list is written over SimpleNode with the assumption of elements of list or (data) is final
public class SimpleSinglyLinkedList<T extends Valuable<T>> implements Iterator<SimpleLinkedList<T>> {

    private SimpleLinkedList<T> list;
    private int length = 0;
    private SimpleLinkedList<T> current;

    public SimpleSinglyLinkedList() {
        this.list = new SimpleLinkedList<>();
        this.current = new SimpleLinkedList<>();
        this.current.setNext(list);
    }

    private SimpleSinglyLinkedList(SimpleLinkedList<T> list, int length) {
        this.list = list;
        this.current = new SimpleLinkedList<>();
        this.current.setNext(list);
        this.length = length;

    }

    //2.1 Write code to remove duplicates from an unsorted linked list whit extra memory.
    public void removeDuplicates() {
        if (list == null)
            return;
        Map<T, Boolean> dupList = new Hashtable<>();
        SimpleLinkedList<T> cursor = list;
        while (cursor != null) {
            T data = cursor.getData();
            if (dupList.get(data) == null) {
                dupList.put(data, true);
            } else {
                remove(cursor);
                //remove(data,1);
            }
            cursor = cursor.getNext();
        }
    }

    public void removeDuplicatesNoBuff() {
        if (length < 2)
            return;
        SimpleLinkedList<T> removeDuplicate = list;
        SimpleLinkedList<T> cursor = list.getNext();
        while (removeDuplicate != null) {
            while (cursor != null) {
                T data = cursor.getData();
                if (data.equals(removeDuplicate.getData())) {
                    remove(cursor);
                    length--;
                }
                cursor = cursor.getNext();
            }
            removeDuplicate = removeDuplicate.getNext();
            if (removeDuplicate != null)
                cursor = removeDuplicate.getNext();
        }

    }

    //2.2 Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list
    public SimpleLinkedList<T> kthToTheLast(int k) {

        if (k >= 0) {
            int countOfListElements = 0;
            SimpleLinkedList<T> current = list;
            while (current != null) {
                countOfListElements++;
                current = current.getNext();
            }
            if (k < countOfListElements) {
                current = list;
                for (int i = 0; i < countOfListElements - k - 1; i++) {
                    current = current.getNext();
                }
                return current;
            }
        }
        return null;
    }

    public SimpleLinkedList<T> kthToTheLastWithLength(int k) {
        if ((k < 0) || (k > length) || (length - k - 1 < 0))
            return null;
        SimpleLinkedList<T> current = list;
        for (int i = 0; i < length - k - 1; k++) {
            current = current.getNext();
        }
        return current;
    }


    //2.3 Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
    //    the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
    //    that node.
    public boolean removeMid() {
        if (length < 3)
            return false;
        SimpleLinkedList<T> midNode = get(getLength() / 2);
        remove(midNode);
        return true;
    }

    //2.4 Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
    //    before all nodes greater than or equal to x. If x is contained within the list the values of x only need
    //    to be after the elements less than x (see below). The partition element x can appear anywhere in the
    //    "right partition"; it does not need to appear between the left and right partitions.
    public void partition(int x) {
        SimpleLinkedList<T> left = null;
        SimpleLinkedList<T> leftTail = null;
        SimpleLinkedList<T> right = null;
        SimpleLinkedList<T> rightTail = null;
        SimpleLinkedList<T> current = list;
        while (current != null) {
            if (current.getData().val() >= x) {
                if (right == null) {
                    right = new SimpleLinkedList<>(current.getData());
                    rightTail = right;
                } else {
                    rightTail.setNext(new SimpleLinkedList<>(current.getData()));
                    rightTail = rightTail.getNext();
                }
            } else {
                if (left == null) {
                    left = new SimpleLinkedList<>(current.getData());
                    leftTail = left;
                } else {
                    leftTail.setNext(new SimpleLinkedList<>(current.getData()));
                    leftTail = leftTail.getNext();
                }
            }
            current = current.getNext();
        }

        if (left == null || right == null)
            return;
        leftTail.setNext(right);
        list = left;
    }

    //2.7 Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the
    //    intersecting node. Note that the intersection is defined based on reference, not value. That is, if the
    //    kth node of the first linked list is the exact same node (by reference) as the jth node of the second
    //    linked list, then they are intersecting.
    public SimpleSinglyLinkedList<T> intersect(SimpleSinglyLinkedList<T> otherList) {
        Stack<SimpleLinkedList<T>> thisListStack = new Stack<>();
        Stack<SimpleLinkedList<T>> otherListStack = new Stack<>();
        SimpleLinkedList<T> thisListCursor = list;
        SimpleLinkedList<T> otherListCursor = otherList.getList();
        int lengthOfIntersect = 0;
        boolean endOfIntersect = false;
        SimpleLinkedList<T> intersect = null;

        while (thisListCursor != null) {
            thisListStack.push(thisListCursor);
            thisListCursor = thisListCursor.getNext();
        }
        while (otherListCursor != null) {
            otherListStack.push(otherListCursor);
            otherListCursor = otherListCursor.getNext();
        }

        while (!thisListStack.empty() && !otherListStack.empty() && !endOfIntersect) {
            if (thisListStack.peek() == otherListStack.peek()) {
                intersect = thisListStack.pop();
                lengthOfIntersect++;
                otherListStack.pop();
            } else {
                endOfIntersect = true;
            }
        }
        return new SimpleSinglyLinkedList<>(intersect, lengthOfIntersect);
    }

    //helpers
    public SimpleLinkedList<T> get(int index) {
        SimpleLinkedList<T> current = list;
        final SimpleLinkedList<T> foundElement;
        if (index >= 0 && index <= length) {
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            foundElement = current;
            return foundElement;
        }
        return null;
    }

    public void remove(T data, int count) {
        int numOfRemoved = 0;
        if (list != null) {
            SimpleLinkedList<T> current = list;
            SimpleLinkedList<T> previous = new SimpleLinkedList<>();
            previous.setNext(current);
            while (current != null && numOfRemoved < count) {
                if (data.equals(current.getData())) {
                    if (current == list) {
                        list = list.getNext();
                        current = list;
                        previous.setNext(current);
                    } else {
                        previous.setNext(current.getNext());
                        current = current.getNext();
                    }
                    numOfRemoved++;
                    length--;

                } else {
                    current = current.getNext();
                    previous = previous.getNext();
                }
            }
        }
        length -= numOfRemoved;
    }

    public boolean remove(SimpleLinkedList<T> node) {
        SimpleLinkedList<T> current = list;
        if (node == current) {
            length--;
            list = list.getNext();
            return true;
        } else {
            SimpleLinkedList<T> previous = new SimpleLinkedList<>();
            previous.setNext(current);
            while (current != null) {
                if (current == node) {
                    length--;
                    previous.setNext(current.getNext());
                    return true;
                }
                current = current.getNext();
                previous = previous.getNext();
            }
            return false;
        }
    }

    public String asNumberString() {
        StringBuilder number = new StringBuilder();
        SimpleLinkedList<T> current = list;
        while (current != null) {
            number.insert(0, current.getData().val());
            current = current.getNext();
        }
        return number.toString();
    }

    public void appendToTail(T data) {
        if (length == 0) {
            list.setData(data);
        } else {
            SimpleLinkedList<T> cursor = list;
            while (cursor.getNext() != null) {
                cursor = cursor.getNext();
            }
            cursor.setNext(new SimpleLinkedList<T>(data));
        }
        length++;
    }

    public void appendToTail(SimpleSinglyLinkedList<T> list) {
        if (list.getLength() > 0) {
            if (length == 0) {
                this.list = list.getList();
            } else {
                SimpleLinkedList<T> current = this.list;
                while (current.getNext() != null)
                    current = current.getNext();
                current.setNext(list.getList());
            }
            length += list.getLength();
        }
    }

    public int getLength() {
        return length;
    }

    public SimpleLinkedList<T> getList() {
        return list;
    }

    @Override
    public boolean hasNext() {
        return current.getNext() != null;
    }

    @Override
    public SimpleLinkedList<T> next() {
        if (hasNext()) {
            current = current.getNext();
            return current;
        } else {
            this.current.setNext(list);
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder listItems = new StringBuilder();
        if (length == 0) {
            listItems.append(EMPTY_STRING);
        } else {
            SimpleLinkedList<T> cursor = list;
            while (cursor.getNext() != null) {
                listItems.append(String.format("%s \n", cursor.getData().toString()));
                cursor = cursor.getNext();
            }
            if (cursor.getData() != null)
                listItems.append(String.format("%s \n", cursor.getData().toString()));
        }
        return listItems.toString();
    }
}