package com.nwjon.udemy.sortsearch;

import java.util.Arrays;

class MySorting2 {

    private static final int[] list = {4, 5, 6, 2, 1, 7, 10, 3, 8, 9};

    public static void main(String[] args) {
        MySorting2 sorting = new MySorting2();
        sorting.myInsertionSort(list);
        System.out.println(Arrays.toString(list));
    }

    private void myInsertionSort(int[] list) {

        if (list == null) {
            return;
        }

        for (int i = 0; i < list.length - 1; i++) {

            for (int j = i + 1; j > 0; j--) {

                if (list[j] < list[j - 1]) {
                    int temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
                } else {
                    break;
                }
            }
        }


    }

    private void myBubbleSort(int[] list) {

        //loop over list, on each iteration swap values if not in order, break if no swaps

        boolean swapped;

        for (int i = 0; i < list.length; i++) {

            swapped = false;

            //on each iteration the last index will have received the highest value, so don't need to eval
            //minus 1 because j + 1 will be checked in comparison

            for (int j = 0; j < list.length - 1 - i; j++) {

                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }


    private void myReverseBubbleSort(int[] list) {

        boolean swapped;
        for (int i = 0; i < list.length; i++) {
            swapped = false;

            //j > i because the beginning of the list is given the lowest value on each iteration
            for (int j = list.length - 1; j > i; j--) {

                if (list[j] < list[j - 1]) {
                    int temp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    private void mySelectionSort(int[] list) {

        //loop over every index and place smallest available element in index
        //beginning of list is sorted, end is unsorted

        for (int i = 0; i < list.length; i++) {

            for (int j = i + 1; j < list.length; j++) {

                if (list[i] > list[j]) {
                    int temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
    }
}
