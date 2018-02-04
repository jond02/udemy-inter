package com.nwjon.udemy.general;

import java.util.ArrayList;
import java.util.List;

public class General {

    public static void main(String... varargs) {

//        List<Point> points = new ArrayList<>();
////        points.add(new Point(5,7));
////        points.add(new Point(10,8));
////        points.add(new Point(9,9));
////        points.add(new Point(2,1));
////
////        Point point = new Point(3,3);
////
////        for (Point p : points) {
////            System.out.println(p.isWithinDistance(point, 5));
////        }

        //String s = "lonely tylenol";
        //System.out.println(s.substring(1, s.length()));

        System.out.println(palindromeStart("Lonely tylenol"));
    }

    private static boolean palindromeStart(String s) {

        if (s == null) {
            throw new NullPointerException("input can't be null");
        }
        s = s.replaceAll(" ", "").toLowerCase();

        return palindromeRecur(s);
    }

    private static boolean palindromeRecur(String s) {

        if (s.length() < 2) {
            return true;
        } else {
            return s.charAt(0) == s.charAt(s.length() - 1) && palindromeRecur(s.substring(1, s.length() - 1));
        }
    }

    public static boolean palindrome(String data) {

        if (data == null) {
            return false;
        }
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
