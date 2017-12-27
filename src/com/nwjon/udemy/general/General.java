package com.nwjon.udemy.general;

import java.util.ArrayList;
import java.util.List;

public class General {

    public static void main(String... varargs) {

        List<Point> points = new ArrayList<>();
        points.add(new Point(5,7));
        points.add(new Point(10,8));
        points.add(new Point(9,9));
        points.add(new Point(2,1));

        Point point = new Point(3,3);

        for (Point p : points) {
            System.out.println(p.isWithinDistance(point, 5));
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
