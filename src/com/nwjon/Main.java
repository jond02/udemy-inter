package com.nwjon;

import com.nwjon.jon.LinkedListGeneric;

public class Main {

    public static void main(String[] args) {

        LinkedListGeneric<String> list = new LinkedListGeneric<>();
        list.add("coool");
        list.add("yooo");
        list.add("hi");
        System.out.println(list.size());
        list.print();
        list.delete();
        list.add("yess");
        list.print();

        LinkedListGeneric<Integer> integerList = new LinkedListGeneric<>();
        integerList.add(7);
        integerList.add(8);
        integerList.add(9);
        integerList.print();

    }

}
