package com.nwjon.udemy.stack;

public class MinimumStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minimumStack = new Stack<>();

    public void push(int data) {

        int min = data;
        if (!minimumStack.isEmpty()) {
            if (min > minimumStack.peek()) {
                min = minimumStack.peek();
            }
        }
        stack.push(data);
        minimumStack.push(min);
    }

    public int pop() {
        minimumStack.pop();
        return stack.pop();
    }

    // O(1) - constant time
    public int getMinimum() {
        return minimumStack.peek();
    }
}
