package com.nwjon.udemy.recursion;

class Node {

    private int id;
    private Node left;
    private Node right;

    Node(int id) {
        this.id = id;
    }

    int getId() {
        return id;
    }

    Node getLeft() {
        return left;
    }

    Node getRight() {
        return right;
    }

    void addChildren(Node left, Node right) {
        this.left = left;
        this.right = right;
    }
}
