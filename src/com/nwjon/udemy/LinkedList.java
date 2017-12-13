package com.nwjon.udemy;

public class LinkedList {

    private Node head;

    public class Node {
        private int value;
        private Node next;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public void delete() {

        while (head != null) {
            head = head.next;
        }
    }

    //behave like a stack
    public Node pop() {

        if (head == null) {
            return null;
        } else {
            Node n = head;
            head = head.next;
            return n;
        }
    }

    public void append(int value) {

        Node node = new Node();
        node.value = value;

        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    public int size() {

        if (head == null) {
            return 0;
        } else {
            int i = 1;
            Node n = head;
            while(n.next != null) {
                n = n.next;
                i++;
            }
            return i;
        }
    }

    public int size2() {

        int i = 0;
        Node n = head;
        while (n != null) {
            i++;
            n = n.next;
        }
        return i;
    }

    public Node getNth(int i) {

        //out of bounds check
        if (i < 0) {
            return null;
        }

        Node n = head;
        int index = 0;
        while(n != null && index < i) {
            n = n.next;
            index++;
        }
        return n;
    }

    public void insertNth(int value, int index) {

        if (index < 0) {
            return;
        }

        Node node = new Node();
        node.setValue(value);

        //set a new head
        if (index == 0 || head == null) {
            node.setNext(head);
            head = node;
            return;
        }

        //find index to insert at
        Node previous = head;
        Node current = head;

        int j = 0;
        while (current != null && j < index) {
            j++;
            previous = current;
            current = current.next;
        }

        previous.setNext(node);
        node.setNext(current);
    }

    public void sortedInsert(int value) {

        Node node = new Node();
        node.setValue(value);

        Node previous = null;
        Node current = head;

        while (current != null && value > current.value) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            //head is null or value is less than head value
            head = node;
        } else {
            previous.setNext(node);
        }

        node.setNext(current);
    }

    public void print() {
        Node n = head;
        while(n != null) {
            System.out.println(n.value);
            n = n.next;
        }
    }

}
