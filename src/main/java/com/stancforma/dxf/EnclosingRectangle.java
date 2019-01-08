package com.stancforma.dxf;

public class EnclosingRectangle {
    double xmin = Double.MAX_VALUE;
    double xmax = -Double.MIN_VALUE;
    double ymin = Double.MAX_VALUE;
    double ymax = Double.MIN_VALUE;

    double width() {
        return xmax - xmin;
    }

    double height() {
        return ymax - ymin;
    }

    public void enclose(double x, double y) {
        if (xmin > x) xmin = x;
        if (xmax < x) xmax = x;
        if (ymin > y) ymin = y;
        if (ymax < y) ymax = y;
    }

    public  void enclose(EnclosingRectangle rect) {
        enclose(rect.xmin, rect.ymin);
        enclose(rect.xmax, rect.ymax);
    }

    public boolean isContaining(double x, double y) {
        return xmin <= x && xmax >= x && ymin <= y && ymax >= y;
    }

    public boolean isIntersecting(EnclosingRectangle r) {
        return isContaining(r) || r.isContaining(this) || r.isContaining(xmin, ymin) || r.isContaining(xmax, ymin) || r.isContaining(xmax, ymax) || r.isContaining(xmin, ymax);
    }

    public boolean isContaining(EnclosingRectangle r) {
        return xmin <= r.xmin && xmax >= r.xmax && ymin <= r.ymin && ymax >= r.ymax;
    }

    public double area() {
        return width() * height();
    }
}
