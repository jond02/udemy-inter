package com.nwjon.udemy.recursion;

public class Recursion2 {


    public static void main(String[] args) {
        System.out.println(factorial(4));
    }

    private static void count(int i) {

        System.out.println(i);

        if (i != 0) {
            count(--i);
        }
    }

    private static long factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

}
