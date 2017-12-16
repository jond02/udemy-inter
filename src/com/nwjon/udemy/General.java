package com.nwjon.udemy;

public class General {

    public static void main(String... varargs) {

        System.out.println(palindrome("lonely Tylenol"));


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
