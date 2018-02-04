package com.nwjon.udemy.sortsearch;

public class BigO {

    public static void main(String[] args) {
        BigO bigO = new BigO();
        bigO.nestedForLoops(200);
    }

    public void simpleMethod(int n) {

        //constant time, order of 1: O(1)

        int a = 9;
        int b = 3;

        int sum = a + b + n;
        int product = a * b * n;
        int quotient = a * n / b;

        System.out.println(String.format("The sum is: %s, product is: %s, and quotient is: %s", sum, product, quotient));
    }

    public void singleForLoop(int n) {

        //linear time, order of n: O(n)

        for (int i = 0; i < n; i++) {
            System.out.println(String.format("Square of %s is %s", i, Math.pow(i, 2)));
        }
    }

    public void ifStatement(int n) {

        //linear time, order of n: O(n)
        //complexity is based on worst case scenario

        if (n % 2 == 0) {
            System.out.println("The input is even");
        } else {
            for (int i = 0; i < n; i++) {
                System.out.println("Printing: " + i);
            }
        }
    }

    public void nestedForLoops(int n) {

        //quadratic time, order of n squared: O(n^2)
        //nested for loops is multiplicative complexity

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(String.format("Product of %s and %s is %s", i , j, i * j));
            }
        }
    }

    public void twoLoops(int n, int m) {

        //additive, O(n + m)
        //loops one after another is additive complexity

        for (int i = 0; i < n; i++) {
            System.out.println("hi");
        }

        for (int i = 0; i < m; i++) {
            System.out.println("again");
        }
    }

    public void twoForLoopsNested(int n, int m) {

        //multiplicative, O(n * m)

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println("multiply");
            }
        }
    }

    public void nestedForLoopsWithNonNested(int n) {

        //With two loops the complexity is actually O(n^2 + n), but the lower order terms are ignored
        //quadratic time, order of n squared: O(n^2)

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(String.format("Product of %s and %s is %s", i, j, i * j));
            }
        }

        for (int j = 0; j < n; j++) {
            System.out.println("hi");
        }
    }




}
