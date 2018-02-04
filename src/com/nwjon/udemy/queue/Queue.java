package com.nwjon.udemy.queue;

import java.lang.reflect.Array;

public class Queue<T> {

    //FIFO - first in first out
    //operation on a queue are performed at two ends, removal is at the beginning and addtiion is at the end of the queue

    //Enqueue - Add an element ot the end of a queue
    //Dequeue - Remove an element from the end of a queue
    //Peek - See first element in queue
    //Offer - Adds an element to a queue if space is available (Java)
    //IsEmpty, isFull

    //Implement
    //LinkedList with pointer to head and tail
    //Common - circular queue with array that has tail pointer that points to the front of the array

    //Constant time O(1)
    //Space complexity O(n) - linear

    private static final int EMPTY_VALUE = -1;
    private static int MAX_SIZE = 40;
    private T[] elements;

    //the head index is initialized to a special value which
    //indicates that the queue is empty. Tail doesn't need it, but to be consistent
    private int headIndex = EMPTY_VALUE;
    private int tailIndex = EMPTY_VALUE;

    public Queue(Class<T> clazz) {
        elements = (T[]) Array.newInstance(clazz, MAX_SIZE);
    }

    public boolean isEmpty() {
        return headIndex == EMPTY_VALUE;
    }

    public boolean isFull() {

        //head index and tail index are right next to each other can mean full or two elements
        //if tail is moving towards head index it means teh queue is full
        // % lets the index wrap around if needed
        int nexIndex = (tailIndex + 1) % elements.length;
        return nexIndex == headIndex;
    }

    public void enqueue(T data) throws QueueOverflowException {

        if (isFull()) {
            throw new QueueOverflowException();
        }

        tailIndex = (tailIndex + 1) % elements.length;
        elements[tailIndex] = data;

        //this is the first element enqueued, set the head index to the tail index
        if (headIndex == EMPTY_VALUE) {
            headIndex = tailIndex;
        }
    }

    public T dequeue() throws QueueUnderflowException {

        if (isEmpty()) {
            throw new QueueUnderflowException();
        }

        T data = elements[headIndex];

        //this was the last element in the queue
        if (headIndex == tailIndex) {
            headIndex = EMPTY_VALUE;
        } else {
            headIndex = (headIndex + 1) % elements.length;
        }
        return data;
    }


    public static class QueueOverflowException extends RuntimeException {

    }

    public static class QueueUnderflowException extends RuntimeException {

    }

}
