package com.nwjon.udemy.general;

public class Palindrome {

    public static void main(String... args) {

        System.out.println(palindrome("cool"));
    }

    public static boolean palindrome(String data) {

        data = data.replaceAll(" ", "").toLowerCase();

        int start = 0;
        int end = data.length() - 1;
        char[] chars = data.toCharArray();

        while (start < end) {

            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


}
