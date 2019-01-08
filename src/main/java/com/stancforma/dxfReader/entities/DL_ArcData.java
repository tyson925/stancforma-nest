package com.stancforma.dxfReader.entities;

public class DL_ArcData {


    /*! X Coordinate of center point. */
    double cx;
    /*! Y Coordinate of center point. */
    double cy;
    /*! Z Coordinate of center point. */
    double cz;

    /*! Radius of arc. */
    double radius;
    /*! Startangle of arc in degrees. */
    double angle1;
    /*! Endangle of arc in degrees. */
    double angle2;

    public DL_ArcData(double cx, double cy, double cz, double radius, double angle1, double angle2) {
        this.cx = cx;
        this.cy = cy;
        this.cz = cz;
        this.radius = radius;
        this.angle1 = angle1;
        this.angle2 = angle2;
    }
}
