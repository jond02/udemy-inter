package com.nwjon.jon;

public class LinkedListGeneric<T> {

    private Node<T> head;

    private class Node<S> {

        private S data;
        private Node<S> next;

        public S getData() {
            return data;
        }

        public void setData(S data) {
            this.data = data;
        }

        public Node<S> getNext() {
            return next;
        }

        public void setNext(Node<S> next) {
            this.next = next;
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public void add(T data) {

        Node<T> node = new Node<>();
        node.setData(data);

        if (head == null) {
            head = node;
        } else {

            Node<T> n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    public int size() {

        int i = 0;
        Node node = head;
        while (node != null) {
            i++;
            node = node.next;
        }
        return i;
    }

    public void delete() {
        while (head != null) {
            head = head.next;
        }
        //or head = null
    }

    public Node pop() {

        //behave like a stack, first in, first out
        if (head == null) {
            return null;
        } else {
            Node node = head;
            head = head.next;
            return node;
        }
    }

    
    public void print() {
        
        Node<T> n = head;
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }
}
