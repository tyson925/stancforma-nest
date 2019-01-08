package com.stancforma.dxfReader.entities;

public class DL_CircleData {


    /*! X Coordinate of center point. */
    double cx;
    /*! Y Coordinate of center point. */
    double cy;
    /*! Z Coordinate of center point. */
    double cz;

    /*! Radius of arc. */
    double radius;

    public DL_CircleData(double cx, double cy, double cz, double radius) {
        this.cx = cx;
        this.cy = cy;
        this.cz = cz;
        this.radius = radius;
    }
}
