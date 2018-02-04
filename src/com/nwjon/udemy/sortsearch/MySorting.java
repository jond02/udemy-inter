package com.nwjon.udemy.sortsearch;

import java.util.Arrays;

public class MySorting {

    private static final int[] list = {4, 5, 6, 2, 1, 7, 10, 3, 8, 9};
    private static final int[] list2 = {1, 2, 3, 4, 5, 6, 7, 8, 10, 9};

    public static void main(String[] args) {

        MySorting sorting = new MySorting();
        sorting.myInsertionSort2(list);
        sorting.print(list);

    }

    //selection sort - selects the lowest available number for each index

    //bubble sort - on each pass bubbles the lowest value to the beginning, or other way around

    //insertion sort - evals the number to the right of the sorted list, and places it in sorted spot



    private void myInsertionSort(int[] list) {

        //the first index is sorted by itself, so don't need to consider it in loop
        for (int i = 0; i < list.length - 1; i++) {

            //go over sorted section of list and place element in sorted index
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

    void myInsertionSort2(int[] list) {

        for (int i = 0; i < list.length - 1; i++) {

            for (int j = i + 1; j > 0; j--) {

                if (list[j] < list[j - 1]) {
                    int temp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    void mySelectionSort(int[] list) {

        //{4, 5, 6, 2, 1, 7, 10, 3, 8, 9}

        /*go through list, fill each index with smallest available value*/
        for (int i = 0; i < list.length; i++) {

            System.out.println("iter");
            //as find small values move them up, looking through each index past the current one
            //the current index i, receives the smallest found value
            for (int j = i + 1; j < list.length; j++) {

                if (list[i] > list[j]) {
                    int temp = list[i];

                    //move smaller value to index
                    list[i] = list[j];

                    //throw larger value back into unsorted part of array
                    list[j] = temp;
                    print(list);
                }
            }
        }
    }

    void mySelectionSort2(int[] list) {

        for (int i = 0; i < list.length; i++) {

            for (int j = i + 1; j < list.length; j++) {

                if (list[j] < list[i]) {
                    int temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
            print(list);
        }
    }

    private void print(int[] list) {
        System.out.println(Arrays.toString(list));
    }
}
