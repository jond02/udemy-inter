package com.nwjon.udemy;

public class DoublyLinkedList {

    Node head;
    Node tail;

    private class Node {

        int data;
        Node next;
        Node prev;
    }

    public void add(int val) {

        Node node = new Node();
        node.data = val;

        if (head == null) {
            node.next = null;
            node.prev = null;
            head = node;
            tail = node;
        } else {

            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void delete(int val) {

        if (head == null) {
            return;
        }

        Node node = head;

        //find val in list
        while (node != null && node.data != val) {
            node = node.next;
        }

        //not found
        if (node == null) {
            return;
        }

        if (node.prev != null) {
            //update next to cut the node from the list
            node.prev.next = node.next;
        } else {
            //at the head of the list
            head = node.next;
        }

        if (node.next != null) {
            //update prev to cut the node from the list
            node.next.prev = node.prev;
        }
    }

    public void print() {
        Node n = head;
        while(n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }
}
