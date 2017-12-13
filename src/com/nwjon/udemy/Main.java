package com.nwjon.udemy;

public class Main {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.append(2);
        list.append(4);
        list.append(6);

        list.sortedInsert(3);

        list.print();



    }

}
