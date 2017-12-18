package com.nwjon.udemy.general;

public class Point {

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
