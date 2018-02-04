package com.nwjon.udemy.sortsearch;

import java.util.Arrays;

public class Sorting {

    //Questions about trade offs in sorting algorithms

    //what is the complexity of the sort
    //how much space does it occupy - does it need extra space to hold information during sort
    //stable sort - original order is maintained for elements with same value
    //how many comparisons and how many swaps are needed. Does it work better on nearly sorted lists?
    //is the sort adaptive - does it break early when the list is sorted

    private static final int[] list = {4, 5, 6, 2, 1, 7, 10, 3, 8, 9};
    private static final int[] list2 = {1, 2, 3, 4, 5, 6, 7, 8, 10, 9};

    public static void main(String[] args) {

        Sorting sorting = new Sorting();
        sorting.mergeSort(list);

        sorting.print(list);

    }

    /**
     * Quick Sort - uses divide and conquer to create smaller problems that are easier to handle.
     * Average complexity is O(n log n)
     * Not adaptive
     * takes O(log n) in call stack
     * Not stable
     * Usually preferred to merge sort
     * Reading from cache to better than merge sort
     * Fast, but requires some memory space
     * @param list
     * @param low
     * @param high
     */
    private void quickSort(int[] list, int low, int high) {

        if (low >= high) {
            return;
        }

        int pivot = partition(list, low, high);
        quickSort(list, low, pivot - 1);
        quickSort(list, pivot + 1, high);
    }


    private int partition(int[] list, int low, int high) {

        int pivot = list[low];
        int l = low;
        int h = high;

        while (l < h) {

            while (list[l] <= pivot && l < h) {
                h++;
            }
            while (list[h] > pivot) {
                h--;
            }
            if (l < h) {
                swap(list, l, h);
            }
        }
        swap(list, low, h);

        System.out.println("Pivot: " + pivot);
        print(list);
        return h;
    }




    /**
     * Merge Sort - Uses divide and conquer to create smaller problems that are easier to handle.
     * Complexity is O(n log n)
     * Not adaptive
     * O(n) for extra space for smaller created lists
     * Stable
     * Use for fast processing times where extra space is not an issue
     * The best worst case sorting algorithm
     * @param list
     */
    private void mergeSort(int[] list) {

        if (list.length == 1) {
            return;
        }

        int iMid = list.length / 2 + list.length % 2;
        int[] firstHalf = new int[iMid];
        int[] secondHalf = new int[list.length - iMid];
        split(list, firstHalf, secondHalf);

        mergeSort(firstHalf);
        mergeSort(secondHalf);

        merge(list, firstHalf, secondHalf);

    }

    private void split(int[] list, int[] firstHalf, int[] secondHalf) {

        int secondHalfStart = firstHalf.length;

        for (int i = 0; i < list.length; i++) {

            if (i < secondHalfStart) {
                firstHalf[i] = list[i];
            } else {
                secondHalf[i - secondHalfStart] = list[i];
            }
        }
    }

    private void merge(int[] list, int[] firstHalf, int[] secondHalf) {

        int iMerge = 0;
        int iFirst = 0;
        int iSecond = 0;

        while (iFirst < firstHalf.length && iSecond < secondHalf.length) {

            if (firstHalf[iFirst] < secondHalf[iSecond]) {
                list[iMerge] = firstHalf[iFirst];
                iFirst++;
            } else {
                list[iMerge] = secondHalf[iSecond];
                iSecond++;
            }
            iMerge++;
        }

        //copy over remaining elements if one of the lists was longer
        if (iFirst < firstHalf.length) {
            while (iMerge < list.length) {
                list[iMerge++] = firstHalf[iFirst++];
            }
        }
        if (iSecond < secondHalf.length) {
            while (iMerge < list.length) {
                list[iMerge++] = secondHalf[iSecond++];
            }
        }

    }









    /**
     * Shell Sort - use insertion sort, entire list is divided and sub-lists are sorted
     * Order of complexity not easily defined. Is somewhere between O(n) and O(n^2)
     * Different values of the increments produce different complexities
     * Adaptive
     * Not stable
     * O(1) for space, takes no extra space
     * @param list
     */
    private void shellSort(int[] list) {

        int inc = list.length / 2;

        while (inc >= 1) {
            for (int start = 0; start < inc; start++) {
                insertionSortForShell(list, start, inc);
            }
            inc /= 2;
        }
    }

