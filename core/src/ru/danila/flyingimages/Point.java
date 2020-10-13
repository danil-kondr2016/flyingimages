package ru.danila.flyingimages;

public class Point {
    final float df = 0.5f;

    float x, y;

    Point() {
        this.x = 0;
        this.y = 0;
    }

    Point(byte x, byte y) {
        this.x = (float)x;
        this.y = (float)y;
    }

    Point(short x, short y) {
        this.x = (float)x;
        this.y = (float)y;
    }

    Point(int x, int y) {
        this.x = (float)x;
        this.y = (float)y;
    }

    Point(long x, long y) {
        this.x = (float)x;
        this.y = (float)y;
    }

    Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    void set(Point a) {
        this.x = a.x;
        this.y = a.y;
    }

    @Override
    public String toString() {
        String result = new String("(");
        result += this.x + " " + this.y + ")";
        return result;
    }

    public boolean equals(Point b) {
        boolean result = true;

        if ((Math.abs(this.x - b.x) > df) || (Math.abs(this.y - b.y) > df))
            result = false;

        return result;
    }
}
