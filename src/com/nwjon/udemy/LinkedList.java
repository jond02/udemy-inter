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
    //pop, first in first out
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

    public static boolean isSame(LinkedList list1, LinkedList list2) {
        return isSame(list1.getNth(0), list2.getNth(0));
    }

    public static boolean isSame(Node node1, Node node2) {

        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        }

        return node1.value == node2.value && isSame(node1.getNext(), node2.getNext());
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

    public void appendList(LinkedList list) {

        if (list == null) {
            return;
        }

        if (head == null) {

            head = list.head;
        } else {

            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = list.head;
        }
    }

    public LinkedList[] frontBackSplit() {

        if (head == null) {
            return null;
        }

        LinkedList[] arr = new LinkedList[2];

        //one node in list
        if (head.next == null) {
            arr[0] = this;
            arr[1] = null;
            return arr;
        }

        //walk through list with two references
        //fast goes through twice as fast, so when reaches the end the list is split
        Node slow = head;
        Node fast = head;

        while (fast != null) {

            fast = fast.next;
            if (fast == null) {
                break;
            }

            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
            }
        }

        //create second list and assign the head to the next node in slow
        LinkedList list2 = new LinkedList();
        list2.head = slow.next;
        arr[1] = list2;

        //set slow next to null and return 'this' as first list
        slow.next = null;
        arr[0] = this;

        return arr;
    }

    public static void moveNode(LinkedList dest, LinkedList src) {

        if (src == null || src.head == null || dest == null) {
            return;
        }

        //removed null checks because assigning head or next to null is fine

        //move head of src
        Node node = src.head;

        //remove head from the src list
        src.head = src.head.next;

        //link the nodes in the list to the new head
        node.next = dest.head;
        //replace the head
        dest.head = node;
    }

    public static LinkedList sortedMerge(LinkedList list1, LinkedList list2) {

        //if one is null return the other list, which might be null as well
        if (list1 == null || list1.head == null) {
            return list2;
        } else if (list2 == null || list2.head == null) {
            return list1;
        }

        LinkedList merged = new LinkedList();

        //find which node should be first from the two lists and set merged head
        if (list1.head.value < list2.head.value) {
            merged.head = list1.head;
            list1.head = list1.head.next;
        } else {
            merged.head = list2.head;
            list2.head = list2.head.next;
        }

        Node node1 = list1.head;
        Node node2 = list2.head;
        Node current = merged.head;

        while (node1 != null && node2 != null) {

            //find which one is smaller, set new current, and go to next for added and current
            if (node1.value < node2.value) {
                current.next = node1;
                node1 = node1.next;
            } else {
                current.next = node2;
                node2 = node2.next;
            }
            current = current.next;
        }

        //add the rest for the list that didn't run out
        if (node1 != null) {
            current.next = node1;
        } else {
            current.next = node2;
        }

        return merged;
    }

    public static LinkedList reverse(LinkedList list) {

        Node previous = null;
        Node next;
        Node current = list.head;

        while (current != null) {

            next = current.next;

            //reverse the link
            current.next = previous;

            //move previous and current by 1
            previous = current;
            current = next;
        }

        LinkedList list1 = new LinkedList();
        list1.head = previous;

        return list1;
    }

    public void reverseInPlace() {

        Node previous = null;
        Node next;
        Node current = head;

        while (current != null) {

            //store the next value, then overwrite with the previous value to reverse the link
            next = current.next;
            current.next = previous;

            //assign the new first node to previous
            previous = current;

            //use stored next value to move to next in list
            current = next;
        }
        head = previous;
    }

    public void removeSortedDuplicates() {

        if (head == null) {
            return;
        }

        Node previous = head;
        Node current  = head.next;

        while (current != null) {

            if (previous.value == current.value) {

                //match found, remove duplicate current from list
                //1, 3, 3, 4 -> 1, 3, 4
                previous.next = current.next;
                //advance current to test against previous value
                current = previous.next;

            } else {

                //advance, match not found
                previous = current;
                current = current.next;
            }

        }
    }


    public void print() {
        Node n = head;
        while(n != null) {
            System.out.println(n.value);
            n = n.next;
        }
    }

}