    private void insertionSortForShell(int[] list, int start, int inc) {

        for (int i = start; i < list.length; i = i + inc) {

            //defaults to basic insertion sort if 1?
            int a = Math.min(i + inc, list.length - 1);

            for (int j = a; j - inc >= 0; j = j - inc) {

                if (list[j] < list[j - inc]) {
                    swap(list, j, j -inc);
                } else {
                    break;
                }
                print(list);
            }
        }
    }


    /**
     * O(n^2) complexity - worst case list is in descending order, and every element needs to be swapped on
     * every iteration
     * Insertion Sort - Start with a sorted list of 1 element on left, and bubble the element on the right
     * of the list ot the right position in sorted list
     * Adaptive
     * Takes no extra space O(1) - in place sorting
     * O(n^2) comparisons and O(n^2) swaps
     *
     * low overhead and is traditionally the sort choice when used with faster divide and conquer algorithms
     * bubble sort takes one additional pass to ensure list is sorted
     * bubble sort has to do n comparisons at every step. Insertion can stop comparing when the right position
     * in sorted sub-list is found - average case fewer comparisons
     * Number of writes and swaps for bubble tend to be large, don't perform well in case of cache hits, why
     * insertion sort has lower overhead
     * @param list
     */
    private void insertionSort(int[] list) {

        // - 1 because left element is already sorted as a 1 element sub-list
        for (int i = 0; i < list.length - 1; i++) {

            //j grows until it become length of entire list
            for (int j = i + 1; j > 0; j--) {

                if (list[j] < list[j - 1]) {
                    swap(list, j, j - 1);
                } else {
                    break;
                }
                print(list);
            }
        }
    }


    /**
     * O(n^2) complexity - worst case list is in descending order, and every element needs to be swapped on
     * every iteration
     * Bubble Sort - Core of bubble sort is comparing adjacent elements and swapping if needed.
     * Stable
     * Adaptive - swapped flag can break loop early - key advantage
     * Takes no extra space O(1) - in place sorting
     * O(n^2) comparisons and O(n^2) swaps (swaps higher than selection sort)
     * Inner loop can start from beginning or end of list
     * @param list
     */
    private void bubbleSort(int[] list) {

        for (int i = 0; i < list.length; i++) {

            boolean swapped = false;
            for (int j = list.length - 1; j > i; j--) {

                if (list[j] < list[j - 1]) {
                    swap(list, j, j - 1);
                    swapped = true;
                }
            }
            print(list);
            if (!swapped) {
                break;
            }
        }
    }

    void myBubbleSort(int[] list) {

        //go through list, in worst case will need to loop as many times as there are elements
        //this could be a while loop that breaks when there are no more swaps
        for (int i = 0; i < list.length; i++) {

            boolean swap = false;

            //at the end of each pass the largest index will have the largest value, so can reduce
            //the indices to check by i, along with 1 because j will be compared with the next value
            for (int j = 0; j < list.length - i - 1; j++) {

                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swap = true;
                    print(list);
                }
            }
            System.out.println("iter");
            if (!swap) {
                break;
            }
        }
    }

    void myWhileBubbleSort(int[] list) {

        boolean isSorted = false;
        int limit = list.length - 1;

        while (!isSorted) {

            isSorted = true;

            for (int i = 0; i < limit; i++) {

                if (list[i] > list[i + 1]) {
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    isSorted = false;
                }
            }
            limit--;
        }
        print(list);
    }

    /**
     * Selection Sort - O(n^2) Order of n squared, not stable, constant space (sorted in place, no extra space),
     * Each index selects the smallest number from what is left
     * O(n) swaps, not an adaptive sort. Very naive sorting, not typically used.
     * @param list
     */
    private void selectionSort(int[] list) {

        //{4, 5, 3, 2, 1, 7, 10, 3, 8, 9};

        for (int i = 0; i < list.length; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[i] > list[j]) {
                    swap(list, i, j);
                    print(list);
                }
            }
        }
    }

    private void print(int[] list) {
        System.out.println(Arrays.toString(list));
    }

    private void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }



}
