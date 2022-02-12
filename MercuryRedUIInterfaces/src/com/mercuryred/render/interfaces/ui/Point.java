package com.mercuryred.render.interfaces.ui;




public class Point {

    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;

        if (!(obj instanceof Point)) return false;

        Point p = (Point) obj;

        return this.x == p.x && this.y == p.y;
    }
}