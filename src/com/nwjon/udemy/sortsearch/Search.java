package com.nwjon.udemy.sortsearch;

public class Search {

    private static final int[] list = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};


    public static void main(String[] args) {

        Search search = new Search();
        System.out.println(search.binarySearchRecur(list, 5));

//        int min = 2;
//        int max = 11;
//        System.out.println(min + (max - min) / 2);
//        System.out.println(min + (max / 2) );

    }

    //15 -- 20 -- 25
    //25 - 15 = 10 / 2 = 5
    //15 + 5 = 20

    private int binarySearchRecur(int[] list, int number) {
        if (list == null) {
            throw new IllegalArgumentException("List can't be null");
        }
        return binarySearchRecur(list, number, 0, list.length - 1);
    }


    /**
     * Iterative version doesn't need as much space, there is not a recursive stack
     */
    private int binarySearchRecur(int[] list, int number, int min, int max) {

        if (min > max) {
            return -1;
        }

        int mid = min + (max - min) / 2;
        if (list[mid] == number) {
            return mid;
        }

        if (list[mid] > number) {
            return binarySearchRecur(list, number, min, mid - 1);
        } else {
            return binarySearchRecur(list, number, mid + 1, max);
        }
    }


    /**
     * Order of log n: O(log n)
     * @param list
     * @param number
     * @return
     */
    private int binarySearch(int[] list, int number) {

        int min = 0;
        int max = list.length - 1;

        while (min <= max) {

            int mid = min + (max - min) / 2;

            if (list[mid] == number) {
                return mid;
            }

            if (list[mid] > number) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return -1;
    }

    private int myBinarySearch(int[] list, int number) {

        int min = 0;
        int max = list.length - 1;

        while (min <= max) {

            int mid = min + (max - min) / 2;

            if (list[mid] == number) {
                return mid;
            }

            if (list[mid] > number) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return -1;

    }
















}
