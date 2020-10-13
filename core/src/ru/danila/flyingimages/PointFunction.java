package ru.danila.flyingimages;

import ru.danila.flyingimages.Point;

public class PointFunction {
    Point start;
    float dx, dy;

    PointFunction() {
        start = new Point();
        dx = 1; dy = 1;
    }

    PointFunction(long sx, long sy) {
        this.start = new Point(sx, sy);
        this.dx = 1; this.dy = 1;
    }

    PointFunction(long sx, long sy, long dx, long dy) {
        this.start = new Point(sx, sy);
        this.dx = dx; this.dy = dy;
    }

    PointFunction(long sx, long sy, float dx, float dy) {
        this.start = new Point(sx, sy);
        this.dx = dx; this.dy = dy;
    }

    PointFunction(float sx, float sy) {
        start = new Point(sx, sy);
        dx = 1; dy = 1;
    }

    PointFunction(float sx, float sy, long dx, long dy) {
        this.start = new Point(sx, sy);
        this.dx = dx; this.dy = dy;
    }

    PointFunction(float sx, float sy, float dx, float dy) {
        this.start = new Point(sx, sy);
        this.dx = dx; this.dy = dy;
    }

    Point get(float x, float y) {
        Point result = new Point();
        result.x = start.x + x*dx;
        result.y = start.y + y*dy;
        return result;
    }
}
