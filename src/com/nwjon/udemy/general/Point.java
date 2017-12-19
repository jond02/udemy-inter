package com.nwjon.udemy.general;

import java.util.ArrayList;
import java.util.List;

public class Point {

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

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getDistance(Point point2) {
        return Math.sqrt(Math.pow(point2.x - x, 2) + (Math.pow(point2.y - y, 2)));
    }

    public boolean isWithinDistance(Point point2, double distance) {

        //check if x or y are out of range first
        if (Math.abs(point2.x - x) > distance || (point2.y - y) > distance) {
            return false;
        } else {
            return getDistance(point2) <= distance;
        }
    }
}
