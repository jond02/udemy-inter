package com.nwjon.udemy;

public class Main {

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.delete(4);

        list.print();

    }

    public static void reverse() {
        LinkedList list = new LinkedList();

        list.append(1);
        list.append(10);
        list.append(20);
        list.append(21);

        list.reverseInPlace();

        list.print();

    }

    public static void sortedMerge() {
        LinkedList list = new LinkedList();

        list.append(1);
        list.append(10);
        list.append(20);
        list.append(21);

        LinkedList list2 = new LinkedList();

        list2.append(2);
        list2.append(4);
        list2.append(6);
        list2.append(8);
        list2.append(8);
        list2.append(25);

        LinkedList merged = LinkedList.sortedMerge(list, list2);

        merged.print();

    }

    public static void move() {
        LinkedList list = new LinkedList();

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(6);

        LinkedList list2 = new LinkedList();

        list2.append(10);
        list2.append(11);
        list2.append(12);

        LinkedList.moveNode(list, list2);

        list.print();
        System.out.println();
        list2.print();

    }

    public static void append() {

        LinkedList list = new LinkedList();

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(3);
        list.append(3);
        list.append(6);
        list.append(9);
        list.append(9);
        list.append(9);

        list.removeSortedDuplicates();

        list.print();
    }

    public static void split() {

        LinkedList list = new LinkedList();

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(3);
        list.append(5);
        list.append(6);
        list.append(7);
        list.append(8);
        list.append(9);

        LinkedList[] lists = list.frontBackSplit();

        lists[0].print();

        System.out.println();

        lists[1].print();
    }

}
