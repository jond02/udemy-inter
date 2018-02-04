package com.nwjon.udemy.recursion;

import java.util.ArrayList;
import java.util.List;

public class Recursion {

    //what is the base case?

    //what is the recursive case?

    //everyday: 1 effective java item, 1 design pattern

    List<Integer> integers = new ArrayList<>();

    {
        integers.add(1);
        integers.add(2);
        integers.add(3);
    }

    public static void main(String[] args) {
        Recursion recursion = new Recursion();

        System.out.println(recursion.findAnagrams("abcde"));


    }

    /** Complexity is O(n!) - n factorial
     *  1 * 2 * 3 * 4 = 24
     */
    private List<String> findAnagrams(String word) {

        if (word.length() == 1) {
            List<String> potentials = new ArrayList<>();
            potentials.add(word);
            return potentials;
        }

        List<String> anagrams = new ArrayList<>();
        char current = word.charAt(0);
        String subset = word.substring(1, word.length());

        List<String> potentials = findAnagrams(subset);
        insertCharAtEveryIndex(potentials, current, anagrams);
        return anagrams;
    }

    private void insertCharAtEveryIndex(List<String> potentials, char current, List<String> anagrams) {

        for (String potential : potentials) {

            for (int i = 0; i <= potential.length(); i++) {

                StringBuilder sb = new StringBuilder(potential);
                if (i < potential.length()) {
                    sb.insert(i, current);
                } else {
                    sb.append(current);
                }
                anagrams.add(sb.toString());
            }
        }
    }



    private static void pixelMain() {
        Recursion recursion = new Recursion();

        Recursion.Pixel p = new Recursion.Pixel("");

        Node node1 = new Node(5);
        node1.addChildren(new Node(4), new Node(6));
        node1.getRight().addChildren(new Node(7), new Node(8));
        Node node2 = new Node(5);
        node2.addChildren(new Node(4), new Node(6));
        node2.getRight().addChildren(new Node(7), new Node(8));

        System.out.println(recursion.sameTree(node1, node2));
    }

    private static void subsetsMain() {
        Recursion recursion = new Recursion();

        List<List<Integer>> subsets = new ArrayList<>();
        recursion.populateSubsets(subsets, recursion.integers);
        System.out.println(subsets);

    }

    /** Order of n: O(n) - need to visit every node in the smallest tree
     */
    //TODO implement this for linked lists
    private boolean sameTree(Node head1, Node head2) {

        if (head1 == null && head2 == null) {
            return true;
        }

        //both not null, check if either is null
        if (head1 == null) {
            return false;
        } else if (head2 == null) {
            return false;
        }

        if (sameTree(head1.getLeft(), head2.getLeft()) && sameTree(head1.getRight(), head2.getRight())) {
            return head1.getId() == head2.getId();
        }

        return false;

    }


    /**
     * Complexity of 2 raised to n: O(2^n)
     */
    private void populateSubsets(List<List<Integer>> subsets, List<Integer> list) {

        //recursion base case
        if (list.isEmpty()) {
            subsets.add(new ArrayList<>());
            return;
        }

        //remove current and get subsets of all remaining numbers
        int currentNum = list.remove(0);
        populateSubsets(subsets, list);

        //iterating and adding at the same time is complicated so create a new list to iterate
        List<List<Integer>> iteratingList = new ArrayList<>(subsets);

        //current number is appended to every subset
        for (List<Integer> subset : iteratingList) {

            //copy the subset, and add the currentNum to it, then add to subsets
            List<Integer> newSubset = new ArrayList<>(subset);
            newSubset.add(currentNum);
            subsets.add(newSubset);
        }
    }

    /** O(n) - need to visit every cell */
    private void paintFill(Pixel[][] displayScreen, int x, int y, String originalColor, String newColor) {

        if (x < 0 || y < 0 || x >= displayScreen[0].length || y >= displayScreen.length) {
            return;
        }

        if (displayScreen[y][x].getColor().equals(originalColor)) {
            displayScreen[y][x].setColor(newColor);

            //left
            paintFill(displayScreen, x - 1, y, originalColor, newColor);
            //top
            paintFill(displayScreen, x, y - 1, originalColor, newColor);
            //right
            paintFill(displayScreen, x + 1, y, originalColor, newColor);
            //bottom
            paintFill(displayScreen, x, y + 1, originalColor, newColor);
        }
    }

    //static class won't be instantiated with outer class
    private static class Pixel {

        private String color;

        public Pixel(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }
}


