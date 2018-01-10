package com.nwjon.udemy.stack;

public class Stack<T> {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
    }

    //LIFO - last in first out
    //Push - adding a new element to the top of the stack is called push
    //Pop - removing an element from the top of a stack is called pop
    //Peek - look at the top element of a stack
    //Is Empty, Is Full, Size
    //Exceptions: try to pop from an empty stack, try to push into a full stack
    //typically built with a linked list, could be array but would end up copying a lot of elements

    //Push, pop, and helper methods are constant time O(1)
    //is didn't use size var then would have been O(n)
    //space complexity is O(n)
    //translating infix notation for expressions to postfix
        //infix: a + b
        //postfix a b +

    //Uses
    //implement an undo in an application
    //back button on a web browser
    //holding the memory for a recursive calls in a programming language

    private static int MAX_SIZE = 40;

    private Element<T> top;

    //track the size of the stack at every update, so size operation can be in constant time
    private int size = 0;


    public void push(T data) throws StackOverflowException {

        if (size == MAX_SIZE) {
            throw new StackOverflowException();
        } else {
            top = new Element<>(data, top);
            size++;
        }
    }

    public T pop() throws StackUnderflowException {

        if (size == 0) {
            throw new StackUnderflowException();
        } else {
            T data = top.getData();
            top = top.getNext();
            size--;
            return data;
        }
    }

    public T peek() throws StackUnderflowException {

        if (size == 0) {
            throw new StackUnderflowException();
        } else {
            return top.getData();
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public int getSize() {
        return size;
    }

    private static class Element<T> {

        private T data;
        private Element<T> next;

        Element(T data, Element<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Element<T> getNext() {
            return next;
        }

        public void setNext(Element<T> next) {
            this.next = next;
        }
    }

    public static class StackOverflowException extends RuntimeException {

    }

    public static class StackUnderflowException extends RuntimeException {

    }


}
